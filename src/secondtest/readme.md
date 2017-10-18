## 第二次实验
### JAVA访问权限修饰符的掌握
编写一个具有public、private、protected、default访问权限的数据成员和成员函数的class。为它产生一个对象并进行观：当你尝试取用所有class成员时、会产生什么类型的编译消息。
 - 部分代码实现：
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
 - 部分代码实现：
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
1. 对锅炉进行填充
2. 煮沸锅炉里的材料
3. 排出混合物

### 工厂模式练习
类PizzaStore披萨商店要接收披萨订单生产披萨，其
Public Pizza orderPizza(String type)根据披萨类型type完成披萨制作，并返回一个Pizza实例(实际上要返回一个其子类实例)。制作过程包括（pizza.prepare(); pizza.bake(); pizza.cut(); pizza.box()）
Pizza是个抽象类，其有三个子类实现：CheesePizza,PepperoniPizza和ClamPizza。Pizza中的抽象方法有
prepare();//准备材料
bake();//烘焙披萨
cut();//切割披萨
box();//披萨装包
SimplePizzaFactory是一个披萨对象生成“工厂”，根据不同的type生成不同的Pizza实例（其实是 CheesePizza,PepperoniPizza, ClamPizza 中的一种）。利用public Pizza createPizza(String type)方法生成具体的Pizza实例，如果type是”cheese”生成CheesePizza，是”pepperoni”生成PepperoniPizza，是”clam”生成ClamPizza。
PizzaStore的构造函数需要传入SimplePizzaFactory实例，并且在orderPizza方法中利用SimplePizzaFactory实例首先生成一个具体的Pizza子类实例，然后进行披萨生产，包括pizza.prepare; pizza.bake(); pizza.cut(); pizza.box()，最后返回该Pizza子类实例。
- 部分代码实现：
<pre><code>
Pizza类：
public abstract class Pizza{
	 abstract void prepare();
	 abstract void bake();
	 abstract void cut();
	 abstract void box();	 			 
}

PizzaStore类：
public class PizzaStore {
	public SimplePizzaFactory orderPizza(String type) {
		SimplePizzaFactory factory=new SimplePizzaFactory(type);
		factory.createPizza(type).prepare();
		factory.createPizza(type).bake();
		factory.createPizza(type).cut();
		factory.createPizza(type).box();
		return factory;
	};		
}

CheesePizza类：
public class CheesePizza extends Pizza{
	void prepare() {
		System.out.println("Prepare Chesspizza");
	};
	void bake() {
		System.out.println("Bake Chesspizza");
	};
	void cut() {
		System.out.println("Cut Chesspizza");
	};
	void box() {
		System.out.println("Prepare Chesspizza");
	};
}

ClamPizza类：
public class ClamPizza  extends Pizza{
	void prepare() {
		System.out.println("Prepare Clampizza");
	};
	void bake() {
		System.out.println("Bake Clampizza");
	};
	void cut() {
		System.out.println("Cut Clampizza");
	};
	void box() {
		System.out.println("Prepare Clampizza");
	};
}

PepperoniPizza类：
public class PepperoniPizza extends Pizza{
	void prepare() {
		System.out.println("Prepare Pepperonipizza");
	};
	void bake() {
		System.out.println("Bake Pepperonipizza");
	};
	void cut() {
		System.out.println("Cut Pepperonipizza");
	};
	void box() {
		System.out.println("Prepare Pepperonipizza");
	};
}

SimplePizzaFactory类：
import secondtest.CheesePizza;
import secondtest.ClamPizza;
import secondtest.PepperoniPizza;

public class SimplePizzaFactory{
	public String type;
	public SimplePizzaFactory(String type) {
		// TODO 自动生成的构造函数存根
		this.type = type;
		Pizza pizza=createPizza(type);				
	}
	public Pizza createPizza(String type) {
		if(type.equals("cheese")) {
			 Pizza cheese=new CheesePizza();
			 return cheese;
		 }
		 else if(type.equals("pepperoni")) {
			 Pizza pepperoni=new PepperoniPizza();
			 return pepperoni;
		 }
		 else{
			 Pizza clam=new ClamPizza();
			 return clam;
		 }
	}
}

main类：
public static void main(String[] args) {
	PizzaStore customer=new PizzaStore();
	String type = "cheese";
	customer.orderPizza(type);
}
</pre></code>

- 实验结果	：
1. Prepare Chesspizza
2. Bake Chesspizza
3. Cut Chesspizza
4. Prepare Chesspizza
