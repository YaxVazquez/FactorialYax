/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

/**
 *
 * @author Alumno
 */
import java.math.BigInteger;
import java.net.*;
import java.util.Scanner;

public class FactorialServidor{
		public static void main(String [] args){
				try {
                                        int num;
                                        final int MAX_LON= 1000000;
                                        int puerto;
                                        Scanner leer = new Scanner(System.in);
                                        System.out.println("Teclee el puerto");
					puerto = leer.nextInt();

				DatagramSocket miSocket = new DatagramSocket (puerto);
				byte[] almacen = new byte[MAX_LON];
                                
				DatagramPacket datagrama = new DatagramPacket (almacen, MAX_LON);
				miSocket. receive (datagrama);
				String mensaje = new String(almacen);

                                num = Integer.parseInt(mensaje.trim());
                                BigInteger factorial = new BigInteger("1");
                                for( int i = 1; i<= num; i++) {
                                    factorial=factorial.multiply(new BigInteger(i + ""));
                                    num--;
                                }
                                System.out.println("El factorial es " + factorial);
                                miSocket.close( );

				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}	
}
