package edu.nimbus.glass;

import com.google.android.glass.app.Card;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


/**
 * This class is the starting point for the service.  It is called and determines if the glass has a connection
 * to the server. If service has previously been started it will restart the service.  
 * It than displays a simple card to show that it has started.  
 *
 */
public class StartServiceActivity extends Activity {

    	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Startup", "STARTING");
		Intent intt = new Intent(this, ROSMonitorService.class);		
		//kill the service if it is already running because we want to subscrive to a new topic.  
		stopService(intt);
		
		 Card card1 = new Card(this);
         card1.setText("Robot Warning Monitor");
    
         View card1View = card1.toView();
         
         // Display the card we just created
         setContentView(card1View);
		intt = new Intent(this, ROSMonitorService.class);	
		startService(intt);
		
	}
	
}
