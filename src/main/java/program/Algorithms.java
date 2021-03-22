package program;

public class Algorithms {

    Polynomial poly = new Polynomial();
    Trigonometric tri = new Trigonometric();
    Exponential expo = new Exponential();
    Comp_expo_poly comp_expo_poly = new Comp_expo_poly();
    Comp_poly_expo comp_poly_expo = new Comp_poly_expo();
    Comp_expo_tri comp_expo_tri = new Comp_expo_tri();

    public double euler(double left, double right, double epsilon, int iterations, Utils f) {
        int i = 0;
        double x = 0;

        while ((f.calc(x) > epsilon) && (i < iterations) && (left != right)) {
                x = right - f.calc(right) * (right - left) / (f.calc(right) - f.calc(left));
                left = right;
                right = x;
                i++;
        }
        System.out.println("\nMetoda siecznych: Koniec szukania rozwiazania. Miejsce zerowe w x = " + x + " po " + i + " iteracjach.");
        return x;
    }

    public double bisection(double left, double right, double epsilon, int iterations, Utils f) {
        int i = 0;
        double x = 0;

        while ((f.calc(x) > epsilon) && (i < iterations) && (left != right)) {
            x = (left + right) / 2;
            if (f.calc(left) * f.calc(x) < 0) right = x;
            else left = x;
            i++;
        }
        System.out.println("\nBisekcja: Koniec szukania rozwiazania. Miejsce zerowe w x = " + x + " po " + i + " iteracjach.");
        return x;
    }
}