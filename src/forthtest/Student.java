package forthtest;

import java.io.Serializable;

public class Student implements  Comparable<Student> ,Serializable{
	private static final long serialVersionUID = 1234L;
	private String StuNo;
	private String StuName;
	private String  Sex;
	public String getStuNo() {
		return StuNo;
	}
	public void setStuNo(String stuNo) {
		StuNo = stuNo;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	@Override
	public String toString() {
		return "Student [StuNo=" + StuNo + ", StuName=" + StuName + ", Sex=" + Sex + "]";
	}
	public int compareTo(Student t) {
	    if(this.StuNo.compareTo(t.StuNo)>0) {
	    	  return 1;
	    }
	    else if (this.StuNo.compareTo(t.StuNo)<0) {
			 return -1;
		}
		else
			 return 0;
	 }
}
