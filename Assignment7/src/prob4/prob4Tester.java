package prob4;

public class prob4Tester {
	public static void test4() {
    	System.out.println("1^n01^n halting");
        Tape tape = new Tape("A10101R");
        TuringMachine tm = new TuringMachine(tape);
        tm.addFinalState(4);
        
   
        Trigger trigger = new Trigger(0, 'A');
        Action action = new Action(1, 'A', 1);
        tm.addStep(trigger, action);
        
        trigger = new Trigger(1, 'A');
        action = new Action(0, '1', 1);
        tm.addStep(trigger, action);
        
        trigger = new Trigger(0, '1');
        action = new Action(1, '1', 1);
        tm.addStep(trigger, action);

        trigger = new Trigger(1, '1');
        action = new Action(2, '1', 1);
        tm.addStep(trigger, action);

        trigger = new Trigger(2, '0');
        action = new Action(3, '0', 1);
        tm.addStep(trigger, action);
       
        trigger = new Trigger(3, '1');
        action = new Action(4, '1', 1);
        tm.addStep(trigger, action);
        
        trigger = new Trigger(4, '0');
        action = new Action(1, '1', -1);
        tm.addStep(trigger, action);
        tm.run();
    }
	public static void test3() {
    	System.out.println("");
    	
        Tape tape = new Tape("A111R");
        TuringMachine tm = new TuringMachine(tape);
        tm.addFinalState(6);

        
        Trigger trigger = new Trigger(0, 'A');
        Action action = new Action(0, 'A', 1);
        tm.addStep(trigger, action);

        trigger = new Trigger(0, '1');
        action = new Action(1, '0', 1);
        tm.addStep(trigger, action);

        trigger = new Trigger(0, '0');
        action = new Action(0, '0', 1);
        tm.addStep(trigger, action);

        trigger = new Trigger(0, 'R');
        action = new Action(6, 'R', 0);
        tm.addStep(trigger, action);
        trigger = new Trigger(1, '1');
        action = new Action(1, '1', 1);
        tm.addStep(trigger, action);
        trigger = new Trigger(1, '0');
        action = new Action(1, '0', 1);
        tm.addStep(trigger, action);
        trigger = new Trigger(1, 'R');
        action = new Action(2, 'R', 1);
        tm.addStep(trigger, action);
        trigger = new Trigger(2, '0');
        action = new Action(3, '1', 1);
        tm.addStep(trigger, action);
        trigger = new Trigger(2, '1');
        action = new Action(2, '1', 1);
        tm.addStep(trigger, action);
        trigger = new Trigger(3, '0');
        action = new Action(4, '1', 1);
        tm.addStep(trigger, action);
        trigger = new Trigger(3, '1');
        action = new Action(3, '1', 1);
        tm.addStep(trigger, action);
        trigger = new Trigger(4, '0');
        action = new Action(5, '1', 0);
        tm.addStep(trigger, action);
        trigger = new Trigger(5, '1');
        action = new Action(5, '1', -1);
        tm.addStep(trigger, action);
        trigger = new Trigger(5, 'R');
        action = new Action(5, 'R', -1);
        tm.addStep(trigger, action);
        trigger = new Trigger(5, '0');
        action = new Action(5, '0', -1);
        tm.addStep(trigger, action);
        trigger = new Trigger(5, 'A');
        action = new Action(0, 'A', 0);
        tm.addStep(trigger, action);
        tm.run();
    }
    public static void test2() {
    	System.out.println("n+n");
        Tape tape = new Tape("A11R");
        TuringMachine tm = new TuringMachine(tape);
        tm.addFinalState(5);
        
   
        Trigger trigger = new Trigger(0, 'A');
        Action action = new Action(1, 'A', 1);
        tm.addStep(trigger, action);

        trigger = new Trigger(1, '1');
        action = new Action(1, '0', 1);
        tm.addStep(trigger, action);
        
        trigger = new Trigger(1, '1');
        action = new Action(1, '0', 1);
        tm.addStep(trigger, action);
        
        trigger = new Trigger(1, 'R');
        action = new Action(2, 'R', 1);
        tm.addStep(trigger, action);
        
        trigger = new Trigger(2, '0');
        action = new Action(3, '1', 1);
        tm.addStep(trigger, action);
        
        trigger = new Trigger(3, '0');
        action = new Action(4, '1', 1);
        tm.addStep(trigger, action);
        
        trigger = new Trigger(4, '0');
        action = new Action(5, '1', 1);
        tm.addStep(trigger, action);
        
        trigger = new Trigger(5, '0');
        action = new Action(5, '1', 0);
        tm.addStep(trigger, action);
        
        tm.run();
    }

    public static void test1() {
        Tape tape = new Tape("1111101111110");
        TuringMachine tm = new TuringMachine(tape);
        tm.addFinalState(3);
        tm.addFinalState(4);

        Trigger t = new Trigger(0, '1');
        Action a = new Action(0, '1', 1);
        tm.addStep(t, a);

        t = new Trigger(0, '0');
        a = new Action(1, '0', 1);
        tm.addStep(t, a);

        t = new Trigger(1, '0');
        a = new Action(3, '0', 0);
        tm.addStep(t, a);

        t = new Trigger(1, '1');
        a = new Action(2, '0', -1);
        tm.addStep(t, a);

        t = new Trigger(2, '0');
        a = new Action(0, '1', 1);
        tm.addStep(t, a);

        t = new Trigger(2, '1');
        a = new Action(4, '1', 1);
        tm.addStep(t, a);
        tm.run();
    }
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    	test4();
    }
}
