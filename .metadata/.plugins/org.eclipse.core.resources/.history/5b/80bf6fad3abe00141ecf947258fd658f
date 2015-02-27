

public class Tester {

	public static void Test() {
		
		RegEx zero = new Literal("0");
	    RegEx one = new Literal("1");
	    RegEx r1 = new Iteration(zero); // 0+
	    RegEx r2 = new Iteration(one);  // 1+
	    RegEx r3 = new Concat(r1, r2);  // 0+1+
        RegEx r4 = new Choice(r1, r2);  // 0+|1+
        RegEx r5 = new Option(r2);      // (1+)? = 1*
		//System.out.println(zero.matches("0"));
		//System.out.println(one.matches("1"));
		//System.out.println(r1.matches("000"));
		//System.out.println(r2.matches("1000"));
		
//        System.out.println(r3.matches("000111"));
//       	System.out.println(r3.matches("0001"));
//       	System.out.println(r3.matches("0011111111111"));
//       	System.out.println(r3.matches("11111111111"));
//        System.out.println(r3.matches("000000000"));
//        System.out.println(r3.matches("11000111"));
        System.out.println(r5.matches("1"));
        System.out.println(r5.matches("1111111"));
        System.out.println(r5.matches(""));
        System.out.println(r5.matches("00000"));
//        System.out.println(r4.matches("000"));
//        System.out.println(r4.matches("1111111111"));
//        System.out.println(r4.matches("0001"));
//        System.out.println(r4.matches("00011111"));
        
        
        
		
	}

public static void main(String [] args){
	Test();
	
	}
}