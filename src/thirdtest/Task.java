package thirdtest;

public class Task implements  Comparable<Task> {
	private int taskID=0; //任务ID
	private int arrivalTime=0; //到达时间
	private int serviceTime=0; //服务时间
	private int startingTime=0; //开始时间
	private int finishingTime=0; //完成时间=开始时间+服务时间
	private int turnAroundTime=0; //周转时间=完成时间-达到时间
	private double weightTurnAround=0; //带权周转时间=周转时间/服务时间
	private int remainingTime=0;
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	@Override
	public String toString() {
		return  taskID + "          " + arrivalTime + "         " + serviceTime
				+ "           " + startingTime + "        " + finishingTime + "        "
				+ turnAroundTime + "           " + weightTurnAround;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	public int getStartingTime() {
		return startingTime;
	}
	public void setStartingTime(int startingTime) {
		this.startingTime = startingTime;
	}
	public int getFinishingTime() {
		return finishingTime;
	}
	public void setFinishingTime(int finishingTime) {
		this.finishingTime = finishingTime;
	}
	public int getTurnAroundTime() {
		return turnAroundTime;
	}
	public void setTurnAroundTime(int turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}
	public double getWeightTurnAround() {
		return weightTurnAround;
	}
	public void setWeightTurnAround(double weightTurnAround) {
		this.weightTurnAround = weightTurnAround;
	}
	public int compareTo(Task t) {
	    if(this.serviceTime > t.serviceTime) {
	    	  return 1;
	    }
	    else if (this.serviceTime < t.serviceTime) {
			 return -1;
		}
		else
			 return 0;
	 }
	public int getRemainingTime() {
		return remainingTime;
	}
	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}
	
}
