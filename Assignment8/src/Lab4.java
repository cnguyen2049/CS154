
public class Lab4 {
	
	public static String multTwo(String n, String m){
		VirtualMachine vm = new VirtualMachine();
		String sum1 = "load n, " + n;
		String sum2 = "load m, " + m;
		vm.add(sum1);
		vm.add(sum2);
		vm.add("load z, 0");
		vm.add("loop n");
		vm.add("loop m");
        vm.add("inc z");
        vm.add("end");
        vm.add("end");
        vm.run();
        vm.printInfo();
        return Integer.toString(vm.variables.get("z"));
	}
	
	public static void minusOne(String m, String n){
		VirtualMachine vm = new VirtualMachine();
		vm.add("load w, 0");
		String cmd1 = "load m, " + m;
		String cmd2 = "load n, " + n;
		vm.add(cmd1);
		vm.add(cmd2);
		
		vm.add("loop m");
		vm.add("load v, w");
		vm.add("inc w");
        vm.add("end");
        vm.add("load m, v");
        vm.run();
        vm.printInfo();
       
	}
	
	public static String minusTwo(String x, String y){
		VirtualMachine vm = new VirtualMachine();

		vm.add("load v, " + x);
		vm.add("loop " + y);
		vm.add("load w, 0");
		vm.add("loop v");
		vm.add("load s, w");
		vm.add("inc w");
		vm.add("end");
		vm.add("load v, s");
        vm.add("load result, v");
        vm.add("end");
        vm.run();
        vm.printInfo();
        return Integer.toString(vm.variables.get("result"));
	}
	
	public static String maxTwo(String m, String n){
		VirtualMachine vm = new VirtualMachine();
		vm.add("load w, 0");
		String sum1 = "load result, " + m;
		String cmd1 = "load nsubm, " + minusTwo(n,m);
		vm.add(sum1);
		vm.add(cmd1);
		vm.add("loop nsubm");
		vm.add("load result, " + n);
        vm.add("end");
        vm.run();
        vm.printInfo();
        return Integer.toString(vm.variables.get("result"));
	}
	public static void main(String args []){
		System.out.println("==========Lab4 =================");
		System.out.println("==========Multiply two numbers =================");
		System.out.println("Answer of multiply 6 * 4 is ===" + multTwo("6","4"));		
		System.out.println("==========Max of Two numbers =================");
		System.out.println("Answer of Max is ===" + maxTwo("6","4"));
		System.out.println("==========Subtract two numbers =================");
		System.out.println("Answer to Minus 6 - 4 is ===" + minusTwo("6","4"));
		
	}
}

