import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * 
 */

/**
 * @author jenny
 *
 */
public class ConnectionThread extends Thread{
	ArrayList<PrintWriter> list;
	ArrayList<ReaderThread> list2;
	private ServerSocket serverSocket;
	private boolean isRunning=true;
	private BlockingQueue<String> queue;
	
	
	
	public ConnectionThread( ServerSocket serverSocket, ArrayList<PrintWriter> list,ArrayList<ReaderThread> list2,BlockingQueue<String> queue) {
		super();
		this.list = list;
		this.serverSocket = serverSocket;
		this.list2 = list2;
		this.queue = queue;
	}


	
	@Override
	public void run() {
		
			
			try {
					Socket socket=serverSocket.accept();
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					Scanner scanner = new Scanner(socket.getInputStream());
					System.out.println(scanner.nextLine());
					list.add(printWriter);
					printWriter.println("Hallo Client :)");
					
					ReaderThread readerThread = new ReaderThread(scanner, queue);
					list2.add(readerThread);
					readerThread.start();

					
			} catch (Exception e) {
	
				e.printStackTrace();
			}
			
		

	}

	


}
