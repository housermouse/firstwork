package secondtest;

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

