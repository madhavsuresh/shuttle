package shuttle.hci.com;

public class Time {
	int hour;
	int minute;
	
	public Time(int h, int min){
		this.hour = h;
		this.minute = min;
	}
	public boolean after(Time t){
		if(t.getHour() > this.hour ){
			return true;
		}else if(t.getHour() == this.hour && t.getMinute() > this.minute){
			return true;
		}
		return false;
	}
	
	public int getHour(){
		return hour;
	}
	public int getMinute(){
		return minute;
	}
	

}
