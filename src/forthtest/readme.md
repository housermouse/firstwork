---
title: JAVA的IO操作
tags: JAVA,面向对象,基础
---

## 实验一 基本IO操作
### FCFS算法按照任务到达的顺序进行服务，先来先服务
### 每个Task对象可以描述为至少包含下列属性：
从键盘接收字节流
写入到当前目录下的src.txt文件中
将src.txt文件内容复制到当前目录下dest.txt文件中
将dest.txt文件内容显示到屏幕上

#### 部分代码
```java
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
```
## 结果截图
![enter description here][1]


## 实验二 获取系统的文件树
获取某个目录下的目录信息，目录从控制台输入。
目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序。


#### 部分代码
```java
private LinkedList<Directory> Directory = new LinkedList<Directory>();
	private LinkedList<Files> files = new LinkedList<Files>();
	public void getInformation() {
		System.out.println("Enter a line:(like:F:\\baiduyun)");
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		File file=new File(input);
		File[] tempList = file.listFiles();	
		Format simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("该目录下对象个数："+tempList.length);
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
			System.out.println("文件夹："+temp.getFileName()+"  "+temp.getDatatime());
			str=str+"文件夹："+temp.getFileName()+"  "+temp.getDatatime()+"\n";
		}
		for(int i=0;i<count2;i++) {
			Files temp=files.poll();
			System.out.println("文件："+temp.getFileName()+"  "+temp.getDatatime()+"  "+temp.getLength());
			str=str+"文件："+temp.getFileName()+"  "+temp.getDatatime()+"  "+temp.getLength()+"\n";
		}
		File file;//创建文件夹
		FileOutputStream stream = null;//new文件流
		try {
			file = new File("F:\\JAVA\\workspace\\firsttest\\src\\forthtest\\File.txt");
			stream = new FileOutputStream (file);//将文件夹放在文件流中
			if (!file.exists()) { 
					file.createNewFile();
			}
			byte[] contentInBytes = str.getBytes();//转化成字节形
			stream.write(contentInBytes);//写入
			stream.flush(); //写完之后刷新
			stream.close();//关闭流
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
	}
```
## 结果截图
![enter description here][2]

## 实验三 带缓冲区的IO
用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。


#### 部分代码
```java
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

	public static void main(String[] args) throws IOException {
			long start = System.currentTimeMillis();  
			CopyFileWithBuffer cfwb =new CopyFileWithBuffer();
			cfwb.copyFileWithBuffer(); 
			long end = System.currentTimeMillis();   
			System.out.println(end - start + "ms");  
			start = System.currentTimeMillis();  
			CopyFile cf =new CopyFile();
			cf.copyFile(); 
			end = System.currentTimeMillis();   
			System.out.println(end - start + "ms"); 
	}
```
## 结果截图
![enter description here][3]

## 实验四 对象序列化
类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，使用序列化技术定义Student。学生信息从文件list.txt读入，并按照学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。
使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。
使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中

#### 部分代码
```java
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
```
## 结果截图
![enter description here][4]


  [1]: ./1.png "1"
  [2]: ./2.png "2"
  [3]: ./3.png "3"
  [4]: ./4.png "4"