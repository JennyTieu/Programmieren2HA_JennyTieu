import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 */

/**
 * @author jenny
 *
 */
public class ServerMain {

	public void createServer() {
		
		try {
			//port über Bereich 1600
			ServerSocket serverSocket = new ServerSocket(3445,3);

			BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
			ArrayList<ReaderThread> list2 = new ArrayList<ReaderThread>();
			ArrayList<PrintWriter> list = new ArrayList<PrintWriter>();	
			
			
			
			ConnectionThread connectionThread = new ConnectionThread(serverSocket, list, list2, queue);
			
			WriterThread writerThread= new WriterThread(list, queue);
			
			connectionThread.start();
			writerThread.start();
			
			
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ServerMain server = new ServerMain();
		server.createServer();
		}

}
