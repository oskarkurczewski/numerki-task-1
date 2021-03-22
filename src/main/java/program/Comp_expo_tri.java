package program;

public class Comp_expo_tri implements Utils {

    public double calc(double x) {
        Exponential expo = new Exponential();
        Trigonometric tri = new Trigonometric();

        // f(h(x))
        return expo.calc(tri.calc(x));
    }
}
