import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Server_Receiver extends Thread{
	private Socket socket;
	
	public Server_Receiver(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Connected");
			BufferedReader input = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			while(true) {
				String echoString;
				if((echoString = input.readLine())!=null) {
				System.out.println("Recieved: " + echoString); //Gets message from client input stream.
				}
			}
		}catch(IOException e) {
			System.out.println("Exception at echoer " + e.getMessage());
		}finally {
			try {
				socket.close();
			}catch(IOException e) {
				
			}
		}
	}

}