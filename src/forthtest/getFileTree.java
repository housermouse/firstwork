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
		System.out.println("��Ŀ¼�¶��������"+tempList.length);
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
			System.out.println("�ļ��У�"+temp.getFileName()+"  "+temp.getDatatime());
			str=str+"�ļ��У�"+temp.getFileName()+"  "+temp.getDatatime()+"\n";
		}
		for(int i=0;i<count2;i++) {
			Files temp=files.poll();
			System.out.println("�ļ���"+temp.getFileName()+"  "+temp.getDatatime()+"  "+temp.getLength());
			str=str+"�ļ���"+temp.getFileName()+"  "+temp.getDatatime()+"  "+temp.getLength()+"\n";
		}
		File file;//�����ļ���
		FileOutputStream stream = null;//new�ļ���
		try {
			file = new File("F:\\JAVA\\workspace\\firsttest\\src\\forthtest\\File.txt");
			stream = new FileOutputStream (file);//���ļ��з����ļ�����
			if (!file.exists()) { 
					file.createNewFile();
			}
			byte[] contentInBytes = str.getBytes();//ת�����ֽ���
			stream.write(contentInBytes);//д��
			stream.flush(); //д��֮��ˢ��
			stream.close();//�ر���
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}	
	}
}
