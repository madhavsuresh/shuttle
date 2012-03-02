package shuttle.hci.com;


public class Coordinate{
	private final double lat;
	private final double lon;
	
	public Coordinate(double lat, double lon){
		this.lat = lat;
		this.lon = lon;
	}
		
		public double getLat(){
			//return void;
			return lat;
		}
		
		public double getLon(){
			return lon;
		}
		@Override
		public String toString(){
			return "lolol";
		}
	}
