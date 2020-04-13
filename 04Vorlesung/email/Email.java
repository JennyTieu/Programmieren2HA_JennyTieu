package email;

public class Email {

	private String title;
	private String sender;
	private String receiver;
	private String message;
	private String date;

	/**
	 * With that constructor you can set a title and a message of a mail.
	 * @param title of the mail
	 * @param message text of the mail
	 */
	public Email(String title, String message) {
		this.message = message;
		this.title = title;
	}

	/**
	 * With that constructor you can set a title and a message of a mail.
	 * @param title of the mail
	 * @param sender sender email address 
	 * @param receiver receiver email address
	 * @param message text of the mail
	 * @param date date as String of the mail. The date has the format dd.mm.yyyy
	 */
	public Email(String title, String sender, String receiver, String message, String date) {
		//TODO check values
		this.title = title;
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.date = date;
	}


	/**
	 * 
	 * @return title of the mail
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * Set the title of the mail
	 * @param title
	 */
	public void setTitle(String title) {
			this.title = title;			
	}


	/**
	 * 
	 * @return sender of the mail
	 */
	public String getSender() {
		return sender;
	}


	/**
	 * Set the sender of the mail
	 * @param sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}


	/**
	 * 
	 * @return receiver of the mail
	 */
	public String getReceiver() {
		return receiver;
	}


	/**
	 * Set the receiver of the mail
	 * @param receiver
	 */
	public void setReceiver(String receiver) {
			this.receiver = receiver;
	}


	/**
	 * 
	 * @return message of the mail
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * Set the message of the mail
	 * @param message
	 */
	public void setMessage(String message) {
			this.message = message;
	}


	/**
	 * 
	 * @return date of the mail
	 */
	public String getDate() {
		return date;
	}

	
	/**
	 * 
	 * @return a string in format of title<p>message
	 */
	@Override
	public String toString() {
		
		String mail = title + "\n\n" + message;
		return mail;
	}
}
