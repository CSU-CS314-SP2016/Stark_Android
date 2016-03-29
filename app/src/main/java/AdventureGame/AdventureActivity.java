package AdventureGame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import aa.a3.model.AdventureGameModelFacade;

public class AdventureActivity extends Activity {
	
    private AdventureGameModelFacade model;

    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //initialize connection to model
        model = new AdventureGameModelFacade();
        String viewText = model.getView();
        
        // Get initial room view, and see my items.
         TextView myView = (TextView) findViewById(R.id.roomView);
         myView.setText(viewText);
         
         TextView myItems = (TextView) findViewById(R.id.myItems);
         myItems.setText(model.getItems());
      
        
    }
    
  /* comment out for now
    
 // This method is called at button click because we assigned the name to the
 	// "On Click property" of the button
 	public void myClickHandler(View view) {
 		switch (view.getId()) {
 		case R.id.goUp:
 			myView.setText(text);
 		break;
 		}
 	}
 	*/
    
}
