package program;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.plot.Plot;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;


public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Greeter greeter = new Greeter();
        Algorithms algorithms = new Algorithms();
        Utils fun;

        double epsilon = 0;
        int iterations = 100;
        int f = 1;
        int choice;
        double left = 0;
        double right = 0;
        int con = 1;


        while (con == 1) {

            System.out.println("\n\n" + greeter.authorInfo() + "\n\n");
            System.out.println("Wybierz funkcję:\n");
            System.out.println("1 - f(x) = x^3 + 2x^2 - 5x +3\n");
            System.out.println("2 - g(x) = sin(1/2 x) + 1\n");
            System.out.println("3 - h(x) = e^x - 4\n");
            System.out.println("4 - h(f(x))\n");
            System.out.println("5 - f(h(x))\n");
            System.out.println("6 - h(g(x))\n");
            try {
                f = scanner.nextInt();
                if (f > 6 || f < 1) {
                    System.out.println("Przecież tu nie było funkcji " + f);
                    return;
                } else {
                    fun = switch (f) {
                        case 1 -> new Polynomial();
                        case 2 -> new Trigonometric();
                        case 3 -> new Exponential();
                        case 4 -> new Comp_poly_expo();
                        case 5 -> new Comp_expo_poly();
                        case 6 -> new Comp_expo_tri();
                        default -> throw new Exception("Coś poszło nie tak!");
                    };
                }
            } catch (InputMismatchException e) {
                System.out.println("To chyba nie integer?\n");
                return;
            }

            System.out.println("Podaj dolny przedział (z przecinkiem, nie z kropką):\n");
            try {
                left = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Prawdopodobnie odano liczbę zmiennoprzecinkową z kropką. Panowie, tak się nie robi, wychodzimy.\n");
                return;
            }

            System.out.println("Podaj górny przedział (z przecinkiem, nie z kropką):\n");
            try {
                right = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Prawdopodobnie odano liczbę zmiennoprzecinkową z kropką. Panowie, tak się nie robi, wychodzimy.\n");
                return;
            }

            if (right <= left) {
                while (right <= left) {
                    System.out.println("Prawa strona przedziału powinna być większa niż lewa! Podaj górny przedział jeszcze raz, i proszę, kurde, żeby był tym razem dobry:\n");
                    right = scanner.nextDouble();
                }
            }

            System.out.println("Podaj kryterium zatrzymania algorytmu:\n");
            System.out.println("1. spełnienie warunku nałożonego na dokładność\n");
            System.out.println("2. osiągnięcie zadanej liczby iteracji\n");
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Podaj epsilon (z przecinkiem, nie z kropką):");
                try {
                    epsilon = scanner.nextDouble();
                    System.out.println("\nepsilon = " + epsilon + "\n");
                    iterations = Integer.MAX_VALUE;
                } catch (InputMismatchException e) {
                    System.out.println("Prawdopodobnie podano liczbę zmiennoprzecinkową z kropką. Panowie, tak się nie robi, wychodzimy.\n");
                    return;
                }

            } else if (choice == 2) {
                System.out.println("Podaj liczbe iteracji:");
                try {
                    iterations = scanner.nextInt();
                    System.out.println("\n" + iterations + " iteracji.\n");
                    epsilon = -1.0;
                } catch (InputMismatchException e) {
                    System.out.println("To chyba nie integer?\n");
                    return;
                }
            } else {
                System.out.println("Podano zły numer.\n");
            }

            // JavaPlot plot = new JavaPlot("D:\\gnuplot\\bin\\gnuplot.exe");
            JavaPlot plot = new JavaPlot("C:\\Program Files\\gnuplot\\bin\\gnuplot.exe");
            PlotStyle chartStyle = new PlotStyle();
            chartStyle.setStyle(Style.LINES);

            if (fun.calc(left) * fun.calc(right) < 0) {
                double xBisection = algorithms.bisection(left, right, epsilon, iterations, fun);
                double xEuler = algorithms.euler(left, right, epsilon, iterations, fun);
                double [][] points = {
                        {xEuler, fun.calc(xEuler)},
                        {xBisection, fun.calc(xBisection)}
                };
                plot.addPlot(points);
            } else {
                System.out.println("Brak miejsca zerowego w danym przedziale bądź istnienie więcej niż jednego miejsca zerowego.\n");
            }

            double [][] chart = new double[500][2];

            for (int i = 0; i < chart.length; i++) {
                chart[i][0] = ((i - 250) * 1.0) / 15;
                chart[i][1] = fun.calc( ((i - 250) * 1.0) / 15);
            }

            DataSetPlot chartPlot = new DataSetPlot(chart);
            chartPlot.setPlotStyle(chartStyle);

            plot.set("xlabel", "'x'");
            plot.set("xlabel", "'y'");
            plot.set("xzeroaxis", "");
            plot.set("zeroaxis", "");

            plot.addPlot(chartPlot);
            String range = "["+left+":"+right+"]";
            plot.set("xrange", range);
            plot.set("yrange", "[-20:20]");
            plot.plot();

            System.out.println("\n\nKontynuować?\n");
            System.out.println("0 - nie");
            System.out.println("1 - tak");
            con = scanner.nextInt();
        }
    }
}
