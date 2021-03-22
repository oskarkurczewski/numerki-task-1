package program;

public class Comp_poly_expo implements Utils {

    public double calc(double x) {
        Exponential expo = new Exponential();
        Polynomial poly = new Polynomial();
        // f(h(x))
        return poly.calc(expo.calc(x));
    }
}
