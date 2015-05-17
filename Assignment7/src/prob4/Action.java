package prob4;

public class Action {
    private int newState;
    private char bit;
    private int direction;

    public Action(int state, char bit, int direction) {
        this.newState = state;
        this.bit = bit;
        this.direction = direction;
    }

    public int getState() {
        return newState;
    }

    public char getBit() {
        return bit;
    }

    public int getDirection() {
        return direction;
    }

    public String toString() {
        return "state: " + newState + " bit: " + bit + " direction: " + direction;
    }
}