package lab8_2;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Event implements Serializable, Comparable<Event> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date start;
	private Date duration;
	private String place;
	private String description;
	private List<String> members;
	
	public Event() {}
	
	public Event(Date start, Date duration, String place, String description, List<String> members) {
		setStart(start);
		setDuration(duration);
		setPlace(place);
		setDescription(description);
		setMembers(members);
	}
	
	public void setStart(Date start) {
		this.start = start;
	}
	
	public Date getStart() {
		return start;
	}
		
	public Date getDuration() {
		return duration;
	}
	
	public void setDuration(Date duration) {
		this.duration = duration;
	}
		
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setMembers(List<String> members2) {
		this.members = members2;
	}
	
	public List<String> getMembers() {
		return members;
	}
	
	public String toString() {
		String inString = new String();
		inString += "Start: " + getStart() + "\n";
		inString += "Duration: " + getDuration() + "\n";
		inString += "Place: " + getPlace() + "\n";
		inString += "Description: " + getDescription() + "\n";
		inString += "Members: " + getMembers().toString() + "\n";
		return inString;
	}

	@Override
	public int compareTo(Event o) {
		return start.compareTo(o.getStart());
	}
	
}