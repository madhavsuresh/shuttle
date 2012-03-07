package shuttle.hci.com;


public class Coordinate{
	private final double lat;
	private final double lng;
	
	public Coordinate(double lat, double lon){
		this.lat = lat;
		this.lng = lon;
	}
		
		public double getLat(){
			//return void;
			return lat;
		}
		
		public double getLng(){
			return lng;
		}
		public boolean equals(Coordinate c){
			if( (c.getLat() == this.lat) && (c.getLng() == this.lng)){
				return true;
			}
			return false;
		}
		@Override
		public String toString(){
			return "lolol";
		}
	}
