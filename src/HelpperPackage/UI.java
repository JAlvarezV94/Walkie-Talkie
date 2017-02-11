package HelpperPackage;

import java.util.Scanner;

public class UI {

	static Scanner entry = new Scanner(System.in);
	
	public static void printMenu(){
		System.out.println("**Elige una opcion**");
		System.out.println("1.- Mandar mensaje");
		System.out.println("2.- Escuchar canal.");
		System.out.println("3.- Salir");
	}
	
	public static byte chooseOption(){
		byte option;
		
		System.out.println("Elige una opcion: ");
		option = entry.nextByte();
		
		return option;
	}
	
	public static int chooseChannel(){
		int port;
		System.out.println("Establecer puerto para comunicarse: ");
		port = entry.nextInt();
		
		//Validate port
		
		
		return port;
	}
	
	public static String writeMessage(){
		String message = null;
		
		System.out.print("Escribe tu mensaje: ");
		entry.nextLine();
		message = entry.nextLine();
		
		return message;	
	}
	
	public static void showMessage(String message){
		System.out.println(message);
	}
}
