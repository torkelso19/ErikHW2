package cs301.up.edu.erikhw2;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;


/**
 * <!-- class CustomTriangle -->
 *
 * This class
 *
 * @author Erik Torkelson
 * @see CustomElement
 */
public class CustomTriangle extends CustomElement {

    private Path triangle;

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
     * drawMe
     *
     * @param canvas
     */
    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawPath(triangle, myPaint);
        canvas.drawPath(triangle, outlinePaint);
    }

    /**
     * containsPoint
     *
     * @param x integer coordinate
     * @param y integer coordinate
     * @return true if the point is contained in the triangle
     */
    @Override
    public boolean containsPoint(int x, int y) {
        if ((y < 400) & ((x > 650) & (x < (1920 - 650))) & (y > 150)) {
            if (x < 960) {
                if (y > (double)(x*-25)/(double)31+924.2) {
                    return true;
                }
            } else {
                if (y > (double)(x*25)/(double)31-624.2) {
                    return true;
                }
            }

        }

        return false;
    }


    /**
     * getSize
     *
     */
    @Override
    public int getSize() {
        return 0;
    }


    /**
     * drawHighlight
     *
     * @param canvas
     */
    @Override
    public void drawHighlight(Canvas canvas) {
        canvas.drawPath(triangle, highlightPaint);
        canvas.drawPath(triangle, outlinePaint);
    }
}
