import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.*;
public class VM {
	
	private ArrayList<Command> program = new ArrayList<Command>();
	public Map<String,Integer> variables = new HashMap<String,Integer>();
	private int pc;
	private int executions = 0;
	
	public VM(){
		this.pc = 0;
		this.program = new ArrayList<Command>();
		this.variables = new HashMap<String,Integer>();
	}
	
	public void add(String cmmd){
		
		program.add(new Command(cmmd,pc++));
		
	}
	
	public void compile(String file){
        try {
            FileReader input = new FileReader(file);
            BufferedReader reader = new BufferedReader(input);
            String line;
            while ((line = reader.readLine()) != null) {
                program.add(new Command(line, pc++));
            }
            reader.close();
        } catch(Exception e) {
            System.out.println(e);
        }
	}
	
    public void execute(Command cmmd){
    	//System.out.println("Variables in program are = " + variables);
    	if(cmmd.getOpcode()==null){
    		System.out.println("Breaks here");
    	}
        if(cmmd.getOpcode().equals("load")){
        	if(variables.containsKey(cmmd.getArg2())){
        		Integer num = variables.get(cmmd.getArg2());
        		variables.put(cmmd.getArg1(), num);
        	}else{
        	variables.put(cmmd.getArg1(), Integer.parseInt(cmmd.getArg2()));
        	}
        }
        
        else if (cmmd.getOpcode().equals("inc")){
        	int variable = variables.get(cmmd.getArg1());
        	variables.put(cmmd.getArg1(),variable +1);
        }
        else if (cmmd.getOpcode().equals("goto")){
        	pc = cmmd.getTarget();
        }
        else if (cmmd.getOpcode().equals("loop")){
        	if(variables.containsKey(cmmd.getArg1())){
        		cmmd.setCount(variables.get(cmmd.getArg1()));
        	}else{
        	cmmd.setCount(Integer.parseInt(cmmd.getArg1()));
        	}
        	if(cmmd.getCount()==0){
        		pc = cmmd.getTarget()+1;
        	}
        }
        else if (cmmd.getOpcode().equals("end")){
        	Command loop = program.get(cmmd.getTarget());
        	loop.setCount(loop.getCount()-1);
        	if(loop.getCount()>0){
        		pc = loop.getPc() +1;
        	}
        }
        else {
        	System.out.println("Invalid instruction. Throwing error");
        }//error, unrecognized opcode
    }
    
    public void resolveLabels(){
    	Stack<Command> loopStack = new Stack<Command>();
    	Map<String,Integer> targets = new HashMap<String,Integer>();
    	//System.out.println("Targets === " + targets);
    	for(Command cmmd: program){
    		//System.out.println("Targets === " + targets);
    		//System.out.println("Executes opcode ==="  + cmmd.getOpcode());
    		if(cmmd.getLabel()!=null){
    			
    			targets.put(cmmd.getLabel(), cmmd.getPc());
    			System.out.println("Targets === " + targets);
    		}
    		if(cmmd.getOpcode().equals("loop")){
    			loopStack.push(cmmd);
    		}
    		if(cmmd.getOpcode().equals("end")){
    			Command loop = loopStack.pop();
    			loop.setTarget(cmmd.getPc());
    			cmmd.setTarget(loop.getPc());
    		}
    	}
    	for(Command cmmd: program){
    		if(cmmd.getOpcode().equals("goto")){
    			cmmd.setTarget(targets.get(cmmd.getArg1()));
    		}
    	}
    }
    public void insideProgram(){
    	int i = 0;
    	while(i<program.size()){
    		System.out.println(program.get(i).getOpcode());
    		i++;
    	}
    }
	public void run(){
		resolveLabels();
		this.pc = 0;
		while(pc < program.size()){
			
			execute(program.get(pc++));
			
		}
		
	}
	public void printInfo(){
		System.out.println("Executed Commands");
		System.out.println("pc: " + pc);
		System.out.println("Variables");
		for(Map.Entry<String,Integer> entry : variables.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
