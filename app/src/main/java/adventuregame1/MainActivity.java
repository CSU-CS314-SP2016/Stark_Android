package adventuregame1;

/**
    class MainActivity: reimplement methods from AdventureGameView for Android use

    @authors
        Zach Fuller
        Josh Foley
        Jason Ritzman

    Updated on March 30 2016
    - Implemented onCreate, myClickHandler, and legacy AdventureGameView methods
    Update on April 16 2016
    - Reimplemented as a home screen that will link to a new or saved game

**/

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.io.IOException;


public class MainActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

 // This method is called at button click because we assigned the name to the
 	// "On Click property" of the button
    public void myClickHandler(View view) {
        switch (view.getId()) {

            case R.id.newGameNormal:
                Intent n = new Intent(this, NormalActivity.class);
                startActivity(n);
                break;

            case R.id.newGameHard:
                Intent h = new Intent(this, HardActivity.class);
                startActivity(h);
                break;

            case R.id.loadGame:


                break;
        }
    }



}
