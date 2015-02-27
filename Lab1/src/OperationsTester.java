import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class OperationsTester {
	
	public static void main(String args []){
		System.out.println("TESTING EXERCISE 1		");
		System.out.println();  
		Set<Integer> test = new HashSet<Integer>();
		for(int i = 0; i < 10; i++) test.add(i * 3);
	    Set<Integer>  test2 = new HashSet<Integer>();
	    for(int i = 0; i < 10; i++) test2.add(i * 6);
	    Set<Integer> test3 = new HashSet<Integer>();
	    test3.add(3);
	    test3.add(9);
	    test3.add(15);
	    
	    System.out.println("test = " + test);
	    System.out.println("test2 = " + test2);
	    System.out.println("test3 = " + test3);
	    Set<Integer> answer= Operations.intersect(test, test2);
	    System.out.println("intersect = " + answer);
	    Set<Integer> answer2= Operations.union(test, test2);
	    System.out.println("union = " + answer2);
	    Set<Integer> answer3= Operations.diff(test, test2);
	    System.out.println("diff = " + answer3);
	    System.out.println("Is test a subset test2? ");
	    System.out.println("Is test = " + test);
	    System.out.println("Is test2 = " + test2);
	    boolean answer4= Operations.subset(test2,test);
	    System.out.println("subset = " + answer4);
	    System.out.println("Is test3 a subset of test?");
	    System.out.println("Is test3 = " + test3);
	    System.out.println("Is test = " + test);
	    boolean answer5= Operations.subset(test, test3);
	    System.out.println("subset = " + answer5);
	    System.out.println();
	    
	    System.out.println("TESTING EXERCISE 2");
	    System.out.println();  
		Set<Integer> a = new HashSet<Integer>();
		      
		for(int i = 0; i < 20; i++) a.add(i * 2);
		   
		 Set<Integer>  b = Operations.filter(a,(Integer x)->x%4==0);
		 Set<Integer>  c = Operations.filter(a,(Integer x)->x%6==0);
		 Set<Integer> d = Operations.map(b, (x)->5 * x);
		 Set<Integer> e = Operations.map(b, (x)->10 * x);
		 System.out.println("Original Set1 = " + a);
		 System.out.println("Filter x % 4 == 0");
		 System.out.println("Set after Filter = " + b);
		 System.out.println("Filter x % 6 == 0");
		 System.out.println("Set after Filter = " + c);
		 System.out.println("Map ->5 * x");
		 System.out.println("Set after Map = " + d);
		 System.out.println("Map ->10 * x");
		 System.out.println("Set after Map = " + e);
		 System.out.println();    
		 System.out.println("TESTING EXERCISE 3");
		 System.out.println();
		 Set<Integer> testSet = new HashSet<Integer>();
		 testSet.add(1);
		 testSet.add(2);
		 testSet.add(3);
		 testSet.add(4);
		 Set<Integer> testSet2 = new HashSet<Integer>();
		 testSet2.add(1);
		 testSet2.add(2);
		 testSet2.add(3);
		 testSet2.add(4);
		 testSet2.add(5);
		 testSet2.add(6);
		 System.out.println("Powerset of " +testSet);
		 for (Set<Integer> s : Operations.power(testSet)) {
			 System.out.print(s);
			}
		  
		  System.out.println("\nPowerset of " +testSet2);
		  for (Set<Integer> s : Operations.power(testSet2)) {
			  System.out.print(s);
			 }	 
			
		  System.out.println();
		  System.out.println();
		  System.out.println("TESTING EXERCISE 4");
		  Map<Integer,String> map= Operations.Unicodemap(7);
		  Map<Integer,String> map2= Operations.Unicodemap(4);
		  Map<Integer,String> map3= Operations.Unicodemap(0);
		  System.out.println("The unicode map is = " + map + " "+ map2 + " " + map3);
		}


	
}
