package forthtest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import thirdtest.Task;

public class getFileTree {	
	private LinkedList<Directory> Directory = new LinkedList<Directory>();
	private LinkedList<Files> files = new LinkedList<Files>();

	public void getInformation() {
		System.out.println("Enter a line:(like:F:\\baiduyun)");
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		File file=new File(input);
		File[] tempList = file.listFiles();	
		Format simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("该目录下对象个数："+tempList.length);
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isDirectory()) {
				Directory WJJ=new Directory();
				WJJ.setFileName(tempList[i].getName());
				String dateString = simpleFormat.format(tempList[i].lastModified());
				WJJ.setDataTime(dateString);
				Directory.add(WJJ);
				int count=Directory.size();
				Collections.sort(Directory.subList(0, count));
			}
			if (tempList[i].isFile()) {
				Files WJ=new Files();
				WJ.setFileName(tempList[i].getName());
				String dateString = simpleFormat.format(tempList[i].lastModified());
				WJ.setDataTime(dateString);
				WJ.setLength(tempList[i].length());
				files.add(WJ);
				int count=files.size();
				Collections.sort(files.subList(0, count));
				
			}
		}
		save();
	}
	public void save() {
		String str="";
		int count1=Directory.size();
		int count2=files.size();
		for(int i=0;i<count1;i++) {
			Directory temp=Directory.poll();
			System.out.println("文件夹："+temp.getFileName()+"  "+temp.getDatatime());
			str=str+"文件夹："+temp.getFileName()+"  "+temp.getDatatime()+"\n";
		}
		for(int i=0;i<count2;i++) {
			Files temp=files.poll();
			System.out.println("文件："+temp.getFileName()+"  "+temp.getDatatime()+"  "+temp.getLength());
			str=str+"文件："+temp.getFileName()+"  "+temp.getDatatime()+"  "+temp.getLength()+"\n";
		}
		File file;//创建文件夹
		FileOutputStream stream = null;//new文件流
		try {
			file = new File("F:\\JAVA\\workspace\\firsttest\\src\\forthtest\\File.txt");
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
