package cs301.up.edu.erikhw2;

import android.graphics.Color;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * <!-- class SeekBarListener -->
 *
 * This class implements the listener interface for a seekBar. It controls the
 * color value of the most recently touched element and updates the display.
 *
 * @author Erik Torkelson
 * Date: February 19, 2019
 */
public class SeekBarListener implements SeekBar.OnSeekBarChangeListener {

    /**Instance variables needed to get info about current element and set text
     * view to represent current seekBar location. Also contains the specific
     * seekBar color
     */
    private Display display;
    private TextView textDisplay;
    private SeekBarColor barColor;

    /**
     * Constructor to create a new seekBar listener. Requires the corresponding
     * textView in which to display value, surfaceview object, and the color
     * this seekBar controls
     *
     * @param text The textView this listener controls
     * @param display The surfaceView object
     * @param barColor The color this seekBar controls
     */
    public SeekBarListener(TextView text, Display display,
                           SeekBarColor barColor) {
        this.textDisplay = text;
        this.display = display;
        this.barColor = barColor;
    }

    /**
     * onProgressChanged updates as the seekBar is moved. It changes the text
     * next to the seekBar to show what the progress is at. Also the current
     * element's color is changed based on what the seekBar values are at.
     * Finally the display is updated.
     *
     * @param seekBar
     * @param progress
     * @param fromUser
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        //Update text box next to seekbar
        this.textDisplay.setText("" + progress);

        //Check there is a current element so it doesn't crash
        if (this.display.getCurrentElement() != null) {

            //Get color of current element and decode into rgb ints
            int previousColor = this.display.getCurrentElement().getColor();
            int colorRed = Color.red(previousColor);
            int colorGreen = Color.green(previousColor);
            int colorBlue = Color.blue(previousColor);

            //Change element color based on seekBar
            if (barColor == SeekBarColor.RED) {
                colorRed = progress;
            } else if (barColor == SeekBarColor.GREEN) {
                colorGreen = progress;
            } else {
                colorBlue = progress;
            }
            int newColor = Color.rgb(colorRed, colorGreen, colorBlue);

            //Set element color to new color and update display
            this.display.getCurrentElement().setColor(newColor);
            this.display.invalidate();
        }
    }


    /**
     * onStartTrackingTouch is unused but required to be overridden.
     *
     * @param seekBar The seekbar the event came from
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { /** Ignore */ }

    /**
     * onStopTrackingTouch is unused but required to be overridden.
     *
     * @param seekBar The seekBar the event came from
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { /** Ignore */ }
}
