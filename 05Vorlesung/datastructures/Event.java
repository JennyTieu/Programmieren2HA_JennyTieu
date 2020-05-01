/**
 * 
 */
package datastructures;


/**
 * @author jenny
 *
 */
public class Event {
	private String eventName;
	private String location;
	private String time;
	
	public Event(String eventName, String location, String time) {
		this.eventName = eventName;
		this.location = location;
		this.time = time;
	}
	
	

	public String getEventName() {
		return eventName;
	}



	public String getLocation() {
		return location;
	}



	public String getTime() {
		return time;
	}



	@Override
	public boolean equals(Object obj) {
		if(this== obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Event)) {
			return false;
		}
		Event other = (Event) obj;
		if (eventName == null) {
			if(other.eventName != null) {
				return false;
			}
		}else if (!eventName.equals(other.eventName)) {
			return false;
		}
		if (location == null) {
			if(other.location!=null) {
				return false;
			}
		}else if(!location.equals(other.location)) {
			return false;
		}
		if(time == null) {
			if(other.time!=null) {
				return false;
			}
		}else if(!time.equals(other.time)) {
			return false;
		}
		return true;
	}
	
	
	
	
	

}
