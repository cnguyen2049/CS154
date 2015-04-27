package meta;
import java.lang.reflect.*;
import java.util.Arrays;
public class MetaMachine {
	public String execute(String ... args) throws Exception {
		try{
	         Class c = Class.forName(args[0]);  // find & load a class
	        // System.out.print(c.getName());
	         Method meth = c.getMethod(args[1], String[].class);
	         String[] variables = Arrays.copyOfRange(args,2,args.length);
	         Object blob = c.newInstance();
	        meth.invoke(blob, (Object)variables);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return "None";
	}
}
