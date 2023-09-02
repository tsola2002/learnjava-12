package com.tsola2002.learnjava.ch11_network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

  public static void main(String[] args) {
    // we create our socket here
    try(Socket s = new ServerSocket(3333).accept();

        // we create Socket, DataInputStream, and DataOutputStream objects
        // based on our newly-created socket
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        // we create BufferedReader object will read the user input from the console
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

      while(true){
        // it reads the bytes sent by the client as a Unicode character string encoded
        // in a modified UTF-8 format
        String msg = dis.readUTF();

        //print the message on the console
        System.out.println("Client said: " + msg);
        if("end".equalsIgnoreCase(msg)){
          break;
        }

        System.out.print("Say something: ");
        // prompt is displayed on the console and the
        // readLine() method blocks until a user types something and clicks on Enter.
        msg = console.readLine();

        // The server takes the input from the screen and writes it as a Unicode character
        // string to the output stream using the writeUtf() method
        //outputstream of the server is connected to input stream of the client
        dout.writeUTF(msg);
        dout.flush();
        if("end".equalsIgnoreCase(msg)){
          break;
        }
      }

    } catch (Exception ex){
      ex.printStackTrace();
    }
  }
}
