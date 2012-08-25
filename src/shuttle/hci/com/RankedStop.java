package shuttle.hci.com;

public class RankedStop {
	
	private String startStopName;
	private String endStopName;
	private int startTime;
	private int endTime;
	private int travelTime;
	private int shuttle_id;
	private double distance;
	
	public String getEndStopName() {
		return endStopName;
	}

	public int getEndTime() {
		return endTime;
	}

	public int getTravelTime() {
		return travelTime;
	}

	public int getShuttle_id() {
		return shuttle_id;
	}

	public double getDistance() {
		return distance;
	}


	
	public RankedStop(String startStopName, int startTime, String endStopName,
			int endTime, double distance, int shuttle_id) {
		
		this.startStopName = startStopName;
		this.startTime  = startTime;
		this.endStopName = endStopName;
		this.endTime = endTime;
		this.distance = distance;
		this.shuttle_id = shuttle_id;
		this.travelTime = endTime-startTime;
		
		// TODO Auto-generated constructor stub
	}

	public String getStartStopName() {
		return startStopName;
	}

	public int getStartTime() {
		return startTime;
	}


}
