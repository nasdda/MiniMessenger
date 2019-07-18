/*@Author Xin Yan. 
 * Connection might timeout for long distance messaging. -Not enough testing.
 * 
  */
 


import java.net.ServerSocket;
import java.net.Socket;

public class Main_Server { //Main class for server. Should be separate from Client classes. Used together with Server_Receiver and Server_Sender.
	
	public static void main(String[] args) throws Exception {
		
		try(ServerSocket serverSocket = new ServerSocket(PORT_NUMBER)) {  //Modify PORT_NUMBER accordingly.
	        Socket socket = serverSocket.accept();
		Thread t1 = new Thread( () -> { //Thread for receiving messages from client.
	                new Server_Receiver(socket).start();;
	            });
		 		
		t1.start();

		
		
		Thread t2 = new Thread( () -> {//Thread for sending messages to client.
	                new Server_Sender(socket).start();;
	            });
		
		t2.start();
	
		}catch(Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}
	}
	

}