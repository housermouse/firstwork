package thirdtest;
public class main {
	public static void main(String[] args) {
		//createTask cre=new createTask();
		//cre.createFile();
		FCFS fcfs=new FCFS();
		//fcfs.oneQueue();
		//fcfs.twoQueue();
		//fcfs.show();
		SJF sjf=new SJF();
		//sjf.oneQueue();
		sjf.twoQueue();
		sjf.show();
	}
}
