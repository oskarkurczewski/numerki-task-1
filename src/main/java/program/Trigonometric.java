package program;

import static java.lang.Math.sin;

public class Trigonometric implements Utils {

    public double calc (double x) {
        // g(x)
        // y = sin(1/2 x) + 1
        // root at (-pi, 0)
        return sin(x/2) + 1;
    }
}
