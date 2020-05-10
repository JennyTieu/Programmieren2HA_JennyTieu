/**
 * 
 */
package datastructures;

/**
 * @author jenny
 *
 */
public class HighScore implements Comparable<HighScore> {

	private String name;
	private int points;

	// Constructor
	public HighScore(String name, int points) {
		super();
		this.name = name;
		this.points = points;
	}

	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	// add unimplemented Methods
	//o ist other
	@Override
	public int compareTo(HighScore o) {
		//man kann this an sich weglassen weil es keine kollision gibt!
		if(this.points > o.points) {
			//reihenfolge -1
			return -1;
		} else if(this.points < o.points) {
			return 1;
		}
		// TODO Auto-generated method stub
		//wenn punktzahl gleich:
		return name.compareTo(o.name);
	}

}
