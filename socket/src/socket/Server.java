package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
    Socket socket = null;
    ServerSocket serverSocket = null;
    
    public Server() 
    {
        try 
        {
            this.serverSocket = new ServerSocket(7777); 
            System.out.println("서버 실행");
            
            
            while (true) 
            {
        		// 클라이언트가 다중으로 접속하기 위한 무한반복문
            	this.socket = this.serverSocket.accept();
                
                // connect 요청이 들어오면 연결 (올때까지 block)
                System.out.println("클라이언트 접속");
                System.out.println(socket);
               
                Worker wk = new Worker( this.socket );
                wk.start();
            }
            
            
        } 
        catch (IOException e) 
        {
        	
        } 
    }
    
    
    
    
    public static void main(String[] args)
    {
        new Server();
    }
    
}