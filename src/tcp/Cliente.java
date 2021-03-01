package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket sock;
		Scanner sc = new Scanner(System.in);
		DataInputStream entrada;
		DataOutputStream salida;
		String direccion;
		int puerto, numero, cuadrado;
		
		System.out.println("Que direccion quieres usar: ");
		direccion = sc.nextLine();
		System.out.println("Elije el puerto que vas a usar");
		puerto = sc.nextInt();
		sc.nextLine();
		
		try {
			sock = new Socket(direccion, puerto);
			
			salida = new DataOutputStream(sock.getOutputStream());
			System.out.println("Que numero quieres usar?");
			numero = sc.nextInt();
			sc.nextLine();
			salida.writeInt(numero);
			
			entrada = new DataInputStream(sock.getInputStream());
			cuadrado = entrada.readInt();
			System.out.println("El cuadrado de "+numero+" es "+cuadrado);
			
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
