package cs301.up.edu.erikhw2;

import android.graphics.Color;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * <!-- class SeekBarListener -->
 *
 * This class
 *
 * @author Erik Torkelson
 *
 */
public class SeekBarListener implements SeekBar.OnSeekBarChangeListener {

    private Display display;
    private TextView textDisplay;
    private SeekBarColor barColor;

    public SeekBarListener(TextView text, Display display,
                           SeekBarColor barColor) {
        this.textDisplay = text;
        this.display = display;
        this.barColor = barColor;
    }

    /**
     * onProgressChanged
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

        if (this.display.getCurrentElement() != null) {
            //Get Color of current element
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
            this.display.getCurrentElement().setColor(newColor);
            this.display.invalidate();
        }
    }

    /**
     * onStartTrackingTouch
     *
     * @param seekBar
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { /** Ignore */ }

    /**
     * onStopTrackingTouch
     *
     * @param seekBar
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { /** Ignore */ }
}
