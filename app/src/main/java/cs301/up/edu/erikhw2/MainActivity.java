package cs301.up.edu.erikhw2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * <!-- class MainActivity -->
 *
 * This class is the main class called to run the application
 *
 * @author Erik Torkelson
 * Date: February 19, 2019
 */
public class MainActivity extends AppCompatActivity{

    //Instance Variables of XML Objects needed
    private SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    private TextView currentElement, redValue, greenValue, blueValue;
    private Display display;


    /**
     * onCreate is called when the app is first started
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Use my xml layout as layout for app
        setContentView(R.layout.activity_main);

        /**
         * External Citation
         *  Date:        2/17/19
         *  Problem:     Wanted to get rid of status bars
         *  Resource:    https://developer.android.com/training/system-ui/
         *                  navigation#java
         *  Solution:    Used code from website and read possible view options
         *                  to add immersive in onCreate and onResume
         */

        //Remove layout borders from tablet as described in citation
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);


        //Find references to the textViews displaying the RGB values
        redValue = findViewById(R.id.redValue);
        greenValue = findViewById(R.id.greenValue);
        blueValue = findViewById(R.id.blueValue);

        //Find references to seekBars
        redSeekBar = findViewById(R.id.redSeekBar);
        greenSeekBar = findViewById(R.id.greenSeekBar);
        blueSeekBar = findViewById(R.id.blueSeekBar);

        //Find reference to current element textView and the surfaceView
        currentElement = findViewById(R.id.currentElement);
        display = findViewById(R.id.drawingSurface);

        //Set listener for surfaceView
        display.setOnTouchListener(
                new DisplayListener(currentElement, display, redSeekBar,
                        greenSeekBar, blueSeekBar)
        );

        //Set listeners for the seekBars with corresponding textviews and
        //colors passed
        redSeekBar.setOnSeekBarChangeListener(
                new SeekBarListener(redValue, display, SeekBarColor.RED));
        greenSeekBar.setOnSeekBarChangeListener(
                new SeekBarListener(greenValue, display, SeekBarColor.GREEN));
        blueSeekBar.setOnSeekBarChangeListener(
                new SeekBarListener(blueValue, display, SeekBarColor.BLUE));



    }


    /**
     * onResume is called when the app is resumed from doing something else
     * on the tablet (Drop down menu, going to sleep, etc...).
     *
     */
    @Override
    protected void onResume() {
        super.onResume();

        //Remove layout borders from tablet as described in citation
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }

}
