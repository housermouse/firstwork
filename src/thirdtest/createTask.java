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
		File file;//�����ļ���
		FileOutputStream stream = null;//new�ļ���
		try {
			file = new File("F:\\JAVA\\workspace\\firsttest\\src\\thirdtest\\File.txt");
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
