package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Worker extends Thread{
	
	DataInputStream in 		= null;
	DataOutputStream out 	= null;
	Socket socket 			= null;
	
	
	public Worker( Socket socket )
	{
		this.socket = socket;
	}
	
	
	public void run()
	{
		this.revMsg();
		this.sendMsg();
	}
	
	
	public void revMsg()
    {
    	try 
		{
    		this.in 		= new DataInputStream( this.socket.getInputStream() );
    		String readLine = this.in.readUTF();
		
    		System.out.println( "revMsg ::: " + readLine );
    		
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
    }
	
	
	public void sendMsg()
    {
		String str = "serverSend";
		
    	try 
		{
    		this.out = new DataOutputStream( this.socket.getOutputStream() );
    		this.out.writeUTF(str);
    		this.out.flush();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
    	
    }
	
	
}
