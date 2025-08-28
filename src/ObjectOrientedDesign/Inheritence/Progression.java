package ObjectOrientedDesign.Inheritence;

/** Generates a simple progression. By default: 0, 1, 2, ... */
public class Progression {
    // instance variable
    protected long current;

    /** Constructs a progression starting at zero. */
    public Progression() {
        this(0);
    }

    /** Constructs a progression with given start value. */
    public Progression(long start) {
        current = start;
    }

    /** Returns the next value of the progression. */
    public long nextValue() {
        long answer = current;
        advance(); // advance current to the next value
        return answer;
    }

    /** Advances the current value to the next value of the progression. */
    protected void advance() {
        current++;
    }

    /** Prints the next n values of the progression, separated by spaces. */
    public void printProgression(int n) {
        System.out.print(nextValue()); // print first value without leading space
        for (int j = 1; j < n; j++) {
            System.out.print(" " + nextValue()); // print leading space before others
        }
        System.out.println(); // end the line
    }
}