package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	
	 public static void main(String[] args) {
		
		 ServerSocket servidor;
		 Socket sock;
		 Scanner sc = new Scanner(System.in);
		 int puerto, numero, cuadrado;
		 DataInputStream entrada;
		 DataOutputStream salida;
		 
		 System.out.println("En que puerto quieres trabajar?");
		 puerto = sc.nextInt();
		 sc.nextLine();
		 
		 try {
			servidor = new ServerSocket(puerto);
			sock = servidor.accept();
			
			entrada = new DataInputStream(sock.getInputStream());
			numero = entrada.readInt();
			System.out.println(numero);
			cuadrado = numero * numero;
			
			salida = new DataOutputStream(sock.getOutputStream());
			salida.writeInt(cuadrado);
			
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
