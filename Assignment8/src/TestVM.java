public class TestVM {

   public static void main(String[] args) {
//	 Command c = new Command("load x, 10", 0);
//	 System.out.println(c.getLabel());
//	 System.out.println(c.getOpcode());
//	 System.out.println(c.getArg1());
//	 System.out.println(c.getArg2());
//	  	 
	   try {
         VirtualMachine vm = new VirtualMachine();
         vm.add("load x, 10");
         vm.add("load y, 5");
         vm.add("load z, 0");
       vm.add("loop x");
         vm.add("inc y");
         vm.add("end");
         vm.add("goto AAA");
        vm.add("AAA: inc z");
         vm.run();
    	  vm.printInfo();
        System.out.println(vm);
      } catch(Exception e) {
         System.out.println(e.getMessage() + " error");
      }
    
   }
}