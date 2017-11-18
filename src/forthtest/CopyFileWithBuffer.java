package forthtest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class CopyFileWithBuffer {
	public void copyFileWithBuffer()  {
		File file1 = new File("src.txt");
		File file2 = new File("dest.txt");
		int output = 0;

		
		try {
			FileReader fr = null;
			fr = new FileReader(file1);
			BufferedReader bfr =new BufferedReader(fr);
			FileWriter fw = new FileWriter(file2);
			BufferedWriter bfw =new BufferedWriter(fw);
			while((output = bfr.read()) != -1){
				bfw.write(output);
			}
			bfw.flush();
			fw.close();
			bfw.close();
			bfr.close();
			fr.close();
			
			FileInputStream fi1 = new FileInputStream(file2);
			BufferedInputStream bfi1=new BufferedInputStream(fi1);
			byte byt[] = new byte[20000];
			int len = bfi1.read(byt);
			//System.out.println("文件中的内容是：");
			//System.out.println(new String(byt,0,len));
			fi1.close();
			bfi1.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
