package cs301.up.edu.erikhw2;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;



/**
 * <!-- class DisplayListener -->
 *
 * This class
 *
 * @author Erik Torkelson
 *
 */
public class DisplayListener implements View.OnTouchListener {

    private TextView currentElement;
    private Display display;
    private SeekBar red, green, blue;

    public DisplayListener(TextView currentElement, Display display,
                           SeekBar red, SeekBar green, SeekBar blue) {
        this.currentElement = currentElement;
        this.display = display;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * onTouch
     *
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
