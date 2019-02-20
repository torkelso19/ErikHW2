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
 * This class extends a surfaceView to add drawing for showing a simple
 * house and 2 trees. It contains six different shapes that one can control
 * the color of.
 *
 * It contains all the information for drawing the objects and setting the
 * current element which is the most recently pressed one.
 *
 * @author Erik Torkelson
 * Date: February 19, 2019
 *
 */
public class Display extends SurfaceView {

    //Instance variables to keep track of elements to draw
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


    /**
     * Constructors for the custom surfaceView call the constructor for a
     * surfaceView with super() and then call init to begin custom drawing.
     *
     * @param context
     */
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
     * init creates the six objects to be drawn on the surfaceView. They are
     * all added to an arrayList containing all elements and the current
     * element is set to null
     *
     */
    private void init() {
        setWillNotDraw(false);


        //Creates all 6 element objects
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

        //Adds element objects to arraylist containing all elements
        this.allElements.add(house);
        this.allElements.add(roof);
        this.allElements.add(treeTrunk1);
        this.allElements.add(treeTrunk2);
        this.allElements.add(treeTop1);
        this.allElements.add(treeTop2);

        //Initializes current element so that it starts off unselected
        this.currentElement = null;
    }


    /**
     * onDraw draws all the elements in the allElements arrayList to the
     * surfaceView
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
     * checkTouch checks if a given touch location is within the bounds of
     * any of the elements in the arrayList allElements. If there is such an
     * element, it sets it to the current element and changes the textView
     * displaying the current element to the new current element. That elements
     * color components are extracted and set the seekBar progresses.
     *
     * @param x coordinate of touch
     * @param y coordinate of touch
     * @param currentText Textview that displays the current element
     * @param red reference to seekbar controlling red color component
     * @param green reference to seekbar controlling green color component
     * @param blue reference to seekbar controlling blue color component
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
     * getCurrentElement returns the current element instance variable
     *
     * @return the current element selected on the gui
     */
    public CustomElement getCurrentElement (){
        return this.currentElement;
    }

}
