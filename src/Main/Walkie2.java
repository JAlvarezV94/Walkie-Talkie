package Main;

import java.net.SocketException;

import HelpperPackage.UI;
import HelpperPackage.Validations;
import NETHelpper.NETConnection;

public class Walkie2 {

	public static void main(String[] args) {
		byte option = 0;
		int port = 0;
		boolean exit = false;
		boolean stopCommunication = false;
		String message = null;
		String ip = null;
		
		port = UI.chooseChannel();

		do{
			UI.printMenu();
			option = UI.chooseOption();
			
			switch(option){
			case 1:
				message = UI.writeMessage();
				NETConnection.sentMessage(ip, message, port);
				break;
			case 2:
				do{
					try {
						message = NETConnection.reciveMessage(port);
					} catch (SocketException e) {
					}
					UI.showMessage(message);
					stopCommunication = Validations.stopCommunication(message);					
				}while(!stopCommunication);
				break;
			case 3:
				exit = true;
			}
		}while(!exit);
	}

}
