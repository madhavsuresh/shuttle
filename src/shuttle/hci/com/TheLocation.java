package shuttle.hci.com;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class TheLocation implements LocationListener {
	private Location myLocation;

	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		myLocation = location;
		
	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

		
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

		
	}

}
