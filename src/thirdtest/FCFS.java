package thirdtest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FCFS {
	private Queue<Task> queue = new LinkedList<Task>(); 
	private Task[] show=new Task[100];
	public void oneQueue() {
		Task[] work=new Task[100];
		readFile read=new readFile();		
		System.arraycopy(read.readFile(), 0, work, 0, read.readFile().length);
		for(int i=0;i<100;i++) {
			queue.add(work[i]);
		}
		System.out.println("TaskId    到达时间      服务时间      开始时间      完成时间      周转时间      带权周转时间");
		int nowTime=0;
		for(int i=0;i<100;i++) {
			Task temp=queue.poll();
			//System.out.println(temp.getServiceTime());
			int finishingTime=0;
			int turnAroundTime=0;
			temp.setStartingTime(nowTime);
			double weightTurnAround=0;
			finishingTime=nowTime+temp.getServiceTime();
			temp.setFinishingTime(finishingTime);
			turnAroundTime=finishingTime-temp.getArrivalTime();
			temp.setTurnAroundTime(turnAroundTime);
			weightTurnAround=turnAroundTime*1.0/temp.getServiceTime();	
			temp.setWeightTurnAround(weightTurnAround);
			/*System.out.println(temp.getTaskID()+"           "+temp.getArrivalTime()+"           "+
			temp.getStartingTime()+"           "+temp.getServiceTime()+"           "+
			finishingTime+"           "+turnAroundTime+"         "+weightTurnAround);*/
			nowTime=nowTime+temp.getServiceTime();		
			show[temp.getTaskID()-1]=temp;
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
		System.out.println("TaskId    到达时间      服务时间      开始时间      完成时间      周转时间      带权周转时间");
		int nowTime1=0;
		int nowTime2=1;
		for(int i=0;i<100;i++) {
			if(nowTime1<nowTime2) {
				Task temp=queue.poll();
				//System.out.println(temp.getServiceTime());
				int finishingTime=0;
				int turnAroundTime=0;
				temp.setStartingTime(nowTime1);
				double weightTurnAround=0;
				finishingTime=nowTime1+temp.getServiceTime();
				temp.setFinishingTime(finishingTime);
				turnAroundTime=finishingTime-temp.getArrivalTime();
				temp.setTurnAroundTime(turnAroundTime);
				weightTurnAround=turnAroundTime*1.0/temp.getServiceTime();	
				temp.setWeightTurnAround(weightTurnAround);
				/*System.out.println(temp.getTaskID()+"         "+1+"        "+temp.getArrivalTime()+"           "+
				temp.getStartingTime()+"           "+temp.getServiceTime()+"           "+
				finishingTime+"           "+turnAroundTime+"         "+weightTurnAround);*/
				nowTime1=nowTime1+temp.getServiceTime();
				show[temp.getTaskID()-1]=temp;
			}
			else {
				Task temp=queue.poll();
				//System.out.println(temp.getServiceTime());
				int finishingTime=0;
				int turnAroundTime=0;
				temp.setStartingTime(nowTime2);
				double weightTurnAround=0;
				finishingTime=nowTime2+temp.getServiceTime();
				temp.setFinishingTime(finishingTime);
				turnAroundTime=finishingTime-temp.getArrivalTime();
				temp.setTurnAroundTime(turnAroundTime);
				weightTurnAround=turnAroundTime*1.0/temp.getServiceTime();	
				temp.setWeightTurnAround(weightTurnAround);
				/*System.out.println(temp.getTaskID()+"         "+2+"        "+temp.getArrivalTime()+"           "+
				temp.getStartingTime()+"           "+temp.getServiceTime()+"           "+
				finishingTime+"           "+turnAroundTime+"         "+weightTurnAround);*/
				nowTime2=nowTime2+temp.getServiceTime();
				show[temp.getTaskID()-1]=temp;
			}
		}
		queue.clear();
	}
	public void show() {
		for(int i=0;i<100;i++) {
			System.out.println("   "+show[i].toString());
		}
	}
}
