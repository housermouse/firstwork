package forthtest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Directory implements  Comparable<Directory> {
	private String fileName;
	private String dataTime;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDatatime() {
		return dataTime;
	}
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	public int compareTo(Directory t) {
	    if(this.fileName.compareTo(t.fileName)>0) {
	    	  return 1;
	    }
	    else if (this.fileName.compareTo(t.fileName)<0) {
			 return -1;
		}
		else
			 return 0;
	 }
	
}
