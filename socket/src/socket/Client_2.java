package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client_2 {
	Socket socket 			= null;
    DataInputStream in 		= null;
    DataOutputStream out 	= null;

    
    public Client_2() 
    {
        try 
        {
            this.socket = new Socket("localhost",7777);  // 연결 요청
            this.in 	= new DataInputStream( this.socket.getInputStream() );
            this.out 	= new DataOutputStream( this.socket.getOutputStream() );
 
            sendMsg();
            revMsg();
        } 
        catch (IOException e) 
        {
        	
        }
    }
    
    
    public void revMsg()
    {
    	try 
		{
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
    	try 
		{
    		String str = "tmp2";
    		this.out.writeUTF(str);
    		
    		this.out.flush();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
    	
    }
    
    
    public static void main(String[] args) 
    {
        new Client_2();
    }
    
}
