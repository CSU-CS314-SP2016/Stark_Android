package AdventureGame;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends Activity {
	
    private AdventureGameModelFacade model;

    private String
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //initialize connection to model
        model = new AdventureGameModelFacade();
        String viewText = model.getView();
        
        // Get initial room view, and see my items.
         TextView myView = (TextView) findViewById(R.id.roomView);
         myView.setText(viewText);
         
         TextView myItems = (TextView) findViewById(R.id.myItems);
         myItems.setText(model.getItems());
        
    }
    
 // This method is called at button click because we assigned the name to the
 	// "On Click property" of the button
 	public void myClickHandler(View view) {
 		switch (view.getId()) {
 		case R.id.goUp:
 			myView.setText(text);

            case R.id.goDown:
                myView.setText(text);

            case R.id.goUp:
                myView.setText(text);

            case R.id.goNorth:
                myView.setText(text);

            case R.id.goSouth:
                myView.setText(text);

            case R.id.goEast:
                myView.setText(text);

            case R.id.goWest:
                myView.setText(text);

            case R.id.grab:
                myView.setText(text);

            case R.id.drop1:
                myView.setText(text);

            case R.id.drop2:
                myView.setText(text);
 		break;
 		}
 	}
    
}
