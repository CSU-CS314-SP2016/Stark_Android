package adventuregame1;

/**
    class MainActivity: reimplement methods from AdventureGameView for Android use

    @authors
        Zach Fuller
        Josh Foley
        Jason Ritzman

    Created on April 16 2016
    - Added linking to new MainActivity

**/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;


public class LoadActivity extends Activity {

    private Intent intent = getIntent();
    private AdventureGameModelFacade model;

    String viewText;

    TextView myView;
    TextView myItems;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        //TODO LOAD FUNCTIONALITY THAT LOADS DIFFICULTY, INVENTORY, AND LOCATION INTO VARIABLES


        //initialize connection to model
        //TODO link difficulty to the text file
        try {
            model = new AdventureGameModelFacade(*DIFFICULTY FROM TXT FILE*);
        } catch (IOException e) {
           // System.out.println("Error in AdventureGameModelFacade() call from AdventureGameView.java");
        }

        //TODO link new player up to saved player
        //LOCATION
        model.thePlayer.setLoc(*ROOM LOCATION FROM TXT FILE*);
        //INVENTORY
        model.thePlayer.pickUp(*ITEMS FROM TXT FILE*); //might have to write a string to item method

        myView = (TextView) findViewById(R.id.roomView);
        viewText = model.getView();

        // Get initial room view, and see my items.

         myView.setText(viewText);

         myItems = (TextView) findViewById(R.id.myItems);
         myItems.setText(model.getItems());



    }

 // This method is called at button click because we assigned the name to the
 	// "On Click property" of the button
 	//TODO
    public void myClickHandler(View view) {
        switch (view.getId()) {
 		case R.id.goUp:
 			model.goUp();
            break;

        case R.id.goDown:
            model.goDown();
            break;


        case R.id.goNorth:
            model.goNorth();
            break;


        case R.id.goSouth:
            model.goSouth();
            break;


        case R.id.goEast:
            model.goEast();
            break;


        case R.id.goWest:
            model.goWest();
            break;


        case R.id.grab1:
            model.grab(1);
            myItems.setText(model.getItems());
            break;


        case R.id.grab2:
            model.grab(2);
            myItems.setText(model.getItems());
            break;


        case R.id.drop1:
            model.drop(1);
            myItems.setText(model.getItems());
            break;


        case R.id.drop2:
            model.drop(2);
            myItems.setText(model.getItems());
            break;

        //TODO SAVE IMPLEMENTATION WITH BUTTON
        case R.id.saveGame:
            model.saveGame();
            break;


 		}

        displayCurrentInfo();
 	}

    private void displayCurrentInfo(){
        myView.setText(model.getView());
        myItems.setText(model.getItems());

    }



}
