import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class Command {
	private String label;
	private String opcode;
	private String arg1;
	private String arg2;
	private int target;
	private int pc;
	private int count;
	private static String pattern = "(([A-Z]+):\\s)?(((load)\\s?([a-z]+),\\s?([a-z]+|[0-9]+))|((inc)\\s?([a-z]+))|(loop)\\s([a-z]+|[0-9]+)|((goto)\\s?([A-Z]+))|(end))";

	private Pattern cmmdPattern;
	
	
	public Command(String command, int pc){
		setPc(pc);
		
		
		//System.out.println(command);
		cmmdPattern = Pattern.compile(pattern);
		Matcher m = cmmdPattern.matcher(command);

		if (m.find()) {

            if (m.group(1) != null) {
               
               String trim = m.group(1);
               trim = trim.substring(0,trim.length()-2);
               System.out.println("Trime " + trim);
                setLabel(trim);
            }
            if (m.group(5) != null) {
              
                setOpcode(m.group(5));
            }
            if (m.group(6) != null) {
               
                setArg1(m.group(6));
            }
            if (m.group(7) != null) {
              
                setArg2(m.group(7));
            }
            if (m.group(9) != null) {
               
                setOpcode(m.group(9));
            }
            if (m.group(10) != null) {
              
                setArg1(m.group(10));
            }
            if (m.group(11) != null) {
              
                setOpcode(m.group(11));
            }
            if (m.group(12) != null) {
             
                setArg1(m.group(12));
            }
            if (m.group(14) != null) {
 
                setOpcode(m.group(14));
            }
            if (m.group(15) != null) {
  
                setArg1(m.group(15));
            }
            if (m.group(16) != null) {
 
                setOpcode(m.group(16));
            }
			}
        else{
        	System.out.println("NULLL");
        }

        this.pc = pc;

	}
	public String getOpcode() {
		return opcode;
	}
	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getArg1() {
		return arg1;
	}
	public void setArg1(String arg1) {
		this.arg1 = arg1;
	}
	public String getArg2() {
		return arg2;
	}
	public void setArg2(String arg2) {
		this.arg2 = arg2;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Pattern getCmmdPattern() {
		return cmmdPattern;
	}
	public void setCmmdPattern(Pattern cmmdPattern) {
		this.cmmdPattern = cmmdPattern;
	}
	public String toString(){
		return "" + opcode + " " + target + " " + label ;
	}

}
