package program;

public class Algorithms {

    public double bisection(double left, double right, double epsilon, int iterations, Utils f) {
        int i = 0;
        double x = 0;

        while ((Math.abs(f.calc(x)) > epsilon) && (i < iterations) && (left != right)) {
            x = (left + right) / 2;
            if (f.calc(left) * f.calc(x) < 0) right = x;
            else left = x;
            i++;
        }
        System.out.println("\nBisekcja: Koniec szukania rozwiazania. Miejsce zerowe w x = " + x + " po " + i + " iteracjach.");
        return x;
    }

    public double euler(double left, double right, double epsilon, int iterations, Utils f) {
        int i = 0;
        double x = 0;

        while ((Math.abs(f.calc(x)) > epsilon) && (i < iterations) && (left != right)) {
                x = right - f.calc(right) * (right - left) / (f.calc(right) - f.calc(left));
                left = right;
                right = x;
                i++;
        }
        System.out.println("\nMetoda siecznych: Koniec szukania rozwiazania. Miejsce zerowe w x = " + x + " po " + i + " iteracjach.");
        return x;
    }
}