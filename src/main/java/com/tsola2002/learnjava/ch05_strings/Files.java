package com.tsola2002.learnjava.ch05_strings;

import java.io.File;

public class Files {

  public static void main(String[] args) {

    //createFile1();
    // createFile2();
    list1();

  }

  private static void list1() {
    String path1 = "folder1" + File.separator + "folder2" + File.separator;
    //String path2 = "folder2" + File.separator;
    //String path =  path1; // folder2/folder1/
    File f1 = new File(path1 + "file1.txt");
    File f2 = new File(path1 + "file2.txt");
    // File dir1 = new File(path1);
    File dir = new File(path1);
    try {
      dir.mkdirs();
      f1.createNewFile();
     f2.createNewFile();
     // f1.delete();
     // f2.delete();
      for(String f: dir.list()){
        System.out.print(f + " ");
      }
//      System.out.print("\ndir1.listFiles(): ");
//      for(File f: dir1.listFiles()){
//        System.out.print(f + " ");
//      }
//      System.out.print("\ndir.list(): ");
//      for(String d: dir.list()){
//        System.out.print(d + " ");
//      }
//      System.out.print("\ndir.listFiles(): ");
//      for(File f: dir.listFiles()){
//        System.out.print(f + " ");
//      }
//      System.out.print("\nFile.listRoots(): ");
//      for(File f: File.listRoots()){
//        System.out.print(f + " ");
//      }
//      System.out.println();
//      System.out.println();
 //     f1.delete();
  //    f2.delete();
     // path = StringUtils.substringBeforeLast(path, File.separator);
    //  while (new File(path).delete()) {
     //   path = StringUtils.substringBeforeLast(path, File.separator);
   //   }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }



  private static void createFile1() {
    File f = new File("ournewfile.txt");
    try {
      f.createNewFile();
     //f.delete();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }



}
