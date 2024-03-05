import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class serverUDP {
    public static void main(String[] args) {
        try {
            //*Server is listing in port 2024
            DatagramSocket ds = new DatagramSocket(2024);
            System.out.println("Server is Running on port 2024...");
            
            //*receive buffer from client */
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            System.out.println("Before receive ....");
            ds.receive(dp);

            //*Receive message from client
            System.out.println("Message Receive..");
            String message = new String(dp.getData(),0,dp.getLength());
            System.out.println(message);
            
            //*SEND MESSAGE TO CLIENT*/
            InetAddress cAddress =dp.getAddress();
            int port = dp.getPort();
            System.out.println("Enter Your Message :");
            String msg= "";
            Scanner scanner = new  Scanner(System.in);
            msg = scanner.nextLine();
            DatagramPacket dp2 =new DatagramPacket(msg.getBytes(), msg.length(),cAddress,port);
            ds.send(dp2);

            scanner.close();
            ds.close();
        } catch (Exception e) {
        }
    }
}
