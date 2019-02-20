package cs301.up.edu.erikhw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * <!-- class Display -->
 *
 * This class
 *
 * @author Erik Torkelson
 *
 */
public class Display extends SurfaceView {

    private ArrayList<CustomElement> allElements = new ArrayList<>();
    private CustomElement currentElement;

    //Main House Square
    private final static int WIDTH = 1920;
    private final static int HEIGHT = 940;

    private final static int HOUSE_COLOR = 0xFFF2DFB4;
    private final static int HOUSE_LEFT = 650;
    private final static int HOUSE_TOP = 400;
    private final static int HOUSE_RIGHT = WIDTH - 650;
    private final static int HOUSE_BOTTOM = HEIGHT;

    //Main House Roof
    private final static int ROOF_COLOR = 0xFF855E42;

    //Tree Trunk
    private final static int TRUNK_COLOR = 0xFF654321;
    private final static int TRUNK_LEFT = 250;
    private final static int TRUNK_TOP = 400;
    private final static int TRUNK_RIGHT = 350;
    private final static int TRUNK_BOTTOM = HEIGHT;

    private final static int TRUNK2_LEFT = WIDTH - TRUNK_RIGHT;
    private final static int TRUNK2_RIGHT = WIDTH - TRUNK_LEFT;

    //Tree Top
    private final static int TREE_TOP_COLOR = 0xFF009900;
    private final static int TREE_TOP_CENTER_X1 = 300;
    private final static int TREE_TOP_CENTER_X2 = WIDTH - 300;
    private final static int TREE_TOP_CENTER_Y = 250;
    private final static int TREE_TOP_RADIUS = 200;

    public Display(Context context) {
        super(context);
        init();
    }

    public Display(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Display(Context context, AttributeSet attrs,
                   int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    /**
     * init
     *
     */
    private void init() {
        setWillNotDraw(false);

        CustomRect house = new CustomRect("House Base", HOUSE_COLOR,
                HOUSE_LEFT, HOUSE_TOP, HOUSE_RIGHT, HOUSE_BOTTOM);

        CustomTriangle roof = new CustomTriangle("House Roof", ROOF_COLOR,
                new Point(HOUSE_LEFT, HOUSE_TOP),
                new Point(HOUSE_RIGHT, HOUSE_TOP),
                new Point(WIDTH/2, HOUSE_TOP -250));

        CustomRect treeTrunk1 = new CustomRect("Tree Trunk 1",
                TRUNK_COLOR, TRUNK_LEFT, TRUNK_TOP, TRUNK_RIGHT, TRUNK_BOTTOM);

        CustomRect treeTrunk2 = new CustomRect("Tree Trunk 2",
                TRUNK_COLOR, TRUNK2_LEFT, TRUNK_TOP,
                TRUNK2_RIGHT, TRUNK_BOTTOM);

        CustomCircle treeTop1 = new CustomCircle("Tree Top 1",
                TREE_TOP_COLOR, TREE_TOP_CENTER_X1, TREE_TOP_CENTER_Y,
                TREE_TOP_RADIUS);

        CustomCircle treeTop2 = new CustomCircle("Tree Top 2",
                TREE_TOP_COLOR, TREE_TOP_CENTER_X2, TREE_TOP_CENTER_Y,
                TREE_TOP_RADIUS);

        this.allElements.add(house);
        this.allElements.add(roof);
        this.allElements.add(treeTrunk1);
        this.allElements.add(treeTrunk2);
        this.allElements.add(treeTop1);
        this.allElements.add(treeTop2);

        this.currentElement = null;
    }


    /**
     * onDraw
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        for(CustomElement element : this.allElements) {
            element.drawMe(canvas);
        }
    }

    /**
     * checkTouch
     *
     * @param x
     * @param y
     * @param currentText
     * @param red
     * @param green
     * @param blue
     */
    public void checkTouch(int x, int y, TextView currentText, SeekBar red,
                           SeekBar green, SeekBar blue) {
        for (CustomElement element : this.allElements) {
            if (element.containsPoint(x, y)) {
                this.currentElement = element;
                currentText.setText("Current Piece: " +
                        this.currentElement.getName());
                int redAmount = Color.red(this.currentElement.getColor());
                int greenAmount = Color.green(this.currentElement.getColor());
                int blueAmount = Color.blue(this.currentElement.getColor());
                red.setProgress(redAmount);
                green.setProgress(greenAmount);
                blue.setProgress(blueAmount);
            }
        }
    }

    /**
     * getCurrentElement
     *
     * @return the current element selected on the gui
     */
    public CustomElement getCurrentElement (){
        return this.currentElement;
    }

}
