package forthtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Files implements  Comparable<Files> {
	private String fileName;
	private String dataTime;
	private long length;
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
	public long getLength() {
		return length;
	}
	public void setLength(long l) {
		this.length = l;
	}
	public int compareTo(Files t) {
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
