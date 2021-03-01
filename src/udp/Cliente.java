package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DatagramSocket sockUDP =  new DatagramSocket();
			InetAddress direccion = InetAddress.getByName("localhost");
			Integer puerto = 5000;
			String numero;
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Que numero quieres usar?");
			numero = sc.nextLine();
			
			byte[] buffer;
			buffer = numero.getBytes();
			DatagramPacket envio = new DatagramPacket(buffer, buffer.length, direccion, puerto);
			sockUDP.send(envio);
			
			byte[] buffer2;
			buffer2 = new byte[10];
			DatagramPacket recibir = new DatagramPacket(buffer2, buffer2.length);
			sockUDP.receive(recibir);
			String cuadrado = new String(recibir.getData());
			System.out.println(cuadrado);
			
			sockUDP.close();
			
		} catch (SocketException | UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
