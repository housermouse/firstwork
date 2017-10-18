package secondtest;

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