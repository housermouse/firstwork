package firsttest;

public class Firstwork {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		runnian();
		ToGradeScore();
		print();
		Narcissistic_number();
	}
	
	public static void runnian(){
		int num = 0;
		for(int i=1900;i<=2007;i++)
		{
			// ���Ա�4����������100����    ����     ���Ա�400������������
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
				System.out.println("��");
			if(score[i]>=80&&score[i]<90)
				System.out.println("��");
			if(score[i]>=70&&score[i]<80)
				System.out.println("��");
			if(score[i]>=60&&score[i]<70)
				System.out.println("����");
			if(score[i]<60)
				System.out.println("������");
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
