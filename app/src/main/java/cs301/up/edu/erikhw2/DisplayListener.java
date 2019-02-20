package cs301.up.edu.erikhw2;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * <!-- class DisplayListener -->
 *
 * This class is a listener for the surfaceView. It stores instance variables
 * of the various xml objects that need to be updated after touch events.
 *
 * @author Erik Torkelson
 * Date: February 19, 2019
 *
 */
public class DisplayListener implements View.OnTouchListener {

    private TextView currentElement;
    private Display display;
    private SeekBar red, green, blue;

    /**
     * Constructor to create a surfaceView listener for my custom surfaceView.
     *
     *
     * @param currentElement TextView displaying the name of current element
     * @param display Reference to surfaceView object
     * @param red Reference to red seekBar
     * @param green Reference to green seekBar
     * @param blue Reference to blue seekBar
     */
    public DisplayListener(TextView currentElement, Display display,
                           SeekBar red, SeekBar green, SeekBar blue) {
        this.currentElement = currentElement;
        this.display = display;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * onTouch processes each touch event on the screen. It finds the
     * coordinates of the touch and passes them to a method to check if
     * the touch was on an element.
     *
     * @param v Reference to surfaceView object which was touched
     * @param event Contains information about the touch such as coordinate
     * @return
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int xTouch = (int)event.getX();
        int yTouch = (int)event.getY();

        this.display.checkTouch(xTouch, yTouch,
                currentElement, red, green, blue);

        this.display.invalidate();
        return true;
    }
}
