package forthtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {
	public void copyFile()  {
		File file1 = new File("src.txt");
		File file2 = new File("dest.txt");
		int output = 0;

		
		try {
			FileReader fr = null;
			fr = new FileReader(file1);
			FileWriter fw = new FileWriter(file2);
			while((output = fr.read()) != -1){
				fw.write(output);
			}
			fw.close();
			fr.close();
			
			FileInputStream fi1 = new FileInputStream(file2);
			byte byt[] = new byte[20000];
			int len = fi1.read(byt);
			/*System.out.println("文件中的内容是：");
			System.out.println(new String(byt,0,len));*/
			fi1.close();
			fi1.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
