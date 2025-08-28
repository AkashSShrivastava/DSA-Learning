package ObjectOrientedDesign.Inheritence;

// ArithmeticProgression class extending Progression
public class ArithmeticProgression extends Progression {
    protected long increment;

    /** Constructs progression 0, 1, 2, ... */
    public ArithmeticProgression() {
        this(1, 0);
    }

    /** Constructs progression 0, stepsize, 2*stepsize, ... */
    public ArithmeticProgression(long stepsize) {
        this(stepsize, 0);
    }

    /** Constructs arithmetic progression with arbitrary start and increment. */
    public ArithmeticProgression(long stepsize, long start) {
        super(start);
        increment = stepsize;
    }

    /** Adds the arithmetic increment to the current value. */
    @Override
    protected void advance() {
        current += increment;
    }

    // Example usage
    public static void main(String[] args) {
        ArithmeticProgression ap = new ArithmeticProgression(5, 3);
        ap.printProgression(10);
    }
}
