package shuttle.hci.com;




import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import android.database.Cursor;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class DisplayResults extends MapActivity {

	private TextView mStopText;
	private TextView mTimeText;
	private ToggleButton mDestToggle;
	private FrameLayout mFrameLayout;
    private MapView mMap;
    private MapController mMapController;
    private double startLat;
    private Location mStartLoc;
    private Location mDestLoc;
	private String mDestString;
	private int mDeptTime;
	private DataBaseAdapter mDbHelper;
	private boolean start;
	private boolean isSouth;
	private RankedStop fastest;
	private TextView mActualText;
	private TheItemizedOverlay mPersonItemizedoverlay;
	private TheItemizedOverlay mMarkerItemizedoverlay;

	private List<Overlay> mMapOverlays;

	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		//inflater.inflate(R.menu.context_menu, menu);
		Log.d("IN CONTEXT MENU CREATE","HELLO WORLD");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.results_view);
		start = true;
		//Initialize Toggle Button
		mDestToggle = (ToggleButton) findViewById(R.id.destToggle);
		mStopText = (TextView) findViewById(R.id.shuttleStop);
		mTimeText = (TextView) findViewById(R.id.shuttleTime);
		mActualText = (TextView)findViewById(R.id.actualLocation);

		mDestToggle.setTextOn("Start");
		mDestToggle.setTextOff("Dest ");
		mDestToggle.setChecked(true);
		mDestToggle.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				printTime();
				
			}
		});
		//initialize map
		mMap = (MapView) findViewById(R.id.mapView);
		mMap.setClickable(true);
		mMap.setBuiltInZoomControls(true);
		mMap.setSatellite(false);
		ArrayList<View> touchables = new ArrayList<View>();
		touchables.add(mMap);
		mMapController = mMap.getController();

		mMapOverlays = mMap.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.person_drop);
		mPersonItemizedoverlay = new TheItemizedOverlay(drawable, this);
		Drawable drawable1 = this.getResources().getDrawable(R.drawable.marker);
		mMarkerItemizedoverlay = new TheItemizedOverlay(drawable1, this);
		
		
		

		mDbHelper = new DataBaseAdapter(this);
		mDbHelper.open();
		Bundle extras = getIntent().getExtras();
		
		
		if (extras != null) {
		    mDestString = extras.getString("destination");
		    mDeptTime = extras.getInt("dept_time");
		    mStartLoc = new Location(extras.getDouble("lat"),extras.getDouble("lng"));
		    GeoPoint startLoc = new GeoPoint((int)(mStartLoc.getLat()*1e6), (int)(mStartLoc.getLng()*1e6));
		    

		 //   mMapController.animateTo(startLoc);
		    mMapController.setZoom(17);
		    if (mDestString != null) {
		    	//handle translation of destination
				mDestLoc = mDbHelper.getGPSByLocation(mDestString);
				Log.d("DEBUG DZT", String.valueOf(mDestLoc.getLat()));
				getTopThree();
				printTime();
				GeoPoint endLoc = new GeoPoint((int)(mDestLoc.getLat()*1e6), (int)(mDestLoc.getLng()*1e6));
				OverlayItem overlayitem = new OverlayItem(startLoc, "Starting Point", "Tech");
				OverlayItem overlayitem1 = new OverlayItem(endLoc, "Ending Point", mDestString);
				Location loc1 = mDbHelper.getLocationsByStopAndShuttleName(fastest.getStartStopName(), fastest.getShuttle_id());
				Location loc2 = mDbHelper.getLocationsByStopAndShuttleName(fastest.getEndStopName(),fastest.getShuttle_id());
			//	Location[] loz = mDbHelper.getLocationsByStopAndShuttleName(fastest.getStartStopName(), fastest.getEndStopName(), fastest.getShuttle_id());

				GeoPoint startShuttle = new GeoPoint((int)(loc1.getLat()*1e6), (int)(loc1.getLng()*1e6));
				GeoPoint endShuttle = new GeoPoint((int)(loc2.getLat()*1e6), (int)(loc2.getLng()*1e6));
				OverlayItem overlayitem2 = new OverlayItem(startShuttle, "Shuttle Entry", fastest.getStartStopName());
				OverlayItem overlayitem3 = new OverlayItem(endShuttle, "Shuttle Exit", fastest.getEndStopName());
				mPersonItemizedoverlay.addOverlay(overlayitem);
				mPersonItemizedoverlay.addOverlay(overlayitem1);
				mMarkerItemizedoverlay.addOverlay(overlayitem2);
				mMarkerItemizedoverlay.addOverlay(overlayitem3);

				
				


		    }
		    
		    mMapOverlays.add(mPersonItemizedoverlay);
		    mMapOverlays.add(mMarkerItemizedoverlay);
		}
	
		
		
	}
	
	

	private boolean isSouth(Location start,Location dest){
		if(start.getLat() - dest.getLat() > 0){
			isSouth = true;
			return true;
		}
		isSouth = false;
		return false;
	}
	private void printTime(){
		int time;
		String stopName,toPrint,actual;
		if(start){
			time = fastest.getStartTime();
			actual = fastest.getStartStopName();
			stopName = "Departs From";
			 GeoPoint startLoc = new GeoPoint((int)(mStartLoc.getLat()*1e6), (int)(mStartLoc.getLng()*1e6));
		    mMapController.animateTo(startLoc);


		}else{
			time = fastest.getEndTime();
			actual = fastest.getEndStopName();
			stopName = "Arrives At";

			 GeoPoint startLoc = new GeoPoint((int)(mDestLoc.getLat()*1e6), (int)(mDestLoc.getLng()*1e6));
		    mMapController.animateTo(startLoc);



			
		}
		int hour = time/100;
		int minute = time - hour*100;
		boolean pm = false;
		if(hour > 12){
			pm = true;
			hour -=12;
		}
		if(minute < 10){
			 toPrint = hour + ":0" +  minute + " " + (pm ? "pm" : "am");

		}else{
			 toPrint = hour + ":" +  minute + " " + (pm ? "pm" : "am");
		}
		mTimeText.setText(toPrint);
		mStopText.setText(stopName);
		mActualText.setText(actual);
		start = !start;
	}
	
	//input (start,end) -> (startID,startDist,endID,endDist)
	public double[][] getRoute(Location start,Location end,ArrayList<Location> shuttleList){
		double [][] retTuple = new double[2][2];
		retTuple[0] = getClosestStop(start, shuttleList);
		retTuple[1] = getClosestStop(end, shuttleList);
		return retTuple;
	}
	
	//Takes as input coordinate, list of shuttle coords -> (ID,distance)
	public double[] getClosestStop(Location c,ArrayList<Location> sl){
		int lowestID = 0;
		//magic number because it will be necessarily closer than 10000
		double lowestValue = 10000;
		for(Iterator<Location> i = sl.iterator(); i.hasNext(); ){
			Location s = i.next();
			double distance = getDistance(s, c);
			if(distance < lowestValue){
				lowestID = s.getId();
				lowestValue = distance;
			}
		}
		double[] returnTup = {lowestID,lowestValue};
		return returnTup;
		
	}
	
	private double getDistance(Location c1, Location c2){
    	double distance = Math.sqrt(Math.pow(c1.getLat()-c2.getLat(),2)+Math.pow(c1.getLng()-c2.getLng(), 2));
    	return distance;
    			
    }
	
	private void getTopThree(){
		isSouth(mStartLoc,mDestLoc);
		Map<Integer,ArrayList<Location>> shuttles = mDbHelper.getAllStopsPerShuttle();
		ArrayList<RankedStop> rs = new ArrayList<RankedStop>();
		for (Integer key : shuttles.keySet()) {
		    ArrayList<Location> ls = shuttles.get(key);
			double[][] retTuple = new double[2][2];
		    retTuple = getRoute(mStartLoc,mDestLoc,ls);
		    Log.d("DEBUZ",String.valueOf(retTuple[1][0]));
			int startTime = mDbHelper.getNextStopTime(key, (int)retTuple[0][0], mDeptTime);
			int endTime = mDbHelper.getNextStopTime(key, (int)retTuple[1][0], startTime);
			String startStopName = mDbHelper.getStopName(key, (int)retTuple[0][0]);
			String endStopName = mDbHelper.getStopName(key, (int)retTuple[1][0]);
		//	String shuttleName = mDbHelper.getShuttleName(key);
			double distance = retTuple[0][1] + retTuple[1][1];
			RankedStop rnk = new RankedStop(startStopName,startTime,endStopName,endTime,distance,key.intValue());
		//	fastest = rnk;
			Log.d("BUGZ",String.valueOf(isSouth));
			if(key == 0 && isSouth){
				Log.d("DEBUZ", "HERE I AM");
			}else if(key == 1 && !isSouth){
				Log.d("DEBUZ", "HERE I 21AM");

			}else{
				rs.add(rnk);
			}
			
		}
		fastest = rs.get(0);
		Log.d("BUFZ",String.valueOf(rs.size()));
		
		//Log.d("tupleMANIAAA: ",String.valueOf(retTuple[0][0]));
	//	mStopText.setText(mDbHelper.getStopName(0, (int)retTuple[0][0]));
		//int time = mDbHelper.getNextStopTime(key, , time)
		//mTimeText.setText(text)
		
		
	}
	

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
