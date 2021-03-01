package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			int puerto = 5000;
			byte[] buffer;
			buffer = new byte[50];
			DatagramSocket sockUDP = new DatagramSocket(puerto);
			InetAddress direccion;
			String cadenaCuadrado;
			Integer numero, cuadrado;
			
			DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
			sockUDP.receive(paqueteRecibido);
			direccion = paqueteRecibido.getAddress();
			puerto = paqueteRecibido.getPort();
			System.out.println(direccion);
			
			String cadenaNumero = new String(paqueteRecibido.getData());
			cadenaNumero = cadenaNumero.trim();
			numero = Integer.parseInt(cadenaNumero);
			cuadrado = numero * numero;
			System.out.println(cuadrado);
			cadenaCuadrado = ""+cuadrado;
			System.out.println(cadenaCuadrado);
			
			
			byte[] buffer2;
			buffer2 = cadenaCuadrado.getBytes();
			DatagramPacket envio = new DatagramPacket(buffer2, buffer2.length, direccion, puerto);
			sockUDP.send(envio);
			
			sockUDP.close();
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
