import java.util.Set;
import java.util.*;
import java.util.function.*;

/*
 * @author Chris Nguyen 007405892
 */
public class Operations {
	   public  static <T> Set<T> intersect(Set<T> a, Set<T> b) {
		   /*
		   a.removeAll(b);
		   Set<T> intersection = new HashSet<T>(a);
		   intersection.retainAll(b);
		   return intersection;
		   */
		   Set<T> intersection = new HashSet<T>();
		   for(T element :a){
			   if(b.contains(element)){
				   intersection.add(element);
			   }
		   }
		   return intersection;
	   }
	   public  static <T> Set<T> union(Set<T> a, Set<T> b) {
		   Set<T> union = new HashSet<T>();
		   union = a;
		   for(T element:b){
			   if(!a.contains(element)){
				   union.add(element);
			   }
		   }
		   return union;
	   }
	   public  static <T> Set<T> diff(Set<T> a, Set<T> b) {
		   Set<T> diff = new HashSet<T>();
		   diff = a;
		   for(T e:b){
			   if(a.contains(e)){
				   diff.remove(e);
			   }
		   }
		   return diff;
	   }
	   public  static <T> boolean subset(Set<T> a, Set<T> b) {
		   
		   for(T x : b){
			   if(!(a.contains(x))){
				   return false;
			   }
		   }
		   return true;
	   }
public static Map<Integer,String> Unicode;
	
	static void Unicode(){
		Unicode = new Hashtable();
		for(int i=0;i<=9;i++){
			 int offset = i + 30;
			 String myUni = "\\u" + "00" + offset;
			Unicode.put(i, myUni);
		}
	}
	
	public static <T> Set<T> filter(Set<T> a, Predicate<T>f){
		Set<T> out = new HashSet<T>();
		for(T e :a){
			if(f.test(e)){
				out.add(e);
			}
		}
		return out;
		
	}
	 public static UnaryOperator<Double> iter(UnaryOperator<Double> f, int n) {
	      return (x) -> {
	         if (n == 0) return x;
	         return f.apply(iter(f, n - 1).apply(x));
	      };
	   }
	   public static UnaryOperator<Double> iter2(UnaryOperator<Double> f, int n) {
		     
		      return (x) -> {
		         Double result = 0.0;
		         for(int i = 0; i < n; i++) {
		            result = f.apply(result);
		            System.out.println(result);
		         }
		         return result;
		      };
		   }
	public static <T> Set<T> map(Set<T> a, UnaryOperator<T>f){
		Set<T> out = new HashSet<T>();
		for(T e:a){
			out.add(f.apply(e));
		}
		return out;
	}
	
	public static <Integer,String>Map Unicodemap(int number){
		Map<Object,String> result= new HashMap<>();
		Unicode();
		if(number>= 0 && number <10){
			String unicode = (String)Unicode.get(number);
			result.put(number, unicode);
		}
		else{
			System.out.println("Number is out of range");
		}
		return result;
	}
	/*
	 * Pseudo-algorithm
	Is the set passed empty? Done
	If not, take an element out
	recursively call method on the remainder of the set
	return the set composed of the Union of 
	(1) the powerset of the set without the element (from the recursive call) 
	(2) this same set (i.e., (1)) but with each element therein unioned with the element initially taken out
	 */
	public static <T> Set<Set<T>> power(Set<T> a) {
		Set <Set<T>> set = new HashSet<Set<T>>();
		if(a.isEmpty()){
			set.add(new HashSet<T>());
			return set;
		}
		List<T> list = new ArrayList<T>(a);
		T firstElement = list.get(0);
		Set<T> restElements = new HashSet<T>(list.subList(1, list.size()));
		for(Set<T> recursionSet:power(restElements)){		
			Set<T> resultSet = new HashSet<T>();		
			resultSet.add(firstElement);		
			resultSet.addAll(recursionSet);			
			set.add(resultSet);
			set.add(recursionSet);			
		}	
		return set;
	}
}
