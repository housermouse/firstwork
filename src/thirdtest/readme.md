---
title: JAVA集合类综合小实验
tags: JAVA,面向对象,基础
---

## 模拟实现FCFS（先来先服务）算法
### FCFS算法按照任务到达的顺序进行服务，先来先服务
### 每个Task对象可以描述为至少包含下列属性：
taskID //任务ID
arrivalTime //到达时间
serviceTime //服务时间
startingTime //开始时间
finishingTime //完成时间=开始时间+服务时间
turnAroundTime //周转时间=完成时间-达到时间
weightTurnAround //带权周转时间=周转时间/服务时间
其他的属性根据程序需要设置
饰符，一般称之为“公共的”。被其修饰的类、属性以及方法不仅可以跨类访问，而且     允许跨包访问。 
### 任务(Task)的ID、开始时间和服务时间由文件读入，形如右图所示。这个任务列表文件首先由程序生成，每秒一个任务达到，服务时间由{6,2,1,3,9}这个集合中的数据随机获取。文件列表要包含至少100个任务。
 先要求实现如下要求的FCFS
1.当只有一个处理队列时的情况
2.当有两个处理队列时的情况

#### 部分代码
```java
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
				nowTime1=nowTime1+temp.getServiceTime();
				show[temp.getTaskID()-1]=temp;
			}
			else {
				Task temp=queue.poll();
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
```
#### 实验截图
单进程

![enter description here][1]
双进程

![enter description here][2]


## 模拟实现SJF（短作业优先）
SJF算法首先调度已到达的任务中，服务时间最短的任务，这里不要求实现任务的抢占。
按照FCFS算法的要求实现SJF算法，同样要求处理两种情况：
当只有一个处理队列时的情况
当有两个处理队列时的情况


#### 部分代码
```java
public class SJF {
	private LinkedList<Task> queue = new LinkedList<Task>();
	private ArrayList<Task> array = new ArrayList<Task>();
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
		int count=0;
		Task temp=queue.poll();
		for(int i=0;i<100;i++) {			
			if(temp!=null) {
				if(temp.getArrivalTime()<nowTime) {
					if(nowTime>100) {
						for(int j=count;j<100;j++) {
							temp=queue.poll();
							array.add(temp);
						}
						count=100;
						Collections.sort(array.subList(0,100-i));
					}
					else {
						for(int j=count;j<nowTime;j++) {	
							temp=queue.poll();
							array.add(temp);
						}
						count=nowTime;
						if(count!=100)
							Collections.sort(array.subList(0,count-i+1));
						else
							Collections.sort(array.subList(0,100-i));
						
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
				m.setWeightTurnAround(weightTurnAround);
				show[m.getTaskID()-1]=m;
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
				temp.setWeightTurnAround(weightTurnAround);
				show[temp.getTaskID()-1]=temp;
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
		System.out.println("TaskId    到达时间      服务时间      开始时间      完成时间      周转时间      带权周转时间");
		int nowTime1=0;
		int nowTime2=1;
		Task temp1=queue.poll();
		work(temp1,nowTime1,1);
		nowTime1=nowTime1+temp1.getServiceTime();
		Task temp2=queue.poll();
		work(temp2,nowTime2,2);
		nowTime2=nowTime2+temp2.getServiceTime();
		for(int i=0;i<98;i++) {
			if(nowTime1>nowTime2) {
				if(nowTime2<100) {
					Collections.sort(queue.subList(0,nowTime2-i-1));
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
					Collections.sort(queue.subList(0,nowTime1-i-1));
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
		temp.setWeightTurnAround(weightTurnAround);
		nowTime=nowTime+temp.getServiceTime();
		show[temp.getTaskID()-1]=temp;
		return  temp;
	}
	public void show() {
		for(int i=0;i<100;i++) {
			System.out.println("   "+show[i].toString());
		}
	}
}

```
#### 实验截图
单进程

![enter description here][3]

双进程

![enter description here][4]




  [1]: ./1.png "1"
  [2]: ./2.png "2"
  [3]: ./3.png "3"
  [4]: ./4.png "4"
