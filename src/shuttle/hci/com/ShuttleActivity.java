package shuttle.hci.com;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class ShuttleActivity extends Activity {
    private static final int DISPLAY_RESULTS=1;

	private EditText mDestText;
	private TimePicker mTimePicker;
    /** Called when the activity is first created. */
	private static final String[] PLACES = new String[]{ "Tech","Ford","Library","Allison","Annenberg","Webber Arch"};
	   
	    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		mDestText = (EditText) findViewById(R.id.destination);
		mTimePicker = (TimePicker) findViewById(R.id.timePicker1);
		

        /* Begin Autocomplete*/
        AutoCompleteTextView inputView = (AutoCompleteTextView) findViewById(R.id.destination);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item,PLACES);
        inputView.setAdapter(adapter);
        /*End Autocomplete*/
        Button goButton = (Button) findViewById(R.id.go);
        
    	final Intent i = new Intent(this,DisplayResults.class);

        goButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                int time = 0;

            	Bundle bundle = new Bundle();

                bundle.putString("destination", mDestText.getText().toString());
                time = mTimePicker.getCurrentHour()*100 + mTimePicker.getCurrentMinute();
                
                bundle.putLong("dept_time", time);
              
              
                i.putExtras(bundle);
                startActivityForResult(i, DISPLAY_RESULTS);
            }
        });

        		
    }
    
    
    
    @SuppressWarnings("unused")
	private double getDistance(Coordinate c1, Coordinate c2){
    	double distance = Math.sqrt(Math.pow(c1.getLat()-c2.getLat(),2)+Math.pow(c1.getLng()-c2.getLng(), 2));
    	return distance;
    			
    }
   
}