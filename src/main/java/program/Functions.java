package program;

import static java.lang.Math.pow;
import static java.lang.Math.sin;

public class Functions {
    static String polynomial = "x**3+2*x**2-5*x+3";
    static String trigonometric = "sin(x/2)+1";
    static String exponential = "2**x-4"; //tutaj 2 trzeba zmienic na to e ae jeszcze nie wiem jak gnuplot nazywa to e
    static String comp_expo_poly = "";
    static String comp_poly_expo = "";
    static String comp_expo_tri = "";

    public static double polynomial (double x) {
        // f(x)
        // y = x^3 + 2x^2 - 5x +3
        // root at (-3.6, 0)
        return x*x*x + 2*x*x - 5*x + 3;
    }

    public static double trigonometric (double x) {
        // g(x)
        // y = sin(1/2 x) + 1
        // root at (-pi, 0)
        return sin(x/2) + 1;
    }

    public static double exponential (double x) {
        // h(x)
        // y = e^x - 4
        // root at (1.3862, 0)
        return pow(Math.E, x) - 4;
    }

    // todo: policzyć i dodać w komentarzach, jakie poniżej są miejsca zerowe, bo mi się nie chciało xD

    public static double comp_expo_poly (double x) {
        // f(h(x))
        return exponential(polynomial(x));
    }

    public static double comp_poly_expo (double x) {
        // h(f(x))
        return polynomial(exponential(x));
    }

    public static double comp_expo_tri (double x) {
        // h(g(x))
        return exponential(trigonometric(x));
    }

}
