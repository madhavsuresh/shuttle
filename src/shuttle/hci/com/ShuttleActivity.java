package shuttle.hci.com;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class ShuttleActivity extends Activity {
	
    /** Called when the activity is first created. */
	private static final String[] PLACES = new String[]{ "Tech","Ford","Library","Allison","Annenberg",};
	 private static final Map<String, shuttle.hci.com.Coordinate> place2Coord;
	    static {
	        Map<String, Coordinate> aMap = new HashMap<String,Coordinate>();
	        aMap.put("Tech", new Coordinate(1,2));
	        aMap.put("Library", new Coordinate(23, 34));
	        place2Coord = Collections.unmodifiableMap(aMap);
	    }
	  
	   
	    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        AutoCompleteTextView inputView = (AutoCompleteTextView) findViewById(R.id.autocomplete_location);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item,PLACES);
        inputView.setAdapter(adapter);


        		
    }
    
    
    
    @SuppressWarnings("unused")
	private double getDistance(Coordinate c1, Coordinate c2){
    	double distance = Math.sqrt(Math.pow(c1.getLat()-c2.getLat(),2)+Math.pow(c1.getLon()-c2.getLon(), 2));
    	return distance;
    			
    }
    
}