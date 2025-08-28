package ObjectOrientedDesign.Inheritence;

// GeometricProgression class extending Progression
public class GeometricProgression extends Progression {
    protected long base;

    /** Constructs progression 1, 2, 4, 8, 16, ... */
    public GeometricProgression() {
        this(2, 1);
    }

    /** Constructs progression 1, b, bˆ2, bˆ3, bˆ4, ... for base b. */
    public GeometricProgression(long b) {
        this(b, 1);
    }

    /** Constructs geometric progression with arbitrary base and start. */
    public GeometricProgression(long b, long start) {
        super(start);
        base = b;
    }

    /** Multiplies the current value by the geometric base. */
    @Override
    protected void advance() {
        current *= base; // multiply current by the base
    }

    // Example usage
    public static void main(String[] args) {
        GeometricProgression gp = new GeometricProgression(3, 2);
        gp.printProgression(10);
    }
}
