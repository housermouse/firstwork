package forthtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
	public void createFile() throws IOException {
		File file1 = new File("src.txt");
		File file2 = new File("dest.txt");
		int input;
		int output;
		FileOutputStream stream = new FileOutputStream(file1);//new文件流
		while((input = System.in .read()) != '\n'){
			stream.write(input);
		}
		
		FileReader fr = new FileReader(file1);
		FileWriter fw = new FileWriter(file2);
		
		while((output = fr.read()) != -1){
			fw.write(output);
		}
		fr.close();
		fw.close();
		FileInputStream fi1 = new FileInputStream(file2);
		byte byt[] = new byte[1024];
		int len = fi1.read(byt);
		System.out.println("文件中的内容是："+new String(byt,0,len));
		fi1.close();
	}
}



