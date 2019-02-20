package cs301.up.edu.erikhw2;

import android.graphics.Canvas;

/**
 * <!-- class CustomCircle -->
 *
 * This class defines a custom drawing element that is a circle.
 *
 * @author Andrew Nuxoll
 * @author Erik Torkelson
 * Date: February 19, 2019
 * @see CustomElement
 *
 */

public class CustomCircle extends CustomElement {

    /** these variables define the location and radius of a circle */
    private int x;
    private int y;
    private int radius;

    /** the circle's dimensions must be defined at construction */
    public CustomCircle(String name, int color, int x, int y, int radius)
    {
        super(name, color);

        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    /**
     * drawMe draws this circle element onto the canvas given
     *
     * @param canvas is passed from the surfaceView's canvas
     */
    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawCircle(x, y, radius, myPaint);  //main circle
        canvas.drawCircle(x, y, radius, outlinePaint);  //outline around circle
    }


    /** for ease of calculation, just draw a box around the circle and see if
     * the point is in that */
    @Override
    public boolean containsPoint(int x, int y) {
        //Calculate the distance between this point and the center
        int xDist = Math.abs(x - this.x);
        int yDist = Math.abs(y - this.y);
        int dist = (int)Math.sqrt(xDist*xDist + yDist*yDist);  //Pythagoras :)

        return (dist < this.radius + TAP_MARGIN);
    }//containsPoint

}//class CustomCircle
