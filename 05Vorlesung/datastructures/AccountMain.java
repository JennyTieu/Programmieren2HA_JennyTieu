/**
 * 
 */
package datastructures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author jenny
 *
 */
public class AccountMain {
	public static String userName;
	public static long userNumber;
	public static boolean isValid=false;
	public static boolean userIsValid=false;
	public static Account test,tester;
	
	public static void main(String[] args) {
		HashSet<Account> set = new HashSet<Account>();
		
		set.add(new Account("sherb", 284824375L));
		set.add(new Account("test", 1568743412345678L));
		set.add(new Account("raymond", 1233423243L));
		set.add(new Account("marshal", 96545465767L));
		

		
		while(userIsValid==false) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Username:");
			userName= sc.next();
			System.out.println("Phone Number:");
			if(sc.hasNextLong()) {
				userNumber=sc.nextLong();
				test= new Account(userName,userNumber);
				isValid=true;
			}
			else {
				isValid=false;
				System.out.println("Invalid Number! Please try again");
			}
			
			if(isValid==true) {
				Iterator<Account> it = set.iterator();
				while(it.hasNext()) {
					tester= it.next();
					if(test.equals(tester)) {
						System.out.println("Username already exists or Phone Number already in use!\nPlease try again!");
						isValid=false;
						userIsValid=false;
						break;
					}
					else {
						userIsValid=true;

					}
				}
				if(userIsValid=true){
					sc.close();
				}
				
			}

		}
		
		set.add(test);
		System.out.println("Account created!");
		
		
		
		
		
		
	}

}
