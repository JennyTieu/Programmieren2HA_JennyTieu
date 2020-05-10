/**
 * 
 */
package datastructures;

import java.util.HashMap;
import java.util.Set;

/**
 * @author jenny
 *
 */
public class Einkaufsliste {


	public static void main(String[] args) {
		HashMap<String, String> shoppingList = new HashMap<>();
		
		shoppingList.put("Toilettenpapier","eine Packung");
		shoppingList.put("Schokolade","50 Riegel");
		shoppingList.put("Tacos","30 St�ck");
		shoppingList.put("Gundam","2 Sets");
		shoppingList.put("Nook Mile Tickets","100 St�ck");
		
		Set<String> product = shoppingList.keySet();
		for(String prod : product) {
			System.out.println(prod + " : " + shoppingList.get(prod));
		}
	}
	
	

}
