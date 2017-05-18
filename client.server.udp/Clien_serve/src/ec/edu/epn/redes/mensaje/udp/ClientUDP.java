package ec.edu.epn.redes.mensaje.udp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JOptionPane;

public class ClientUDP {

	
		private static int SERVER_PORT= 9091;
		
		
		
		
		public static void main(String[] args) throws IOException{
			
			
			String serverAddress = JOptionPane.showInputDialog("Ingrese la direccion IP de una maquina  "
			+ "Arranca un mensaje en el puerto"+ SERVER_PORT + ":");
			
			//enviar un paquete (request)
			DatagramSocket clientSocket = new DatagramSocket();
			byte bufferSend[] = serverAddress.getBytes();// cantidad de bytes a enviar
			DatagramPacket sendPacket = new DatagramPacket(bufferSend, bufferSend.length,InetAddress.getByName(serverAddress)/*convierte la direccion en net*/,SERVER_PORT);// contruye el objeto con loongitud y el buffer
			clientSocket.send(sendPacket);//envia el packet
			//reconoce la cantidad de bytes a enviar
			
			
			//recibe el packet
			byte bufferReceive[] = new byte[128];
			DatagramPacket receivePacket= new DatagramPacket(bufferReceive, bufferReceive.length);//paquete de recepcion
			clientSocket.receive(receivePacket);//recibe el mensaje
			
			//Transforma el paquete de bytes a string
			InputStream myInputSteam= new ByteArrayInputStream(receivePacket.getData());
			BufferedReader input = new BufferedReader(new InputStreamReader(myInputSteam));
			String answer = input.readLine();
			
			//mensaje recibido por el servidor y termina
			JOptionPane.showMessageDialog(null, answer);
			clientSocket.close();
			System.exit(0);
			
			
			
		}
		
}
