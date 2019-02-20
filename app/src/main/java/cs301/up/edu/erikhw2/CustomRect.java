package cs301.up.edu.erikhw2;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * <!-- class CustomRect -->
 *
 * This class defines a custom drawing element that is a rectangle.
 *
 * @author Andrew Nuxoll
 * @author Erik Torkelson
 * Date: February 19, 2019
 * @see CustomElement
 *
 */

public class CustomRect extends CustomElement {


    /** the position and size of the rectangle is stored here */
    private Rect myRect;

    /** the rectangles dimensions must be defined at construction */
    public CustomRect(String name, int color,
                      int left, int top, int right, int bottom)
    {
        super(name, color);

        this.myRect = new Rect(left, top, right, bottom);
    }


    /**
     * drawMe draws this rectangle element onto the canvas given
     *
     * @param canvas is passed from the surfaceView's canvas
     */
    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawRect(myRect, myPaint);  //main rectangle
        canvas.drawRect(myRect, outlinePaint);  //outline around rectangle
    }

    /**
     * containsPoint checks if the given x and y coordinates are contained
     * inside the rectangle element
     *
     * @param x integer coordinate
     * @param y integer coordinate
     * @return true if the point is contained in the rectangle, false otherwise
     */
    @Override
    public boolean containsPoint(int x, int y) {

        //Want to check for a tap within a slightly larger rectangle
        int left = this.myRect.left - TAP_MARGIN;
        int top = this.myRect.top - TAP_MARGIN;
        int right = this.myRect.right + TAP_MARGIN;
        int bottom = this.myRect.bottom + TAP_MARGIN;
        Rect r = new Rect(left, top, right, bottom);

        return r.contains(x, y);
    }//containsPoint

}//class CustomRect
