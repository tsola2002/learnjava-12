package com.tsola2002.learnjava.ch11_network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TcpClient {

  public static void main(String[] args) {
    try(Socket s = new Socket("localhost",3333);

        // we create Socket, DataInputStream, and DataOutputStream objects
        // based on our newly-created socket
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        // we create BufferedReader object will read the user input from the console
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in)))
      {

        String prompt = "Say something: ";
        System.out.print(prompt);

        String msg;
        // prompt is displayed on the console and the
        // readLine() method blocks until a user types something and clicks on Enter.
        while ((msg = console.readLine()) != null) {
          // write message from user into the outputstream
          dout.writeUTF(msg);
          dout.flush();
          if (msg.equalsIgnoreCase("end")) {
            break;
          }

          // it reads the bytes sent by the client as
          // a Unicode character string encoded in a modified UTF-8 format
          msg = dis.readUTF();
          System.out.println("Server said: " +msg);
          if (msg.equalsIgnoreCase("end")) {
            break;
          }
          System.out.print(prompt);

        }
      }
      catch(Exception ex)
      {
        ex.printStackTrace();
      }
  }
}
