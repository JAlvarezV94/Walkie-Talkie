package Main;

import java.net.InetAddress;
import java.net.SocketException;

import HelpperPackage.UI;
import NETHelpper.NETConnection;

public class Walkie1 {

	public static void main(String[] args) {
		
		byte option = 0;
		int port = 0;
		boolean exit = false;
		String message = null;
		InetAddress host = null;
		
		port = UI.chooseChannel();

		do{
			UI.printMenu();
			option = UI.chooseOption();
			
			switch(option){
			case 1:
				message = UI.writeMessage();
				NETConnection.sentMessage(host, message, port);
				break;
			case 2:
				try {
					message = NETConnection.reciveMessage(port);
				} catch (SocketException e) {
				}
				UI.showMessage(message);
				break;
			case 3:
				exit = true;
			}
		}while(!exit);
	}

}
