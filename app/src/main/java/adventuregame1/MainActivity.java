package adventuregame1;

/**
    class MainActivity: reimplement methods from AdventureGameView for Android use

    @authors
        Zach Fuller
        Josh Foley
        Jason Ritzman

    Updated on March 30 2016
    - Implemented onCreate, myClickHandler, and legacy AdventureGameView methods

**/

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;


public class MainActivity extends Activity {

    private AdventureGameModelFacade model;

    String viewText;

    TextView myView;
    TextView myItems;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize connection to model
        try {
            model = new AdventureGameModelFacade();
        } catch (IOException e) {
           // System.out.println("Error in AdventureGameModelFacade() call from AdventureGameView.java");
        }

        myView = (TextView) findViewById(R.id.roomView);
        viewText = model.getView();

        // Get initial room view, and see my items.

         myView.setText(viewText);

         myItems = (TextView) findViewById(R.id.myItems);
         myItems.setText(model.getItems());

        displayCurrentInfo();


    }

 // This method is called at button click because we assigned the name to the
 	// "On Click property" of the button
 	//TODO
    public void myClickHandler(View view) {
        switch (view.getId()) {
 		case R.id.goUp:
 			model.goUp();
            myView.setText(model.getView());


        case R.id.goDown:
            model.goDown();
            myView.setText(model.getView());


        case R.id.goNorth:
            model.goNorth();
            myView.setText(model.getView());


        case R.id.goSouth:
            model.goSouth();
            myView.setText(model.getView());


        case R.id.goEast:
            model.goEast();
            myView.setText(model.getView());


        case R.id.goWest:
            model.goWest();
            myView.setText(model.getView());


        case R.id.grab1:
            model.grab(1);
            myItems.setText(model.getItems());


        case R.id.grab2:
            model.grab(2);
            myItems.setText(model.getItems());


        case R.id.drop1:
            model.drop(1);
            myItems.setText(model.getItems());


        case R.id.drop2:
            model.drop(2);
            myItems.setText(model.getItems());


        break;
 		}
        displayCurrentInfo();
 	}

    private void displayCurrentInfo(){
        myView.setText(model.getView());
        myItems.setText(model.getItems());

    }



}
