package ec.edu.epn.redes.cs.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import org.omg.CORBA.portable.InputStream;

public class ServerTCP {

	
		private static int PORT=9090;
		
		//Arranca el server
		
		
		public static void main(String[] args) throws IOException{
			
			
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("El servidor escucha al puerto "+ PORT);
			
			try{
				
				while(true){
					
					//envia una respuesta en una comunicacion remota y acepta el puerto definido
					Socket socket = serverSocket.accept();
				try{
					
					System.out.println("Un cliente se ha conectado.");
					DataInputStream inputStream=new DataInputStream(socket.getInputStream());
					String sumandos= inputStream.readUTF();
					

					//PrinWriter Escibe datos en el socket 
					
					DataOutputStream out = new DataOutputStream(socket.getOutputStream()); //Envia mensaje de salida
					out.writeUTF(String.valueOf(Suma(sumandos)));
				
				}
				finally{//Finaliza procesos
					
					socket.close();
				
						}
			
							}
		}
		
	finally{
		serverSocket.close();
	}
}
		
static int Suma(String sumandos){

	
	StringTokenizer token = new StringTokenizer(sumandos,";");
	int suma =0;
	String numero="", n="";
	int i=1;
	JOptionPane.showMessageDialog(null, "los numeros recibidos por el servidor son:");
	while(token.hasMoreTokens()){
		
		n=token.nextToken();
		numero+="el numero  "+i+ " es: "+n+"\n";
		suma+= Integer.parseInt(n);
		i++;
	}
	JOptionPane.showMessageDialog(null, numero);
	return suma;
}
		
		
}
