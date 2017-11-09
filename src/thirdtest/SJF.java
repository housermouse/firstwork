package thirdtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SJF {
	private LinkedList<Task> queue = new LinkedList<Task>();
	private ArrayList<Task> array = new ArrayList<Task>();
	public void oneQueue() {
		Task[] work=new Task[100];
		readFile read=new readFile();		
		System.arraycopy(read.readFile(), 0, work, 0, read.readFile().length);
		for(int i=0;i<100;i++) {
			queue.add(work[i]);
		}
		System.out.println("TaskId  到达时间          开始时间       服务时间       完成时间      周转时间      带权周转时间");
		int nowTime=0;
		int count=0;
		Task temp=queue.poll();
		for(int i=0;i<100;i++) {			
			if(temp!=null) {
				if(temp.getArrivalTime()<nowTime) {
					if(nowTime>100) {
						for(int j=count;j<100;j++) {
							array.add(temp);
							temp=queue.poll();					
						}
						count=99;
						Collections.sort(array.subList(0,99-i));
					}
					else {
						for(int j=count;j<nowTime;j++) {
							array.add(temp);
							temp=queue.poll();							
						}
						count=nowTime;
						Collections.sort(array.subList(0,count-i));
					}
					
					
				}
				
			}
			if(count!=0) {
				Task m=new Task();
				m=array.get(0);
				array.remove(0);
				int finishingTime=0;
				int turnAroundTime=0;
				m.setStartingTime(nowTime);
				double weightTurnAround=0;
				finishingTime=nowTime+m.getServiceTime();
				m.setFinishingTime(finishingTime);
				turnAroundTime=finishingTime-m.getArrivalTime();
				m.setTurnAroundTime(turnAroundTime);
				weightTurnAround=turnAroundTime*1.0/m.getServiceTime();			
				System.out.println(m.getTaskID()+"           "+m.getArrivalTime()+"           "+
				m.getStartingTime()+"           "+m.getServiceTime()+"           "+
				finishingTime+"           "+turnAroundTime+"         "+weightTurnAround);
				nowTime=nowTime+m.getServiceTime();		
			}
			else {
				int finishingTime=0;
				int turnAroundTime=0;
				temp.setStartingTime(nowTime);
				double weightTurnAround=0;
				finishingTime=nowTime+temp.getServiceTime();
				temp.setFinishingTime(finishingTime);
				turnAroundTime=finishingTime-temp.getArrivalTime();
				temp.setTurnAroundTime(turnAroundTime);
				weightTurnAround=turnAroundTime*1.0/temp.getServiceTime();			
				System.out.println(temp.getTaskID()+"           "+temp.getArrivalTime()+"           "+
				temp.getStartingTime()+"           "+temp.getServiceTime()+"           "+
				finishingTime+"           "+turnAroundTime+"         "+weightTurnAround);
				nowTime=nowTime+temp.getServiceTime();		
			}
		}
		queue.clear();
	}
	public void twoQueue() {
		Task[] work=new Task[100];
		readFile read=new readFile();		
		System.arraycopy(read.readFile(), 0, work, 0, read.readFile().length);
		for(int i=0;i<100;i++) {
			queue.add(work[i]);
		}
		System.out.println("TaskId    队列数     到达时间          开始时间       服务时间       完成时间      周转时间      带权周转时间");
		int nowTime1=0;
		int nowTime2=1;
		Task temp1=queue.poll();
		work(temp1,nowTime1,1);
		nowTime1=nowTime1+temp1.getServiceTime();
		Task temp2=queue.poll();
		work(temp2,nowTime2,2);
		nowTime2=nowTime1+temp1.getServiceTime();
		for(int i=0;i<98;i++) {
			if(nowTime1>nowTime2) {
				if(nowTime2<100) {
					Collections.sort(queue.subList(0,nowTime2-i-2));
					temp2=queue.poll();
					work(temp2,nowTime2,2);
					nowTime2=nowTime2+temp2.getServiceTime();
				}else {
					Collections.sort(queue.subList(0,100-i-2));
					temp2=queue.poll();
					work(temp2,nowTime2,2);
					nowTime2=nowTime2+temp2.getServiceTime();
				}
			}
			else{
				if(nowTime1<100) {
					Collections.sort(queue.subList(0,nowTime1-i-2));
					temp1=queue.poll();
					work(temp1,nowTime1,1);
					nowTime1=nowTime1+temp1.getServiceTime();
				}else {
					Collections.sort(queue.subList(0,100-i-2));
					temp1=queue.poll();
					work(temp1,nowTime1,1);
					nowTime1=nowTime1+temp1.getServiceTime();
				}
			}
		}
		queue.clear();
	}
	public Task work(Task temp,int nowTime,int queuenumber) {
		int finishingTime=0;
		int turnAroundTime=0;
		temp.setStartingTime(nowTime);
		double weightTurnAround=0;
		finishingTime=nowTime+temp.getServiceTime();
		temp.setFinishingTime(finishingTime);
		turnAroundTime=finishingTime-temp.getArrivalTime();
		temp.setTurnAroundTime(turnAroundTime);
		weightTurnAround=turnAroundTime*1.0/temp.getServiceTime();			
		System.out.println(temp.getTaskID()+"           "+queuenumber+"           "+temp.getArrivalTime()
		+"           "+temp.getStartingTime()+"           "+temp.getServiceTime()+"           "+
		finishingTime+"           "+turnAroundTime+"         "+weightTurnAround);
		nowTime=nowTime+temp.getServiceTime();
		return  temp;
	}
}

