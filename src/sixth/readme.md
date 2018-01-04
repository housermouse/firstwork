---
title: JAVA网络编程
tags: JAVA,面向对象,基础
---

## 改造教材19.2和19.3的例子，创建简单的聊天程序
### 服务器也具有类似客户端的UI界面
### 服务器也能够向客户端发送信息
### 客户端和服务器端UI界面要区分各自发送和接收到的信息，比如可以使用颜色区分彼此的聊天记录


#### 部分代码
```java
public class ThreadChoclateBoiler {
	private static ThreadChoclateBoiler uniqueInstance;
    private static boolean empty=true;
    private static boolean boiled=false;
    private ThreadChoclateBoiler() { }
    public static synchronized ThreadChoclateBoiler getInstance() {
	if(uniqueInstance == null) {
	    uniqueInstance = new ThreadChoclateBoiler();
	}
	return uniqueInstance;	
    }
    public static synchronized void fill(String name) {
    	if(empty==true&&boiled==false) {
    		System.out.println(name+"对锅炉进行填充");
    		empty=false;
    	}
    }
    public static synchronized void boil(String name) {
    	if(empty==false&&boiled==false) {
    		System.out.println(name+"煮沸锅炉里的材料");
    		boiled=true;
    	}
    }
    public static synchronized void drain(String name) {
    	if(empty==false&&boiled==true) {
    		System.out.println(name+"排出混合物");
    		boiled=false;
    		empty=true;
    	}
    }
    public static synchronized boolean isEmpty() {
    	return empty;
    }
    public static synchronized boolean isBoiled() {
    	return boiled;
    }
}

```
## 结果截图
![enter description here][1]
![enter description here][2]


  [1]: ./1.png "1"
  [2]: ./2.png "2"