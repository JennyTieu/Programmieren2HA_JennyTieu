/**
 * 
 */
package datastructures;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author jenny
 *
 */
public class ContactMain {

	public static void main(String[] args) {
		ArrayList<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact("Tom Nook", 1568743412345678L));
		contacts.add(new Contact("Isabelle", 14658623));
		contacts.add(new Contact("Sherb", 284824375));
		contacts.add(new Contact("Raymond", 1233423243));
		contacts.add(new Contact("Skye", 1313473444));
		contacts.add(new Contact("Zorro", 1313473445));
		contacts.add(new Contact("Chuck Norris", 0));
		contacts.add(new Contact("Resettie", 987654));
		contacts.add(new Contact("Sprocket",876544556));
		contacts.add(new Contact("Apple", 345678));

		// oder
		/*
		 * LinkedList<Contact> contacts = new LinkList<>(); contacts.add(new
		 * Contact("Alex",1234553));etc ...
		 * 
		 * 
		 * 
		 */

		Collections.sort(contacts);

		for (Contact con : contacts) {
			System.out.println(String.format("%20s:\t%d", con.getName(), con.getNumber()));
		}
	}

}
