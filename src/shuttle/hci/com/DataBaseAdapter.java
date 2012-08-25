package shuttle.hci.com;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseAdapter {
	
	Context mCtx;
    private DataBaseHelper mDbHelper;
    private SQLiteDatabase mDb;
    public static final String KEY_SHUTTLE_ID = "shuttle_ID";
    public static final String KEY_STOP_ID = "stop_ID";
    public static final String KEY_TIME = "time";
    public static final String KEY_LAT = "lat";
    public static final String KEY_LNG = "lng";
    public static final String KEY_STOP_NAME = "stop_name";
    public static final String KEY_LOCATION_NAME = "name";
    public static final String KEY_LOCATION_ADDRESS= "address";


    private static final String DATABASE_SHUTTLE_TABLE = "shuttle";
    private static final String DATABASE_LOCATIONS_TABLE = "locations";

    public static final int NUM_SHUTTLES = 2;
	public DataBaseAdapter(Context ctx) {
		// TODO Auto-generated constructor stub
    	 this.mCtx = ctx;
	}
	
	public void open() throws SQLException {
	        mDbHelper = new DataBaseHelper(mCtx);
	        mDbHelper.close();
	        mDb = mDbHelper.getReadableDatabase();
	}

	 public void close() {
	        mDbHelper.close();
	 }
	 
	 public Location getGPSByLocation(String location){
		 Cursor c = mDb.query(DATABASE_LOCATIONS_TABLE,new String[] {KEY_LAT,KEY_LNG,KEY_LOCATION_NAME} , KEY_LOCATION_NAME+ "=\"" + location + "\""
					, null, null, null, null);
	       if (c != null) {
	            c.moveToFirst();
	            return new Location(c.getDouble(c.getColumnIndexOrThrow(KEY_LAT)),c.getDouble(c.getColumnIndexOrThrow(KEY_LNG)));
	        }
	        return null;
	 }
	 
	 public int getNextStopTime(int shuttle_id, int stop_id, int time){

 
		   Cursor c = mDb.query(true, DATABASE_SHUTTLE_TABLE, new String[] {KEY_TIME}, KEY_TIME+ ">" + time + 
				   						" AND " + KEY_STOP_ID + "=" + stop_id + " AND " + KEY_SHUTTLE_ID + "=" + shuttle_id , null, null, null, KEY_TIME, "1");
	        if (c != null) {
	            c.moveToFirst();
	            return c.getInt(c.getColumnIndexOrThrow(KEY_TIME));
	            
	        }
	        return -1;
	 }
	 public String getStopName(int shuttle_id,int stop_id){
		 Cursor c = mDb.query(true, DATABASE_SHUTTLE_TABLE, new String[] {KEY_STOP_NAME}, KEY_STOP_ID + "=" + stop_id + " AND " + KEY_SHUTTLE_ID + "=" + shuttle_id , null, null, null, null, "1");
		    if (c != null) {
	            c.moveToFirst();
	            return c.getString(c.getColumnIndexOrThrow(KEY_STOP_NAME));
	            
	        }
		    return null;
	 }
	 public Location getLocationsByStopAndShuttleName(String stopNameStart,int shuttle_id){
		// Location[] l = new Location[2];
		 Cursor c = mDb.query(true,DATABASE_SHUTTLE_TABLE,new String[] {KEY_LAT,KEY_LNG},KEY_STOP_NAME+ "= \"" +stopNameStart+ "\"  AND " +  KEY_SHUTTLE_ID+ "=" + shuttle_id ,null,null,null,null,null);
		 c.moveToFirst();
		 Location tmp = new Location(c.getDouble(c.getColumnIndexOrThrow(KEY_LAT)),c.getDouble(c.getColumnIndexOrThrow(KEY_LNG)));
		 return tmp;

	 }
	 public Map<Integer, ArrayList<Location>> getAllStopsPerShuttle(){
		 Map<Integer,ArrayList<Location>> accum = new HashMap<Integer,ArrayList<Location>>();
		 for(int i = 0;i<NUM_SHUTTLES;i++){
			 Cursor c = mDb.query(true,DATABASE_SHUTTLE_TABLE,new String[] {KEY_LAT,KEY_LNG,KEY_STOP_ID},KEY_SHUTTLE_ID+ "=" +i,null,null,null,null,null);
			 ArrayList<Location> tmp = new ArrayList<Location>();
			 for(c.moveToFirst();c.moveToNext();c.isAfterLast()){
				 double lat = c.getDouble(c.getColumnIndexOrThrow(DataBaseAdapter.KEY_LAT));
				 double lng = c.getDouble(c.getColumnIndexOrThrow(DataBaseAdapter.KEY_LNG));
				 int id = c.getInt(c.getColumnIndexOrThrow(DataBaseAdapter.KEY_STOP_ID));

				 tmp.add(new Location(lat, lng, id));
				 
			 }
			 accum.put(i, tmp);
		 }
		 return accum;
		 
	 }


}
