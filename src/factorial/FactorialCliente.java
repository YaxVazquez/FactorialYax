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
import java.net.*;
import java.util.Scanner;
public class FactorialCliente {
		public static void main(String [] args){
                try {
                    String ip;
                    int puertoReceptor;
                    String mensaje;
                    
                    Scanner lee = new Scanner(System.in);
                    System.out.println("Teclee la ip");
                    ip = lee.nextLine();
                    InetAddress maquinaReceptora = InetAddress.getByName(ip);
                    
                    System.out.println("Teclee el puerto receptor");
                    puertoReceptor = lee.nextInt();

                    System.out.println("Teclee el numero");
                    lee.nextLine();
                    mensaje = lee.nextLine();
                    byte[ ] almacen = mensaje.getBytes( ); 
                    
                    DatagramSocket miSocket = new DatagramSocket();
                    DatagramPacket datagrama = new DatagramPacket(almacen, almacen.length, maquinaReceptora, puertoReceptor);
                    miSocket.send(datagrama);
                    miSocket.close( );
                    } 
                catch (Exception ex) {
                    ex.printStackTrace( ) ;
                } 
        }
}


