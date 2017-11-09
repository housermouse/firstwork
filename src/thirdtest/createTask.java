package thirdtest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class createTask {
	public void createFile() {
		Task[] item = new Task[100];
		int searveTime=0;
		Random random=new Random();
		String str="";
		for(int i=0;i<100;i++) {
			int temp=random.nextInt(5);
			switch(temp) {
			case 0:searveTime=6;break;
			case 1:searveTime=2;break;
			case 2:searveTime=1;break;
			case 3:searveTime=3;break;
			case 4:searveTime=9;
			}
			item[i]=new Task();
			item[i].setTaskID(i+1);
			item[i].setArrivalTime(i);
			item[i].setServiceTime(searveTime);
			str=str+item[i].getTaskID()+" "+item[i].getArrivalTime()+" "+
			item[i].getServiceTime()+"\n";
		}
		//System.out.println(str);
		File file;//创建文件夹
		FileOutputStream stream = null;//new文件流
		try {
			file = new File("F:\\JAVA\\workspace\\firsttest\\src\\thirdtest\\File.txt");
			stream = new FileOutputStream (file);//将文件夹放在文件流中
			if (!file.exists()) { 
					file.createNewFile();
			}
			byte[] contentInBytes = str.getBytes();//转化成字节形
			stream.write(contentInBytes);//写入
			stream.flush(); //写完之后刷新
			stream.close();//关闭流
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
	}
}
