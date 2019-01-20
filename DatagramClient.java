import java.net.*;
import java.io.*;
class DatagramClient

{
	public static void main(String[] args) 
	{
		DatagramSocket sock=null;
		int port=7777;
		String s;
		BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
		try
		{
			sock=new DatagramSocket();
			InetAddress host=InetAddress.getByName("localhost");
			while(true)
			{
				System.out.println("Enter a message to send:");
				s=(String)cin.readLine();
				byte b[]=s.getBytes();
				DatagramPacket dp=new DatagramPacket(b,b.length,host,port);
				sock.send(dp);

				//Receive the packet

				byte[] buffer=new byte[65536];
				DatagramPacket reply=new DatagramPacket(buffer,buffer.length);
				sock.receive(reply);
				byte[] data=reply.getData();
				s=new String(data,0,reply.getLength());

			}
		}
		catch (IOException e)
		{
			System.err.println("IOException"+e);

		}
		
	}
}


