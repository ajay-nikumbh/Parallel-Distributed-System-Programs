
import java.net.*;
import java.io.*;
public class DatagramServer
{
	public static void main(String h[])
	{
		DatagramSocket  sock=null;
		try
		{
			sock =new DatagramSocket(7777);
			byte buffer[]=new byte[65536];
			//Creation of the packet
			DatagramPacket incoming =new DatagramPacket(buffer ,buffer.length);
			System.out.println("Server scoket created .. Waitng for the incoming message..");
			while(true)
			{
				//Receive the packet
				sock.receive(incoming);
				byte[] data=incoming.getData();
				String s=new String(data,0,incoming.getLength());
				System.out.println("Server says your message is:"+s);

				//Send the Packet
				DatagramPacket dp=new DatagramPacket(s.getBytes(),s.getBytes().length,incoming.getAddress(),incoming.getPort());
				sock.send(dp);

			}
		}
		catch (IOException e)

		{
			System.out.println(e);
		}

	}
}