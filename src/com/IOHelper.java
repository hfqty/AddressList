package com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOHelper {
	//1.
	public static void writeToFile() throws IOException {
	     new Operate();
		FileOutputStream fos1 = new FileOutputStream("src\\通讯录.txt",true);
		ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
		oos1.close();
	}
	
	//2.
	public static void readFromFile() throws IOException, ClassNotFoundException {
		new Operate();
		FileInputStream fis1 = new FileInputStream("src\\通讯录.txt");
		ObjectInputStream ois1 = new ObjectInputStream(fis1);
		ois1.readObject();
	
		ois1.close();
		
	}
	
	
	
	

}
