
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author claudiu
 */
public class ServerCalculator implements AutoCloseable {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataOutputStream out;
    private DataInputStream in;
 
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());
    }
    
    public void calculateSum() throws IOException{
        Double first = in.readDouble();
        Double second = in.readDouble();
        out.writeDouble(first + second);
    }

    @Override
    public void close() throws Exception {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
