/**
 * 
 */
package datastructures;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author jenny
 *
 */
public class EventMain {

	public static void main(String[] args) {
		HashSet<Event> events = new HashSet<Event>();

		events.add(new Event("Brother Birthdayparty", "Home", "23.03.2020, 20:00"));
		events.add(new Event("Luna Visit", "Airport T1", "30.03.2020, 14:45"));
		events.add(new Event("Daisy May Turnip Day", "Nook Store", "02.05.2020, 08:00"));
		events.add(new Event("Brother Birthdayparty", "Home", "23.03.2020, 20:00"));
		events.add(new Event("Dorky Shiba Day", "Shiba Heaven", "23.03.2020, 15:30"));

		Iterator<Event> iterator = events.iterator();

		while (iterator.hasNext()) {
			int count = 0;
			Event event = iterator.next();
			Iterator<Event> iterator2 = events.iterator();
			while (iterator2.hasNext()) {
				Event otherEvent = iterator2.next();
				if (event.equals(otherEvent)) {
					count++;

				}

			}

			if (count > 1) {
				iterator.remove();
			} else {

				System.out.println(
						event.getEventName() + "; Location: " + event.getLocation() + "; Time: " + event.getTime());
			}
		}

	}

}
