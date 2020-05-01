/**
 * 
 */
package datastructures;

import java.io.Serializable;

public class Contact implements Comparable<Contact>, Serializable {

	private String name;
	private long number;

	public Contact(String name, long number) {
		super();
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public int compareTo(Contact other) {
		// ganz vorne
		if (name.equals("Chuck Norris")) {
			return -1;
		}else if(other.name.equals("Chuck Norris")) {
			return 1;
//		}else if(other.name.equals("Sprocket")||other.name.equals("Apple")) {
//			return 1;
		}else if (name.equals("Resettie")) {
			return 1;
		}
		int val = name.compareTo(other.name);
		if (val == 0) {
			// TODO wenn name gleich, dann vergleiche nummer
			if (number < other.number) {
				return -1;
			} else if (number > other.number) {
				return 1;
			}
		}
		return val;
	}

}
