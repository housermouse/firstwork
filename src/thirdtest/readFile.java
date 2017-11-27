package thirdtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import forthtest.Student;

public class readFile {
	public Task[] readFile() {
		try { 
			Task[] item = new Task[100];
			File file = new File("F:\\JAVA\\workspace\\firsttest\\src\\thirdtest\\input.txt");   
			if (file.isFile() && file.exists()) {   
				FileInputStream fis =new FileInputStream(file);
				Scanner reader=new Scanner(fis);		
					int temp=0;
				while (reader.hasNext()) {
					
					item[temp]=new Task();
					item[temp].setTaskID(reader.nextInt());
					item[temp].setArrivalTime(reader.nextInt());
					item[temp].setServiceTime(reader.nextInt());
					/*System.out.println(item[temp].getTaskID()+" "+item[temp].getArrivalTime()
							+" "+item[temp].getServiceTime());  */ 
					temp++;
				}  
				reader.close();   
				return item;
			}else{   
				System.out.println("找不到指定的文件！");   
			}   
			} catch (Exception e) {   
				System.out.println("读取文件内容操作出错");   
				e.printStackTrace();   
			}
		return null;   		
	}
}
