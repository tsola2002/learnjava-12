package com.tsola2002.learnjava.ch11_network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSender {

  public static void main(String[] args) {
    // CREATE THE SOCKET OVER WHICH PACKETS WILL BE SENT
    try(DatagramSocket ds = new DatagramSocket()){
      String msg = "Hi How are you doing?";
      // CREATING THE LOCAL HOST ADDRESS
      InetAddress address = InetAddress.getByName("127.0.0.1");
      DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.length(), address, 3333);
      // SET THE BUFFER SIZE OF THE SOCKET
      ds.setSendBufferSize(100);

      // SENDING THE DATAGRAM PACKET OVER THE DATAGRAM SOCKET
      ds.send(dp);
    } catch (Exception ex){
      ex.printStackTrace();
    }
  }
}
