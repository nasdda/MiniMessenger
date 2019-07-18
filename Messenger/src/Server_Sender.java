import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Server_Sender extends Thread{
	
	private Socket socket;
	
	public Server_Sender(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			Scanner send = new Scanner(System.in);
			PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
			String msg;
			System.out.println("Type a msg to send");
			
			while(true) {
				if(send.hasNext()) {
					msg = send.nextLine();
					output.println(msg);//prints the message to the server output stream.
				}
			
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	
	}

}