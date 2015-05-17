package prob4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TuringMachine {
    private Tape tape;
    private Map<Trigger, Action> program;
    private Set<Integer> finalStates; // run halts when state is a member
    private int state; // the current state

    public TuringMachine(Tape input) {
        tape = input;
        program = new HashMap<Trigger, Action>();
        finalStates = new HashSet<Integer>();
        state = 0;
    }

    public void addStep(Trigger t, Action a) {
        program.put(t, a);
    }

    public void addFinalState(int state) {
        finalStates.add(state);
    }

    public void run() {
        while (!finalStates.contains(state)) {
            System.out.println("state = " + state + " index = " + tape.getHead());
            Action next = getNextAction(state,tape.read());
            if(next == null){
            	System.out.println("next = null. Quit");
            	return;
            }
            state = next.getState();
            tape.write(next.getBit());
            tape.moveHead(next.getDirection());
        }
        System.out.println("Program halted. Result: " + tape.result());
    }

    private Action getNextAction(int currentState, int currentBit) {
        for (Trigger t : program.keySet()) {
            if ((t.getState() == state) && (t.getCurrentBit() == currentBit)) {
            	 if (currentBit == 'B' || currentBit == 'A' || currentBit == 'R') {
                     System.out.print("(" + currentState + ", " + currentBit + ") " + "=> ");
                 }
                return program.get(t);
            }
        }
        return null;
    }
}