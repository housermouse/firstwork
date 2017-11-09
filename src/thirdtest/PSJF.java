package thirdtest;

import java.util.ArrayList;
import java.util.LinkedList;

public class PSJF {
	private LinkedList<Task> queue = new LinkedList<Task>();
	private ArrayList<Task> array = new ArrayList<Task>();
	private ArrayList<Task> wait = new ArrayList<Task>();
	public void oneQueue() {
		Task[] work=new Task[100];
		readFile read=new readFile();		
		System.arraycopy(read.readFile(), 0, work, 0, read.readFile().length);
		for(int i=0;i<100;i++) {
			queue.add(work[i]);
		}
		System.out.println("TaskId  到达时间          开始时间       服务时间       完成时间      周转时间      带权周转时间");
		
	}
	
}
