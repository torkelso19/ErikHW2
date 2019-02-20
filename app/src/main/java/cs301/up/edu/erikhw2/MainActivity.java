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
 *
 */
public class MainActivity extends AppCompatActivity{

    //Instance Variables of XML Objects
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



        redValue = findViewById(R.id.redValue);
        greenValue = findViewById(R.id.greenValue);
        blueValue = findViewById(R.id.blueValue);

        redSeekBar = findViewById(R.id.redSeekBar);
        greenSeekBar = findViewById(R.id.greenSeekBar);
        blueSeekBar = findViewById(R.id.blueSeekBar);

        currentElement = findViewById(R.id.currentElement);
        display = findViewById(R.id.drawingSurface);
        display.setOnTouchListener(
                new DisplayListener(currentElement, display, redSeekBar,
                        greenSeekBar, blueSeekBar)
        );

        redSeekBar.setOnSeekBarChangeListener(
                new SeekBarListener(redValue, display, SeekBarColor.RED));
        greenSeekBar.setOnSeekBarChangeListener(
                new SeekBarListener(greenValue, display, SeekBarColor.GREEN));
        blueSeekBar.setOnSeekBarChangeListener(
                new SeekBarListener(blueValue, display, SeekBarColor.BLUE));



    }


    /**
     * onResume is called when the app is resumed from doing something else
     * on the tablet
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
