/**
 * 
 */
package datastructures;

import java.util.HashSet;
import java.util.Iterator;

public class MySet {

	public static void main(String[] args) {
		HashSet<String> names = new HashSet<>();
		
		names.add("Wolverine");
		names.add("Pika");
		names.add("Tim Apple");
		names.add("Diggibiggi");
		names.add("Joe Mama");
		
//		for(String name : names) {
//			System.out.println(name);
//			if(name.equals("Pika")) {
//				names.remove(name);
//			}
//		}
		
		
		Iterator<String> iterator = names.iterator();
		while(iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
			if(name.equals("Pika")) {
				iterator.remove();
			}		
		}
		System.out.println(names.size());
	}
}

