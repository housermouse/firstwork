package firsttest;

public class Firstwork {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		runnian();
		ToGradeScore();
		print();
		Narcissistic_number();
	}
	
	public static void runnian(){
		int num = 0;
		for(int i=1900;i<=2007;i++)
		{
			// 可以被4整除，不被100整除    或者     可以被400整除的是闰年
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

	public static void ToGradeScore(){
		double[] score={99.5,88.5,77.5,66.5,55.5,44.5};
		for(int i=0;i<score.length;i++){
			if(score[i]>=90&&score[i]<100)
				System.out.println("优");
			if(score[i]>=80&&score[i]<90)
				System.out.println("良");
			if(score[i]>=70&&score[i]<80)
				System.out.println("中");
			if(score[i]>=60&&score[i]<70)
				System.out.println("及格");
			if(score[i]<60)
				System.out.println("不及格");
		}
		
	}

	public static void print(){
		int max=7;
		for(int i=0;i<max;i++){
			if(i<4){
				int n=2*i+1;
				for(int j=0;j<3-i;j++){
					System.out.print(" ");
				}
				for(int k=0;k<n;k++){
					System.out.print("*");
				}
				System.out.println();
			}
			if(i>=4){
				int n=max-2*(i-3);
				for(int j=0;j<i-3;j++){
					System.out.print(" ");
				}
				for(int k=0;k<n;k++){
					System.out.print("*");
				}
				System.out.println();
			}
			
		}
	}


	public static void Narcissistic_number(){
		for(int i=1;i<10;i++)
			for(int j=0;j<10;j++)
				for(int k=0;k<10;k++){
					if((i*i*i+j*j*j+k*k*k)==(i*100+j*10+k)){
						System.out.println((i*100+j*10+k));
					}
				}
	}
}
