package program;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Greeter greeter = new Greeter();

        double epsilon;
        int iterations;
        int f;
        int choice;
        double left;
        double right;
        int con = 1;

        while (con == 1) {

            System.out.println("\n\n" + greeter.authorInfo() + "\n\n");
            System.out.println("Wybierz funkcję:\n");
            System.out.println("1 - f(x) = x^3 + 2x^2 - 5x +3\n");
            System.out.println("2 - g(x) = sin(1/2 x) + 1\n");
            System.out.println("3 - h(x) = e^x - 4\n");
            System.out.println("4 - h(f(x))\n");
            System.out.println("5 - f(h(x)\n");
            System.out.println("6 - h(g(x)\n");
            f = scanner.nextInt();

            System.out.println("Podaj dolny przedział:\n");
            left = scanner.nextDouble();

            System.out.println("Podaj górny przedział:\n");
            right = scanner.nextDouble();
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
                System.out.println("Podaj epsilon:");
                epsilon = scanner.nextDouble();
                iterations = Integer.MAX_VALUE;

            } else {
                System.out.println("Podaj liczbe iteracji:");
                epsilon = - 1.0;
                iterations = scanner.nextInt();
            }

            Algorithms.euler(left, right, epsilon, iterations, f);
            Algorithms.bisection(left, right, epsilon, iterations, f);

            System.out.println("\n\nKontynuować?\n");
            System.out.println("0 - nie");
            System.out.println("1 - tak");
            con = scanner.nextInt();
        }
    }
}
