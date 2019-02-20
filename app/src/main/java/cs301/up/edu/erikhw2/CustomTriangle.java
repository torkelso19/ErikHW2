package cs301.up.edu.erikhw2;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;


/**
 * <!-- class CustomTriangle -->
 *
 * This class defines a custom drawing element that is a triangle.
 *
 * @author Erik Torkelson
 * @see CustomElement
 */
public class CustomTriangle extends CustomElement {

    // Instance variable that contains the path the lines of the triangle occupy
    private Path triangle;

    /**
     * Constructor for creating a triangle element. It requires the following
     * parameters:
     *
     * @param name The name of element to reference it
     * @param color The integer hex value of the color of the element
     * @param a The first point of the triangle
     * @param b The second point of the triangle
     * @param c The third point of the triangle
     */
    public CustomTriangle(String name, int color, Point a, Point b, Point c)
    {
        super(name, color);

        /**
         * External Citation
         *  Date:        2/17/19
         *  Problem:     Didn't know how to draw a triangle
         *  Resource:    https://stackoverflow.com/questions/20544668/
         *               how-to-draw-filled-triangle-on-android-canvas/22690364
         *  Solution:    Used adaptation of code from website
         */
        this.triangle = new Path();
        this.triangle.setFillType(Path.FillType.EVEN_ODD);
        this.triangle.moveTo(a.x, a.y);
        this.triangle.lineTo(b.x, b.y);
        this.triangle.lineTo(c.x, c.y);
        this.triangle.lineTo(a.x, a.y);
        this.triangle.close();
    }

    /**
     * drawMe draws this triangle element onto the canvas given
     *
     * @param canvas is passed from the surfaceView's canvas
     */
    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawPath(triangle, myPaint);
        canvas.drawPath(triangle, outlinePaint);
    }

    /**
     * containsPoint checks if the given x and y coordinates are contained
     * inside the triangle element. The math for the method was calculated on
     * paper and accurately represents the exact borders of the triangle.
     *
     * @param x integer coordinate
     * @param y integer coordinate
     * @return true if the point is contained in the triangle, false otherwise
     */
    @Override
    public boolean containsPoint(int x, int y) {
        //Check if touch is within a box around the triangle
        if ((y < 400) & ((x > 650) & (x < (1920 - 650))) & (y > 150)) {
            //Left half of triangle calculations
            if (x < 960) {
                //Check if point is within bounds of a line I calculated
                if (y > (double)(x*-25)/(double)31+924.2) {
                    return true;
                }
            //Right half of triangle calculations
            } else {
                //Check if point is within bounds of a line I calculated
                if (y > (double)(x*25)/(double)31-624.2) {
                    return true;
                }
            }
        }
        return false;
    }
}
