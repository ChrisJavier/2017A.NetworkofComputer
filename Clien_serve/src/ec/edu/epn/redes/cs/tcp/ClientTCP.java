package ec.edu.epn.redes.cs.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JOptionPane;

public class ClientTCP {

	
			private static int SERVER_PORT = 9090; //Puerto del servidor
			/*
			 * esto despleagara una ventana y preguntara la ip adress o hostname*/
			
			
	public static void main(String[] args) throws IOException
	{
		
		ServerSocket ss= null;
		final String HOST = "localhost";
		String serverAddress= JOptionPane.showInputDialog("Ingrese la direccion IP de la maquina "+ SERVER_PORT+":");
		String sumandos;
		
		sumandos=JOptionPane.showInputDialog(null, "Ingrese el primer numero de la suma: ");
		sumandos+=";"+JOptionPane.showInputDialog(null, "Ingrese el segundo numero de la suma: ");
		
		
		//Establece una conexion ante el servidor
		//conexion TCP
		Socket clientSocket= new Socket(serverAddress,SERVER_PORT);
		DataOutputStream outputStream= new DataOutputStream(clientSocket.getOutputStream());
		
		outputStream.writeUTF(sumandos);
		//Obtiene el mensaje del servidor enciado por el socket
		
		//lee los datos del mensaje
	
		//Socket recib= ss.accept();
		DataInputStream input = new DataInputStream(clientSocket.getInputStream());
		String answer = input.readUTF();
		//guarda la informacion recibida y la transforma a string
		
		
		
		//Imprime los datos del mensaje
		JOptionPane.showMessageDialog(null,"la suma de los numero enviados al servidor es: "+ answer);
		System.exit(0);
	
	
	
	
	}
}
