package thirdtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task implements  Comparable<Task> {
	private int taskID=0; //����ID
	private int arrivalTime=0; //����ʱ��
	private int serviceTime=0; //����ʱ��
	private int startingTime=0; //��ʼʱ��
	private int finishingTime=0; //���ʱ��=��ʼʱ��+����ʱ��
	private int turnAroundTime=0; //��תʱ��=���ʱ��-�ﵽʱ��
	private double weightTurnAround=0; //��Ȩ��תʱ��=��תʱ��/����ʱ��
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
