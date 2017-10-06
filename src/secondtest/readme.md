## 第二次实验
### JAVA访问权限修饰符的掌握
编写一个具有public、private、protected、default访问权限的数据成员和成员函数的class。为它产生一个对象并进行观：当你尝试取用所有class成员时、会产生什么类型的编译消息。
 部分代码实现：
 <pre><code>
	public class first_question {
		public int number = 0;
		private int shenfenzhen = 0;
		int age = 0;
		protected int classes = 0;
		public int getNumber() {
			return number;
		}
		private int getShenfenzhen() {
			return shenfenzhen;
		}
		protected int getClasses() {
			return classes;
		}
		int getAge() {
			return age;
		}
	}
	</pre></code>
 - 实验结果	：
脑补一下吧，我不太懂怎么展示
### 单例模式——使用单例模式完成下面描述的类
Choc-O-Holic公司有一个巧克力锅炉，用来把巧克力和牛奶融合在一起生产巧克力棒。定义这个巧克力锅炉类为ChocolateBoiler
ChocolateBoiler有两个私有的成员变量，empty和boiled，用来判断锅炉是否为空，以及锅炉内混合物是否已煮沸。注意两个成员变量恰当的初始值。
private boolean empty;
private boolean boiled;
ChocolateBoiler有三个方法来控制锅炉生产巧克力棒。
public void fill() {…} 向锅炉填满巧克力和牛奶的混合物。首先要判断锅炉是否为空，只有空的锅炉才能填充巧克力和牛奶（填充过程打印一条语句即可）。填充之后empty为false
public void boil() {…} 将炉内煮沸。首先判断标志位，只有锅炉是满的，并且没有煮过，才能进行该操作（煮沸操作打印一条语句即可）。煮沸后boiled标志位设置为true。
public void drain() {…} 排出煮沸的巧克力和牛奶。首先要进行标志位判断，只有锅炉是满的，并且锅炉已经煮沸之后，才能排出混合物（排出混合物的动作打印一条语句即可），排出混合物之后设置empty为true。
isEmpty和isBoiled方法来获取empty和boiled标志位的值
部分代码实现：
 <pre><code>
 ChoclateBoiler类：
	public class ChoclateBoiler {

	private static ChoclateBoiler uniqueInstance;
    private static boolean empty=true;
    private static boolean boiled=false;
    private ChoclateBoiler() { }
    public static ChoclateBoiler getInstance() {
	if(uniqueInstance == null) {
	    uniqueInstance = new ChoclateBoiler();
	}
	return uniqueInstance;	
    }
    public static void fill() {
    	if(empty==true&&boiled==false) {
    		System.out.println("对锅炉进行填充");
    		empty=false;
    	}
    }
    public static void boil() {
    	if(empty==false&&boiled==false) {
    		System.out.println("煮沸锅炉里的材料");
    		boiled=true;
    	}
    }
    public static void drain() {
    	if(empty==false&&boiled==true) {
    		System.out.println("排出混合物");
    		boiled=false;
    		empty=true;
    	}
    }
    public static boolean isEmpty() {
    	return empty;
    }
    public static boolean isBoiled() {
    	return boiled;
    }
}
main类：
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ChoclateBoiler.getInstance();
		ChoclateBoiler.fill();
		ChoclateBoiler.boil();
		ChoclateBoiler.drain();
	}
	</pre></code>
 - 实验结果	：
对锅炉进行填充
煮沸锅炉里的材料
排出混合物
