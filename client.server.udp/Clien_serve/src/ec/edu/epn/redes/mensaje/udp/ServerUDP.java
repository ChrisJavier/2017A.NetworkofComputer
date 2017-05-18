package ec.edu.epn.redes.mensaje.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDP {

	
	
		private static int PORT =9091;
		
		
		public static void main(String[] args) throws IOException{
			
			
			DatagramSocket serverSocket = new DatagramSocket(PORT);
			System.err.println("el escucha al puerto"+PORT+"usando la conexion UDP\n");
			
			
			try{
				while(true){
					
					//recibe el paquete
					byte bufferReceive[] = new byte[128];
					DatagramPacket receivePacket = new DatagramPacket(bufferReceive, bufferReceive.length);
					serverSocket.receive(receivePacket);
					InetAddress clientAddress = receivePacket.getAddress();
					int clientPort = receivePacket.getPort();
					System.out.println("Puerto del Cliente: "+clientPort+"\n");
					
					
					
					//envia el paquete
					String msg = "Mensaje del servidor";
					byte bufferSend[]= msg.getBytes();
					DatagramPacket sendPacket= new DatagramPacket(bufferSend, bufferSend.length,clientAddress,clientPort);
					serverSocket.send(sendPacket); 
				
				
				}
			}finally{
				serverSocket.close();
			}
		}
		
}
