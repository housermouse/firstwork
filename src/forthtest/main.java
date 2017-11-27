package forthtest;

import java.io.IOException;

public class main {
	public static void main(String[] args) throws IOException {
		//CopyFile cf =new CopyFile();
		//cf.copyFile();
		//getFileTree GF =new getFileTree();
		//GF.getInformation();
        /*long start = System.currentTimeMillis();  
        CopyFileWithBuffer cfwb =new CopyFileWithBuffer();
		cfwb.copyFileWithBuffer(); 
        long end = System.currentTimeMillis();   
        System.out.println(end - start + "ms:withBuffer");  
        start = System.currentTimeMillis();  
        CopyFile cf =new CopyFile();
		cf.copyFile(); 
        end = System.currentTimeMillis();   
        System.out.println(end - start + "ms:none"); */
		StudentSerialization a=new StudentSerialization();
		a.readFile();
		a.serialization();
		a.show();
	}
}
