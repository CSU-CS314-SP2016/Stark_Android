package adventuregame1;

/**
    class MainActivity: reimplement methods from AdventureGameView for Android use

    @authors
        Zach Fuller
        Josh Foley
        Jason Ritzman

    Created on April 16 2016
    - Created intent link from MainActivity

**/

import android.app.Activity;
import android.os.Environment;
import android.util.Log;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStream;


public class HardActivity extends Activity {

    private Intent intent = getIntent();

    private AdventureGameModelFacade model;

    String viewText;

    TextView myView;
    TextView myItems;

    String[] saveItems = {};

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);

        //initialize connection to model
        try {
            model = new AdventureGameModelFacade(1);
        } catch (IOException e) {
            // System.out.println("Error in AdventureGameModelFacade() call from AdventureGameView.java");
        }

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


            case R.id.saveGame:

                this.saveGame("saveGame.txt");


//             File path = Context.getFilesDir();
//
//             String filename = "saveGame";
//             String string = "Hello world!";
//             AssetManager am = ;
//
//             try {
//                 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Context.openFileOutput)
//                 outputStreamWriter.write(string.getBytes());
//                 outputStream.close();
//
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }


                break;
        }


        displayCurrentInfo();
    }

    private void displayCurrentInfo() {
        myView.setText(model.getView());
        myItems.setText(model.getItems());

    }

    private void setSaveItems() {
        if (model.thePlayer.numItemsCarried() > 0) {
            if (model.thePlayer.numItemsCarried() == 1) {
                saveItems[0] = model.thePlayer.myThings[0].toString();
            }
            if (model.thePlayer.numItemsCarried() == 2) {
                saveItems[0] = model.thePlayer.myThings[0].toString();
                saveItems[1] = model.thePlayer.myThings[1].toString();
            }
        }
    }

    private void saveGame(String filename) {
        setSaveItems();

        String path = Environment.getRootDirectory().getAbsolutePath();

        File save = new File(path);
        save.mkdirs();

        File saveFile = new File(path + "/saveGame.txt");

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(saveFile);
        } catch (FileNotFoundException e) {
        }

        try {
            try {
                fos.write(model.theCave.difficulty);
                fos.write("\n".getBytes());
                fos.write((saveItems[0] + "-" + saveItems[1]).getBytes());
                fos.write("\n".getBytes());
                fos.write(model.thePlayer.getLoc().name.getBytes());
            } catch (IOException e) {
            }
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
            }
        }
    }


//        try {
//            FileOutputStream fos = openFileOutput("saveGame.txt", Context.MODE_PRIVATE);
//
//            fos.write(model.theCave.difficulty);
//            fos.write(saveItems[0].getBytes());
//            fos.write(saveItems[1].getBytes());
//            fos.write(model.thePlayer.getLoc().name.getBytes());
//
//            fos.close();
//
//        } catch (IOException e) {
//
//        }

//        try {
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(filename, Context.MODE_PRIVATE));
//            outputStreamWriter.write(model.theCave.difficulty);
//            outputStreamWriter.write(fileContents[0] + "-" + fileContents[1]);
//            outputStreamWriter.write(model.thePlayer.getLoc().name);
//            outputStreamWriter.close();
//        }
//        catch (IOException e) {
//            Log.e("Exception", "File write failed: " + e.toString());
//        }


}
