package shuttle.hci.com;
import java.util.List;

import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class ShuttleActivity extends Activity {
    private static final int DISPLAY_RESULTS=1;

	private EditText mDestText;
	private TimePicker mTimePicker;
	private double  mLng;
	private double mLat;
	private Button mFavorites;
	private AutoCompleteTextView inputView;

	final private double TECH_LAT = 42.0577888;
	final private double TECH_LNG = -87.6761502;
    /** Called when the activity is first created. */
	//private static final String[] PLACES = new String[]{ "Tech","Ford","Library","Allison","Annenberg","Webber Arch"};
	   

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		mDestText = (EditText) findViewById(R.id.destination);
		mTimePicker = (TimePicker) findViewById(R.id.timePicker1);
		mLat = TECH_LAT;
		mLng = TECH_LNG;
		mFavorites = (Button)findViewById(R.id.favorites);
		
	
		
		final CharSequence[] items = {"Patten Gymnasium", "University Hall", "Technological Institute"};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Favorites");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		    	inputView.setText(items[item]);

		    }
		});
		
		final AlertDialog alert = builder.create();
		mFavorites.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				alert.show();
				
			}
		});
		//registerForContextMenu(mFavorites);

        /* Begin Autocomplete*/
        inputView = (AutoCompleteTextView) findViewById(R.id.destination);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item,Constants.PLACES);
        inputView.setAdapter(adapter);
        /*End Autocomplete*/
        Button goButton = (Button) findViewById(R.id.go);
        
    	final Intent i = new Intent(this,DisplayResults.class);
     	Log.d("HELLO","IN HERE");
        goButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                int time = 0;

            	Bundle bundle = new Bundle();

                bundle.putString("destination", mDestText.getText().toString());
                time = mTimePicker.getCurrentHour()*100 + mTimePicker.getCurrentMinute();
                bundle.putDouble("lat", mLat);
                bundle.putDouble("lng", mLng);
                bundle.putInt("dept_time", time);
              
              
                i.putExtras(bundle);
                startActivityForResult(i, DISPLAY_RESULTS);
            }
        });
        
        
    	// Acquire a reference to the system Location Manager
		LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

		// Define a listener that responds to location updates
		LocationListener locationListener = new LocationListener() {
		    public void onLocationChanged(Location location) {
		      // Called when a new location is found by the network location provider.
		      makeUseOfNewLocation(location);
		    }

		    public void onStatusChanged(String provider, int status, Bundle extras) {}

		    public void onProviderEnabled(String provider) {
		    	Log.d("HELLO","PROVIDER ENABLED");
		    }

		    public void onProviderDisabled(String provider) {}
		  };

		// Register the listener with the Location Manager to receive location updates
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);
		//mLocText.setText(lo)

        		
    }
    
	
	private void makeUseOfNewLocation(Location l){
		mLat = l.getLatitude();
		mLng = l.getLongitude();
		Log.d("HELLO","GPS FOUND");
		//mLocText.setText(String.valueOf(mLat) + "," + String.valueOf(mLng));
		
	}

    

   
}