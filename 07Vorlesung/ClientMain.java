import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * 
 */

/**
 * @author jenny
 *
 */
public class ClientMain {
	private boolean isRunning = true;

	public void createClient() {
		try {
			Socket socket = new Socket("127.0.0.1", 3445);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(socket.getInputStream());
			System.out.println("Bitte gib deinen Namen ein um die Verbindung zu akzeptieren:");
			
			String clientName = scanner.next();
			
			writeMessage(printWriter);
			

			while (isRunning) {
				System.out.println(scanner.nextLine());
			}

			
			scanner.close();
			printWriter.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeMessage(PrintWriter printWriter) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Scanner keyboard = new Scanner(System.in);
				while(isRunning) {
					String text = keyboard.next();
					if(text.equalsIgnoreCase("Quit")) {
						isRunning = false;
					} else {
						printWriter.println(text);
						printWriter.flush();							
					}
				}
				keyboard.close();
			}
		}).start();
	}

	public static void main(String[] args) {
		ClientMain client = new ClientMain();
		client.createClient();

	}

}
