import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.io.*;
import java.util.*;


public class Main { //Main class for Client. Should be seperate from Server classes. Used together with Receiver class.
	public static void main(String[] args) {
		 try (Socket socket = new Socket(InetAddress.getByName("Server IP"), PORT_NUMBER)) { //Modify the Server IP and PORT_NUMBER accordingly.
			 
			 Thread t1 = new Thread(()-> { //Thread for receiving messages from host server. 
				 new Receiver(socket).start();
			 });
			 
			 t1.start();
			 
			 
			 //Sending message to host server. 
	            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);
	            Scanner scanner = new Scanner(System.in);
	            String echoString;
                System.out.println("Enter Message: ");
	            while(true) {
	                if(!(echoString = scanner.nextLine()).trim().equals("") && echoString!=null) {
	                	stringToEcho.println(echoString); //Prints line to output stream which would then be read by host server.
	                }
	            }

	        } catch (IOException e) {
	            System.out.println("Client Error: " + e.getMessage());
	        }
	}

}