
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
public class CalculatorClient implements AutoCloseable {
    private Socket clientSocket;
    private DataOutputStream out;
    private DataInputStream in;
 
    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new DataOutputStream(clientSocket.getOutputStream());
        in = new DataInputStream(clientSocket.getInputStream());
    }
 
    public Double sendMessage(double... numbers) throws IOException {
        if(numbers.length == 2){
            out.writeDouble(numbers[0]);
            out.writeDouble(numbers[1]);
            return in.readDouble();
        } else {
            throw new IllegalArgumentException("Must enter 2 numbers");
        }
    }

    @Override
    public void close() throws Exception {
        in.close();
        out.close();
        clientSocket.close();
    }
}
