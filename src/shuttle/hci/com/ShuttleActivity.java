package shuttle.hci.com;
import java.util.Arrays;
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
	private static final String[] PLACES = new String[]{ "Tech","Ford","Library","Allison","Annenberg","Webber Arch"};
	 private static final Map<String, shuttle.hci.com.Coordinate> landMark2Coord;
	    static {
	        Map<String, Coordinate> aMap = new HashMap<String,Coordinate>();
	        aMap.put("Donald P. Jacobs Center", new Coordinate(42.054025,-87.677143));
	        aMap.put("620 Lincoln Street", new Coordinate(39.7263519,-104.9861723));
	        aMap.put("Elder Residence Hall", new Coordinate(42.0612081,-87.6770967));
	        aMap.put("Delta Chi Fraternity", new Coordinate(42.060826,-87.678113));
	        aMap.put("Patten Gymnasium", new Coordinate(42.0615101,-87.6770474));
	        aMap.put("584 Lincoln Residence Hall", new Coordinate(42.0616143,-87.6766512));
	        aMap.put("Beta Theta Pi Fraternity", new Coordinate(42.0608476,-87.6770714));
	        aMap.put("Phi Delta Theta Fraternity", new Coordinate(42.0608248,-87.6770722));
	        aMap.put("2335 Sheridan Road", new Coordinate(42.0606877,-87.6770772));
	        aMap.put("Lambda Chi Alpha Fraternity", new Coordinate(42.0607334,-87.6770755));
	        aMap.put("Sigma Phi Epsilon Fraternity", new Coordinate(42.0607562,-87.6770747));
	        aMap.put("Goodrich House Residence Hall", new Coordinate(42.0599573,-87.6770896));
	        aMap.put("Pi Kappa Alpha Fraternity", new Coordinate(42.0599355,-87.6766542));
	        aMap.put("Chi Psi Fraternity", new Coordinate(42.0593669,-87.6770954));
	        aMap.put("Lindgren Hall", new Coordinate(42.05932,-87.6770959));
	        aMap.put("Delta Upsilon Fraternity", new Coordinate(42.0593083,-87.6770961));
	        aMap.put("College of Cultural & Community Studies", new Coordinate(42.059282,-87.676692));
	        aMap.put("Foster House Residence Hall", new Coordinate(42.058576,-87.6771037));
	        aMap.put("2251 Sheridan Road Residence Hall", new Coordinate(42.0585726,-87.6771039));
	        aMap.put("Zeta Beta Tau Fraternity", new Coordinate(42.0615842,-87.6757073));
	        aMap.put("Theta Chi Fraternity", new Coordinate(42.0616093,-87.6763085));
	        aMap.put("566 Lincoln Street", new Coordinate(42.0616067,-87.6761372));
	        aMap.put("Alpha Epsilon Pi Fraternity", new Coordinate(42.061353,-87.675126));
	        aMap.put("Kemper Residence Hall", new Coordinate(42.0564919,-87.6741107));
	        aMap.put("Slivka Residence Hall", new Coordinate(42.060517,-87.6758793));
	        aMap.put("Ayers College of Commerce & Industry", new Coordinate(42.0564919,-87.6741107));
	        aMap.put("McCulloch Residence Hall", new Coordinate(42.0597713,-87.6770915));
	        aMap.put("Bobb Residence Hall", new Coordinate(42.059569,-87.675533));
	        aMap.put("Henry Crown Sports Pavilion / Norris Aquatic Center", new Coordinate(42.0512652,-87.6735398));
	        aMap.put("Combe Tennis Center", new Coordinate(42.0512652,-87.6735398));
	        aMap.put("Technological Institute", new Coordinate(42.0577888,-87.6761502));
	        aMap.put("Frances Searle Building", new Coordinate(42.0513306,-87.6735533));
	        aMap.put("Lakeside Fields", new Coordinate(42.0513116,-87.6735451));
	        aMap.put("Seeley G. Mudd Science and Engineering Library", new Coordinate(42.0541119,-87.6759889));
	        aMap.put("Cook Hall", new Coordinate(42.0513497,-87.6735548));
	        aMap.put("Hogan Building", new Coordinate(42.0541119,-87.6759889));
	        aMap.put("Pancoe-NSUHS Life Sciences Pavilion", new Coordinate(42.0513688,-87.6735562));
	        aMap.put("James L Allen Center", new Coordinate(42.0513984,-87.6735585));
	        aMap.put("Ryan Hall", new Coordinate(42.0513784,-87.673557));
	        aMap.put("Silverman Hall", new Coordinate(42.0513975,-87.6735584));
	        aMap.put("Ford Motor Company Engineering Design Center", new Coordinate(42.056893,-87.676735));
	        aMap.put("Shakespeare Garden", new Coordinate(42.0411414,-87.6900587));
	        aMap.put("Catalysis Center", new Coordinate(42.0541119,-87.6759889));
	        aMap.put("Dearborn Observatory", new Coordinate(42.0541119,-87.6759889));
	        aMap.put("Garrett-Evangelical Theological Seminary", new Coordinate(42.0560301,-87.6764988));
	        aMap.put("Shanley Hall", new Coordinate(42.0607151,-87.6770779));
	        aMap.put("Lunt Hall", new Coordinate(42.054684,-87.676502));
	        aMap.put("Swift Hall", new Coordinate(42.0548971,-87.6749915));
	        aMap.put("Cresap Laboratory", new Coordinate(42.05066,-87.6747589));
	        aMap.put("Central Utility Plant", new Coordinate(42.0610222,-87.6741824));
	        aMap.put("Andersen Hall", new Coordinate(42.0607151,-87.6770779));
	        aMap.put("Donald P. Jacobs Center", new Coordinate(42.054025,-87.677143));
	        aMap.put("Deering Meadow", new Coordinate(42.0527013,-87.6772178));
	        aMap.put("Deering Library", new Coordinate(42.0607151,-87.6770779));
	        aMap.put("University Library", new Coordinate(42.0515887,-87.6735729));
	        aMap.put("Norris University Center", new Coordinate(42.0515609,-87.6735708));
	        aMap.put("Pick-Staiger Concert Hall", new Coordinate(42.051432,-87.6727566));
	        aMap.put("Annie May Swift Hall", new Coordinate(42.0516365,-87.6735766));
	        aMap.put("University Hall", new Coordinate(42.0518579,-87.6759839));
	        aMap.put("Weber Arch", new Coordinate(42.0510664,-87.6773301));
	        aMap.put("Harris Hall", new Coordinate(42.0512513,-87.6772551));
	        aMap.put("West Fairchild (International Studies Residential College)", new Coordinate(42.051073,-87.675909));
	        aMap.put("Crowe Hall", new Coordinate(42.0560567,-87.674147));
	        aMap.put("Kresge Hall", new Coordinate(42.0516747,-87.6735795));
	        aMap.put("East Fairchild (Communications Residential College)", new Coordinate(42.0504947,-87.6752234));
	        aMap.put("The McCormick Tribune Center", new Coordinate(42.0513328,-87.6735804));
	        aMap.put("Fisk Hall", new Coordinate(42.0503106,-87.674543));
	        aMap.put("Locy Hall", new Coordinate(42.0560567,-87.674147));
	        aMap.put("John J. Louis Hall", new Coordinate(42.0516776,-87.6735797));
	        aMap.put("Theatre and Interpretation Center: Dance Center, Louis Theater, and Barber Theater", new Coordinate(42.0516087,-87.6735745));
	        aMap.put("Block Museum of Art, Mary and Leigh", new Coordinate(42.051432,-87.6727566));
	        aMap.put("Marjorie Ward Marshall Dance Center", new Coordinate(42.051432,-87.6727566));
	        aMap.put("Regenstein Hall of Music", new Coordinate(42.0522112,-87.6714114));
	        aMap.put("Boat House", new Coordinate(42.0564919,-87.6741107));
	        landMark2Coord = Collections.unmodifiableMap(aMap);
	    }
	  
	    private static final Map<String, Time[]> interCampusSouth2Time;
	    static {
	        Map<String, Time[]> aMap2 = new HashMap<String,Time[]>();
	        Time[] arrTime0 = {new Time(6,40),new Time(7,20),new Time(8,00),new Time(8,15),new Time(8,30),new Time(9,00),new Time(9,30),new Time(10,10),new Time(10,50),new Time(11,15),new Time(11,55),new Time(12,35),new Time(13,00),new Time(13,40),new Time(14,25),new Time(14,45),new Time(15,30),new Time(16,05),new Time(16,20),new Time(16,45),new Time(17,05),new Time(17,15),new Time(17,35),new Time(18,15),new Time(18,30),new Time(19,20),new Time(20,15),new Time(21,35),new Time(22,25),};
	        aMap2.put("Ward",arrTime0);
	        Time[] arrTime1 = {new Time(7,00),new Time(7,40),new Time(8,20),new Time(8,35),new Time(8,50),new Time(9,20),new Time(9,50),new Time(10,30),new Time(11,10),new Time(11,35),new Time(12,15),new Time(12,55),new Time(13,20),new Time(14,00),new Time(14,45),new Time(15,05),new Time(15,50),new Time(16,25),new Time(16,40),new Time(17,05),new Time(17,25),new Time(17,35),new Time(17,55),new Time(18,35),new Time(18,50),new Time(19,40),new Time(20,35),new Time(21,55),new Time(22,43),};
	        aMap2.put("Sheridan/Loyola",arrTime1);
	        Time[] arrTime2 = {new Time(7,10),new Time(7,50),new Time(8,30),new Time(8,45),new Time(9,00),new Time(9,30),new Time(10,00),new Time(10,40),new Time(11,20),new Time(11,45),new Time(12,25),new Time(13,05),new Time(13,30),new Time(14,10),new Time(14,55),new Time(15,15),new Time(16,00),new Time(16,35),new Time(16,50),new Time(17,15),new Time(17,35),new Time(17,45),new Time(18,05),new Time(18,45),new Time(19,00),new Time(19,50),new Time(20,45),new Time(22,05),new Time(22,48),};
	        aMap2.put("Chicago/Main",arrTime2);
	        Time[] arrTime3 = {new Time(7,11),new Time(7,51),new Time(8,31),new Time(8,46),new Time(9,01),new Time(9,31),new Time(10,01),new Time(10,41),new Time(11,21),new Time(11,46),new Time(12,26),new Time(13,06),new Time(13,31),new Time(14,11),new Time(14,56),new Time(15,16),new Time(16,01),new Time(16,36),new Time(16,51),new Time(17,16),new Time(17,36),new Time(17,46),new Time(18,06),new Time(18,46),new Time(19,01),new Time(19,51),new Time(20,46),new Time(22,06),new Time(22,49),};
	        aMap2.put("Chicago/Greenleaf",arrTime3);
	        Time[] arrTime4 = {new Time(7,13),new Time(7,53),new Time(8,33),new Time(8,48),new Time(9,03),new Time(9,33),new Time(10,03),new Time(10,43),new Time(11,23),new Time(11,48),new Time(12,28),new Time(13,8),new Time(13,33),new Time(14,13),new Time(14,58),new Time(15,18),new Time(16,03),new Time(16,38),new Time(16,53),new Time(17,18),new Time(17,38),new Time(17,48),new Time(18,8),new Time(18,48),new Time(19,03),new Time(19,53),new Time(20,48),new Time(22,8),new Time(22,50),};
	        aMap2.put("Chicago/Davis",arrTime4);
	        Time[] arrTime5 = {new Time(7,16),new Time(7,56),new Time(8,36),new Time(8,51),new Time(9,06),new Time(9,36),new Time(10,06),new Time(10,46),new Time(11,26),new Time(11,51),new Time(12,31),new Time(13,11),new Time(13,36),new Time(14,16),new Time(15,01),new Time(15,21),new Time(16,06),new Time(16,41),new Time(16,56),new Time(17,21),new Time(17,41),new Time(17,51),new Time(18,11),new Time(18,51),new Time(19,06),new Time(19,56),new Time(20,51),new Time(22,11),new Time(22,52),};
	        aMap2.put("Arch",arrTime5);
	        Time[] arrTime6 = {new Time(7,17),new Time(7,57),new Time(8,37),new Time(8,52),new Time(9,07),new Time(9,37),new Time(10,07),new Time(10,47),new Time(11,27),new Time(11,52),new Time(12,32),new Time(13,12),new Time(13,37),new Time(14,17),new Time(15,02),new Time(15,22),new Time(16,07),new Time(16,42),new Time(16,57),new Time(17,22),new Time(17,42),new Time(17,52),new Time(18,12),new Time(18,52),new Time(19,07),new Time(19,57),new Time(20,52),new Time(22,12),new Time(22,54),};
	        aMap2.put("Kellogg",arrTime6);
	        Time[] arrTime7 = {new Time(7,18),new Time(7,58),new Time(8,38),new Time(8,53),new Time(9,8),new Time(9,38),new Time(10,8),new Time(10,48),new Time(11,28),new Time(11,53),new Time(12,33),new Time(13,13),new Time(13,38),new Time(14,18),new Time(15,03),new Time(15,23),new Time(16,8),new Time(16,43),new Time(16,58),new Time(17,23),new Time(17,43),new Time(17,53),new Time(18,13),new Time(18,53),new Time(19,8),new Time(19,58),new Time(20,53),new Time(22,13),new Time(22,55),};
	        aMap2.put("Tech",arrTime7);
	        Time[] arrTime8 = {new Time(7,19),new Time(7,59),new Time(8,39),new Time(8,54),new Time(9,9),new Time(9,39),new Time(10,9),new Time(10,49),new Time(11,29),new Time(11,54),new Time(12,34),new Time(13,14),new Time(13,39),new Time(14,19),new Time(15,04),new Time(15,24),new Time(16,9),new Time(16,44),new Time(16,59),new Time(17,24),new Time(17,44),new Time(17,54),new Time(18,14),new Time(18,54),new Time(19,9),new Time(19,59),new Time(20,54),new Time(22,14),new Time(22,56),};
	        aMap2.put("Patten",arrTime8);
	        Time[] arrTime9 = {new Time(7,22),new Time(8,02),new Time(8,42),new Time(8,57),new Time(9,12),new Time(9,42),new Time(10,12),new Time(10,52),new Time(11,32),new Time(11,57),new Time(12,37),new Time(13,17),new Time(13,42),new Time(14,22),new Time(15,07),new Time(15,27),new Time(16,12),new Time(16,47),new Time(17,02),new Time(17,27),new Time(17,47),new Time(17,57),new Time(18,17),new Time(18,57),new Time(19,12),new Time(20,02),new Time(20,57),new Time(22,17),new Time(22,59),};
	        aMap2.put("Central_L",arrTime9);
	        Time[] arrTime10 = {new Time(7,23),new Time(8,03),new Time(8,43),new Time(8,58),new Time(9,13),new Time(9,43),new Time(10,13),new Time(10,53),new Time(11,33),new Time(11,58),new Time(12,38),new Time(13,18),new Time(13,43),new Time(14,23),new Time(15,8),new Time(15,28),new Time(16,13),new Time(16,48),new Time(17,03),new Time(17,28),new Time(17,48),new Time(17,58),new Time(18,18),new Time(18,58),new Time(19,13),new Time(20,03),new Time(20,58),new Time(22,18),new Time(23,00),};
	        aMap2.put("Central/Jackson",arrTime10);
	        Time[] arrTime11 = {new Time(7,25),new Time(8,05),new Time(8,45),new Time(9,00),new Time(9,15),new Time(9,45),new Time(10,15),new Time(10,55),new Time(11,35),new Time(12,00),new Time(12,40),new Time(13,20),new Time(13,45),new Time(14,25),new Time(15,10),new Time(15,30),new Time(16,15),new Time(16,50),new Time(17,05),new Time(17,30),new Time(17,50),new Time(18,00),new Time(18,20),new Time(19,00),new Time(19,15),new Time(20,05),new Time(21,00),new Time(22,20),new Time(23,02),};
	        aMap2.put("Ryan_Field",arrTime11);
	        interCampusSouth2Time = Collections.unmodifiableMap(aMap2);
	      
	    }

	    private static final Map<Coordinate, String> coord2Stop;
	    static {
	        Map<Coordinate, String> aMap3 = new HashMap<Coordinate,String>();
	        aMap3.put(new Coordinate(41.896703,-87.619497),"Ward");
	        aMap3.put(new Coordinate(42.001505,-87.660964),"Sheridan/Loyola");
	        aMap3.put(new Coordinate(42.034106,-87.679042),"Chicago/Main");
	        aMap3.put(new Coordinate(42.037763,-87.680415),"Chicago/Greenleaf");
	        aMap3.put(new Coordinate(42.046273,-87.679331),"Chicago/Davis");
	        aMap3.put(new Coordinate(42.050958,-87.677572),"Arch");
	        aMap3.put(new Coordinate(42.053666,-87.67754),"Kellogg");
	        aMap3.put(new Coordinate(42.058215,-87.6774),"Tech");
	        aMap3.put(new Coordinate(42.061202,-87.676928),"Patten");
	        aMap3.put(new Coordinate(42.064332,-87.685533),"Central_L");
	        aMap3.put(new Coordinate(42.063982,-87.692056),"Central/Jackson");
	        aMap3.put(new Coordinate(42.065304,-87.694287),"Ryan_Field");
	        aMap3.put(new Coordinate(42.058542,-87.681799),"Sherman/Noyes");
	        aMap3.put(new Coordinate(42.055881,-87.681863),"Sherman/Simpson");
	        aMap3.put(new Coordinate(42.052224,-87.68196),"Sherman/Emerson");
	        aMap3.put(new Coordinate(42.052272,-87.684953),"Emerson/Maple (westbound)");
	        aMap3.put(new Coordinate(42.05334,-87.687421),"Ridge/Garnett");
	        aMap3.put(new Coordinate(42.055953,-87.686627),"Ridge/Simpson");
	        aMap3.put(new Coordinate(42.058263,-87.685661),"Ridge/Noyes");
	        coord2Stop = Collections.unmodifiableMap(aMap3);
	      
	    }
	  
	    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        AutoCompleteTextView inputView = (AutoCompleteTextView) findViewById(R.id.destination);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item,PLACES);
        inputView.setAdapter(adapter);


        		
    }
    
    
    
    @SuppressWarnings("unused")
	private double getDistance(Coordinate c1, Coordinate c2){
    	double distance = Math.sqrt(Math.pow(c1.getLat()-c2.getLat(),2)+Math.pow(c1.getLng()-c2.getLng(), 2));
    	return distance;
    			
    }
   
}