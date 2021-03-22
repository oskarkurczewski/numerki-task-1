package program;

import static java.lang.Math.pow;

public class Exponential implements Utils {

    public double calc(double x) {
        // h(x)
        // y = e^x - 4
        // root at (1.3862, 0)
        return pow(Math.E, x) - 4;
    }
}
