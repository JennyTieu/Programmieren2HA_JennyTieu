import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * 
 */

/**
 * @author jenny
 *
 */
public class ReaderThread extends Thread {
	private Scanner scanner;
	private BlockingQueue<String> queue;
	private boolean isRunning = true;

	public ReaderThread(Scanner scanner, BlockingQueue<String> queue) {
		super();
		this.scanner = scanner;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (isRunning) {

			try {
				String message = scanner.nextLine();
				System.out.println(message);
				queue.put(message);
				System.out.println("read");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void quit() {
		isRunning = false;
	}

}
