package thirdtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class readFile {
	public Task[] readFile() {
		try { 
			Task[] item = new Task[100];
			File file = new File("F:\\JAVA\\workspace\\firsttest\\src\\thirdtest\\File.txt");   
			if (file.isFile() && file.exists()) {   
				InputStreamReader read = new InputStreamReader(new FileInputStream(file));   
				BufferedReader bufferedReader = new BufferedReader(read);   
				String lineTXT = null;int temp=0;  
				
				while ((lineTXT = bufferedReader.readLine()) != null) {
					String[] split=lineTXT.split(" ");
					item[temp]=new Task();
					item[temp].setTaskID(Integer.parseInt(split[0]));
					item[temp].setArrivalTime(Integer.parseInt(split[1]));
					item[temp].setServiceTime(Integer.parseInt(split[2]));
					//System.out.println(split[0]+" "+split[1]+" "+split[2]);   
					temp++;
				}  
				read.close();   
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
