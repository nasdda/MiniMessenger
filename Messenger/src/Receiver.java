import java.net.*;
import java.io.*;
public class Receiver extends Thread{
	private Socket socket;
	
	public Receiver(Socket socket) {
		this.socket=socket;
	}
	
	
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  //Fetches input from host server.
			String response;
			while(true) {
				if(!(response=in.readLine()).trim().equals("") && response!=null) {
					System.out.println("Host: " + response);
				}
			}
		
		} catch (IOException e) {
			System.out.println("Exception at reciever: " + e.getMessage());
		}
	
	}
	

}
