/**
 * 
 */
package datastructures;

/**
 * @author jenny
 *
 */
public class Account {
	private String user;
	private Long number;
	
	public Account(String user, Long number) {
		this.user = user;
		this.number = number;
	}


	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(!(obj instanceof Account)) {
			return false;
		}
		Account other = (Account) obj;
		if(user==null) {
			if(other.user != null) {
				return false;
			}
		}
		else if (user.equals(other.user)) {
			return true;
		}
		if(number==null) {
			if(other.number!=null) {
				return false;
			}
		}
		else if(number.equals(other.number)) {
			return true;
		}
		return false;
		
	}


	
	
	
	
	

}
