package HelpperPackage;

import java.util.Scanner;

public class UI {

	static Scanner entry = new Scanner(System.in);
	
	//The method for print the menu
	public static void printMenu(){
		System.out.println("**Elige una opcion**");
		System.out.println("1.- Mandar mensaje");
		System.out.println("2.- Escuchar canal.");
		System.out.println("3.- Salir");
	}
	
	//The method for request and assign an option by keyboard
	public static byte chooseOption(){
		String auxiliar;
		boolean validated = false;
		byte option;
		
		//We going to request an option until validated values true
		do{
			System.out.println("Elige una opcion: ");
			auxiliar = entry.nextLine();
			validated = Validations.validateOption(auxiliar);
		}while(!validated);
		option = Byte.parseByte(auxiliar);
		
		return option;
	}
	
	public static int chooseChannel(){
		int port;
		String aux = null;
		boolean validated = false;
		
		//We request a new port for keyboard until validated'll been true 
		do{
			System.out.print("Establecer puerto para comunicarse: ");
			aux = entry.nextLine();	//We need to use a String because someone can introduce a letter
			validated = Validations.validatePort(aux);
		}while(!validated);
		port = Integer.parseInt(aux);
		
		return port;
	}
	
	public static String chooseIp(){
		String ip = null;
		boolean validated = false;
		
		do{
			System.out.print("Establecer la IP: ");
			validated = Validations.validateIp(ip);
		}while(!validated);
		
		return ip;
	}
	
	//The method that request a message by keyboard
	public static String writeMessage(){
		String message = null;
		
		System.out.print("Escribe tu mensaje: ");
		message = entry.nextLine();
		
		return message;	
	}
	
	
	//A method for print a received message
	public static void showMessage(String message){
		System.out.println(message);
	}
}
