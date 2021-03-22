package program;

public class Polynomial implements Utils {

    public double calc(double x) {
        // f(x)
        // y = x^3 + 2x^2 - 5x +3
        // root at (-3.6, 0)
        return x*x*x + 2*x*x - 5*x + 3;
    }
}
