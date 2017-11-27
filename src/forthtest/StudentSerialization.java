package forthtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentSerialization {
	private LinkedList<Student> students = new LinkedList<Student>();
	private LinkedList<Student> student2 = new LinkedList<Student>();
	public void readFile() {
		File file = new File("list.txt");
		try {
			FileInputStream fis =new FileInputStream(file);
			Scanner reader=new Scanner(fis);		
			while(reader.hasNext()) {
				Student temp = new Student();
				temp.setStuNo(reader.next());
				temp.setStuName(reader.next());
				temp.setSex(reader.next());
				//System.out.println(temp.toString());
				students.add(temp);
			}
			Collections.sort(students.subList(0, students.size()));
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void serialization() {
		try {
			FileOutputStream fos = new FileOutputStream("Student.bin");
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	        oos.writeObject(students);
	        
	        oos.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	 
	}
	public void show() {
		try {
			FileInputStream fis = new FileInputStream("Student.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			student2 = (LinkedList<Student>)ois.readObject();
			int count = student2.size();
			for(int i=0;i<count;i++) {
				Student temp = student2.poll();
				System.out.println(temp.toString());
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
	}
	
}
