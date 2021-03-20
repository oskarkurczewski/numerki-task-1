package program;

import static java.lang.Math.pow;
import static java.lang.Math.sin;

public class Functions {
    public static double polynomial (double x) {
        // y = x^3 + 2x^2 - 5x +3
        // root at (-3.6, 0)
        return x*x*x + 2*x*x - 5*x + 3;
    }

    public static double trigonometric (double x) {
        // y = sin(1/2 x) + 1
        // root at (-pi, 0)
        return sin(x/2) + 1;
    }

    public static double exponential (double x) {
        // y = e^x - 4
        // root at (1.3862, 0)
        return pow(Math.E, x) - 4;
    }

}
