
public class Lab8 {
	
	public static String doubleFunc(String x){
		VirtualMachine vm = new VirtualMachine();
		vm.add("load z, " + x);
		vm.add("loop " + x);
		vm.add("inc z");
		vm.add("end");
		vm.add("load w, z");
		vm.run();
		vm.printInfo();
		return Integer.toString(vm.variables.get("w"));
	}
	
	public static String exp(String m){
		VirtualMachine vm = new VirtualMachine();
	
		vm.add("load z, 1");
		vm.add("loop " + m);
		vm.add("loop z");
		vm.add("inc z");
		vm.add("end");
		//vm.add("load w, z");
		vm.add("end");
		vm.run();
		vm.printInfo();
		return "";
	}
	
	public static void hyperExp(String m){
		VirtualMachine vm = new VirtualMachine();
		
		vm.add("load z, 1");
		vm.add("loop " + m);
		vm.add("loop " + m);
		vm.add("loop z");
		vm.add("inc z");
		vm.add("end");
		//vm.add("load w, z");
		vm.add("end");
		vm.add("end");
		vm.run();
		vm.printInfo();
		
		
	}
	
	public static void hyperExp2(String m){
		VirtualMachine vm = new VirtualMachine();
		
		vm.add("load z, 1");
		vm.add("loop " + m);
		vm.add("loop " + m);
		vm.add("loop " + m);
		vm.add("loop z");
		vm.add("inc z");
		vm.add("end");
		//vm.add("load w, z");
		vm.add("end");
		vm.add("end");
		vm.add("end");
		vm.run();
		vm.printInfo();
	}
	public static void hyperExp3(String m){
		VirtualMachine vm = new VirtualMachine();
		vm.add("load z, 1");
		vm.add("loop " + m);
		vm.add("loop " + m);
		vm.add("loop " + m);
		vm.add("loop " + m);
		vm.add("loop z");
		vm.add("inc z");
		vm.add("end");
		//vm.add("load w, z");
		vm.add("end");
		vm.add("end");
		vm.add("end");
		vm.add("end");
		vm.run();
		vm.printInfo();
	}
	public static void main(String args []){
		System.out.println("Double function");
		doubleFunc("2");
		System.out.println("==========Exp function========");
		exp("2");
		System.out.println("==========Hyper function======");
		hyperExp("4");
		System.out.println("==========Hyper2 function=======");
		hyperExp2("2");
		System.out.println("==========Hyper3 function=======");
		hyperExp3("2");
	}
}
