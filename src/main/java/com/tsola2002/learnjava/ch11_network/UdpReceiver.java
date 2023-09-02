package com.tsola2002.learnjava.ch11_network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiver {


  public static void main(String[] args) {
    try( DatagramSocket ds = new DatagramSocket(3333)){
      // CREATING THE PACKET
      DatagramPacket dp = new DatagramPacket(new byte[30], 30);
      // RECEIVING THE PACKET
      ds.receive(dp);
      int i = 1;
      for(byte b: dp.getData()){
        System.out.print(Character.toString(b));
        if(i++ == dp.getLength()){
          // EXIT THE PROGRAM
          break;
        }
      }


// NORMAL RECEIVE CODE
//      ds.receive(dp);
//      int i = 1;
//      for(byte b : dp.getData()){
//        System.out.print(Character.toString(b));
//        if( i++ == dp.getLength()){
//          // EXIT THE PROGRAM
//          break;
//        }
//      }

//LOOPING CODE
//      while(true){
//        ds.receive(dp);
//        for(byte b: dp.getData()){
//          System.out.print(Character.toString(b));
//        }
//        System.out.println();
//      }
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }

}
