import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;


/**
 * 
 */

/**
 * @author jenny
 *
 */
public class WriterThread extends Thread{
	private BlockingQueue<String> queue;
	private ArrayList<PrintWriter> list;
	private boolean isRunning = true;
	
	public WriterThread(ArrayList<PrintWriter> list, BlockingQueue<String> queue) {
		super();
		this.list = list;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (isRunning) {
			
			try {
				for(PrintWriter print : list) {
					String message = queue.take();
					print.println(message);
					System.out.println("written");
				}
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
	public void quit() {
		isRunning = false;
	}


	

}
