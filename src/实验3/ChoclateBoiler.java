package ʵ��3;

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
    		System.out.println("�Թ�¯�������");
    		empty=false;
    	}
    }
    public static void boil() {
    	if(empty==false&&boiled==false) {
    		System.out.println("��й�¯��Ĳ���");
    		boiled=true;
    	}
    }
    public static void drain() {
    	if(empty==false&&boiled==true) {
    		System.out.println("�ų������");
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
