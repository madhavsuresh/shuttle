package shuttle.hci.com;


public class Location{
	private final double lat;
	private final double lng;
	private final int stopId;
	
	public Location(double lat, double lon,int stopid){
		this.lat = lat;
		this.lng = lon;
		this.stopId = stopid;
	}
	public Location(double lat, double lon){
		this.lat = lat;
		this.lng = lon;
		this.stopId = -1;
	}
		
		public double getLat(){
			//return void;
			return lat;
		}
		
		public double getLng(){
			return lng;
		}
		public int getId(){
			return stopId;
		}
		public boolean equals(Location c){
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
