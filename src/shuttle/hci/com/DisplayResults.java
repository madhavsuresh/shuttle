package shuttle.hci.com;



import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class DisplayResults extends Activity {
	final private double TECH_LAT = 42.0577888;
	final private double TECH_LNG = -87.6761502;
	private EditText mDestText;
	private EditText mTimeText;
	private EditText mLocText;

	private double  mLng;
	private double mLat;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.results_view);
		
		mDestText = (EditText) findViewById(R.id.place);
		mTimeText = (EditText) findViewById(R.id.time);
		mLocText = (EditText) findViewById(R.id.location);
		mLat = TECH_LAT;
		mLng = TECH_LNG;
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    String dest = extras.getString("destination");
		    long time = extras.getLong("dept_time");

		    if (dest != null) {
		        mDestText.setText(dest);
		    }
		    
		    mTimeText.setText(String.valueOf(time));
		   
		}
		mLocText.setText("before gps update");
		
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
		    			    	
		    }

		    public void onProviderDisabled(String provider) {}
		  };

		// Register the listener with the Location Manager to receive location updates
		locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER,locationListener,null);
		//mLocText.setText(lo)
		
		
	}
	
	
	
	private void makeUseOfNewLocation(Location l){
		mLat = l.getLatitude();
		mLng = l.getLongitude();
		mLocText.setText(String.valueOf(mLat) + "," + String.valueOf(mLng));
		
	}

}
