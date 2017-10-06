## 第一次实验
### 判断闰年
编写Java程序，输出从公元1990年到2007年所有闰年的年号，每输出两个年号换一行。判断年号是
否为闰年的条件是：
（1）若年号能被4整除，而不能被100整除，则是闰年；
（2）若年号能被400整除也是闰年。
 部分代码实现：
 <pre><code>
	 public static void runnian(){
		int num = 0;
		for(int i=1990;i<=2007;i++){
			if((i%4==0&&i%100!=0)||(i%400==0)){
				num++;
				if(num%2==0)
				{
					System.out.println(i);
				}
				else{
					System.out.print(i+" ");
				}
			}
		}
	}
	</pre></code>
 - 实验结果	：
1992 1996
2000 2004
### 百分制成绩转化为等级成绩
实现方法ToGradeScore，将百分制成绩转化为等级成绩。要求对一组数据，实现批量转化。
等级与百分制对照
优：[90,100]
良：[89,80]
中：[79,70]
及格：[69,60]
不及格：[0,59]
部分代码实现：
 <pre><code>
	 public static void ToGradeScore(){
		double[] score={99.5,88.5,77.5,66.5,55.5,44.5};
		for(int i=0; i < score.length ; i++){
			if(score[i] >=90 && score[i] < 100)
				System.out.println("优");
			if(score[i] >= 80 && score[i] < 90)
				System.out.println("良");
			if(score[i] >= 70 && score[i] < 80)
				System.out.println("中");
			if(score[i] >= 60 && score[i] < 70)
				System.out.println("及格");
			if(score[i] < 60)
				System.out.println("不及格");
		}	
	}
	</pre></code>
 - 实验结果	：
 优
良
中
及格
不及格
不及格

### 打印图案
利用for循环编写一个程序，将如下图案分别打印输出。
部分代码实现：
 <pre><code>
	 public static void third(){
		int max=7;
		for(int i = 0 ; i < max ; i++){
			if(i < 4){
				int n = 2 * i + 1;
				for(int j = 0 ; j < 3-i ; j++){
					System.out.print(" ");
				}
				for(int k=0 ; k < n ; k++){
					System.out.print("*");
				}
				System.out.println();
			}
			if(i >= 4){
				int n = max - 2 * (i-3);
				for(int j = 0 ; j < i-3 ; j++){
					System.out.print(" ");
				}
				for(int k = 0 ; k < n ; k++){
					System.out.print("*");
				}
				System.out.println();
			}		
		}
	}
	</pre></code>
 - 实验结果	:因为三个*是分割线，无法体现
 

### 水仙花数
编写程序找出所有的水仙花数；水仙花数是三位数，它的各位数字的立方和等于这个三位数本身。
部分代码实现：
 <pre><code>
	 public static void Narcissistic_number(){
		for(int i = 1 ; i < 10 ; i++)
			for(int j = 0 ; j < 10 ; j++)
				for(int k = 0 ; k < 10 ; k++){
					if( ( i * i * i + j * j * j + k * k * k ) == ( i * 100 + j * 10 + k ) ){
						System.out.println( ( i * 100 + j * 10 + k ) );
					}
				}
	}
	</pre></code>
 - 实验结果	:
153
370
371
407

