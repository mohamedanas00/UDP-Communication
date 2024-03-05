import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class clientUDP {
    public static void main(String[] args) throws Exception {
        try {
            
            DatagramSocket dataGramSocket =new DatagramSocket();
            
            System.out.println("Enter Your Message :");
            String message= "";
            Scanner scanner = new  Scanner(System.in);
            message = scanner.nextLine();
            
            //*'InetAddress' class is used to represent IP addresses */
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            DatagramPacket dp= new DatagramPacket(message.getBytes(),message.length(),ip,2024);
            dataGramSocket.send(dp);
            
            //*********RECEIVE MESSAGE FROM SERVER**********/
            byte[] msg= new byte[1024];
            DatagramPacket dp2 = new DatagramPacket(msg, msg.length);
            dataGramSocket.receive(dp2);
            String msgRec = new String(dp2.getData(), 0, dp2.getLength());
			System.out.print(msgRec);

            scanner.close();
            dataGramSocket.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
