package prob3;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class prob3Tester {
	public static boolean isSmall(Integer n) { return n < 10; }
	public static boolean divBy5(Integer n) { return n % 5 == 0; }
	public static void main(String args[]) {
		Function<Integer, Integer> func1 = x -> x * 2;
		Function<Integer, Integer> func2 = x -> x * 5;
		
		Predicate<Integer> mem4 = RecClosures.union(RecClosures::isSmall, RecClosures::divBy5);
        System.out.println("MEMBERSHIP FUNCTIONS:");
        
        Predicate<Integer> mem = RecClosures.union(RecClosures::isSmall, RecClosures::divBy5);
        for(int i = 0; i < 21; i++) {
        	System.out.println("union(" + i + ") = " + mem.test(i));
        }
            mem = RecClosures.intersect(RecClosures::isSmall, RecClosures::divBy5);
            for(int i = 0; i < 21; i++) {
            	System.out.println("intersect(" + i + ") = " + mem.test(i));
	}
            
            mem = RecClosures.minus(RecClosures::isSmall, RecClosures::divBy5);
            	for(int i = 0; i < 21; i++) {
            		System.out.println("relativeComplement(" + i + ") = " + mem.test(i));
            	}
            
            BiPredicate<Integer, Integer> mem2 = RecClosures.carticianProduct(RecClosures::isSmall, RecClosures::divBy5);
            	for(int i = 0; i < 21; i++) {
            		for(int j = 0; j < 21; j++){
            			System.out.println("cartesianProduct(" + i + "," + j + ") = " + mem2.test(i,j));
            		}
            	}
            System.out.println("END MEMBERSHIP FUNCTIONS.");
            System.out.println("Enumerated Functions");
            Function<Integer,Integer> mem3 = RecClosures.union2(func1, func2);
     		for(int j = 0; j < 21; j++){
    			System.out.println("Enum_Union(" +j + ") = " + mem3.apply(j));
    		}
            Function<Integer,Integer> mem6 = RecClosures.intersect2(func1, func2);
     		for(int j = 0; j < 21; j++){
    			System.out.println("Enum_Intersect(" +j + ") = " + mem6.apply(j));
		}
            Function<Integer,RecEnum> mem7 = RecClosures.cartesian(func1, func2);
     		for(int j = 0; j < 21; j++){
    			System.out.println("Enum_Cartesian(" +j + ") = " + mem7.apply(j).getValue());
		}
	}

}
