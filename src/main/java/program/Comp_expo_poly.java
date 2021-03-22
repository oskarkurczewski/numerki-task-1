package program;

public class Comp_expo_poly implements Utils {

    public double calc(double x) {
        Exponential expo = new Exponential();
        Polynomial poly = new Polynomial();
        // f(h(x))
        return expo.calc(poly.calc(x));
    }
}
