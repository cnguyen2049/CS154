
public class Lab3 {

	public static void addTwo(String n, String m){
		VirtualMachine vm = new VirtualMachine();
		String sum1 = "load x, " + n;
		String sum2 = "load y, " + m;
		vm.add(sum1);
		vm.add(sum2);
		vm.add("loop x");
        vm.add("inc y");
        vm.add("end");
        vm.run();
	}
	
	public static void main(String args []){
		addTwo("6","4");
	}
}
