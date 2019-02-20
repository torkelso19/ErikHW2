package cs301.up.edu.erikhw2;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * <!-- class CustomElement -->
 *
 * This class defines an element of a drawing. All such elements must have
 * certain methods and variables to work with this app.
 *
 * @author Andrew Nuxoll
 * @author Erik Torkelson
 * Date: February 19, 2019
 *
 */
public abstract class CustomElement {

    /**
     * this is the "fudge factor" for determining whether a tap falls within a
     * given shape. The value is specified in display pixels (dp)
     */
    public static final int TAP_MARGIN = 10;

    /** This defines the main color that the element will be drawn with */
    protected Paint myPaint = new Paint();

    /** this color is used to draw outlines around a shape */
    protected Paint outlinePaint = new Paint();

    /**
     * This gives the element a name for identification. This need not be unique
     * but it's helpful
     */
    private String myName = "$NO NAME$";

    /** the ctor requires that you give the object a name and a color */
    public CustomElement(String name, int color) {
        // init instance variables
        setColor(color);
        this.myName = name;

        // black is an obvious choice for outlines
        this.outlinePaint.setColor(Color.BLACK);
        this.outlinePaint.setStyle(Paint.Style.STROKE);

    }

    /** get the element's given name */
    public String getName() {
        return this.myName;
    }

    /** change the color */
    public void setColor(int color) {

        // ignore request if it's not a new color (this keeps the undo queue
        // clean)
        if (color == myPaint.getColor())
            return;

        // make the change
        this.myPaint.setColor(color);
    }

    /** get the color */
    public int getColor() {
        return this.myPaint.getColor();
    }


    /*
     * ===================================================================
     * Abstract Methods
     * -------------------------------------------------------------------
     */

    /** an element must be able to paint itself */
    public abstract void drawMe(Canvas canvas);

    /**
     * an element must be able to tell whether a given x,y coordinate falls
     * within the bounds of its shape. This is used for tap purposes so a tap
     * that is close to being inside should still count. Use the TAP_MARGIN
     * constant as a guide for fudge factor. When implementing this method, you
     * may find the {@link android.graphics.Rect.contains} method handy.
     */
    public abstract boolean containsPoint(int x, int y);


}// class CustomElement
