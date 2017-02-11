package NETHelpper;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class NETConnection {

	public static boolean sentMessage(String ip, String message,int port) {
		boolean send = false;
		byte[] buffer = new byte[1024];
		DatagramSocket datagram = null;
		InetAddress host = null;
		
		try {
			datagram = new DatagramSocket();
			host = InetAddress.getByName(ip);
			buffer = message.getBytes();
			
			DatagramPacket paquete = new DatagramPacket(buffer, message.length(), host, port);
			datagram.send(paquete);
			send = true;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(!datagram.isClosed()){
				datagram.close();
			}
		}

		return send;
	}
	
	public static String reciveMessage(int port) throws SocketException{
		
		String message = null;
		byte[] messageData = new byte[1024];
		DatagramPacket packageRecived = new DatagramPacket(messageData,0,messageData.length);
		
		try {
			DatagramSocket sockets = new DatagramSocket(port);
			sockets.receive(packageRecived);
			
	        message = new String(packageRecived.getData(),0,packageRecived.getLength());
	        
	        sockets.close( );
			
		} catch (IOException e) {
			message = "Puerto ocupado en escucha.";
		}
		
		return message;
	}
}
