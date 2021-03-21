package program;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Greeter greeter = new Greeter();

        double epsilon = 0;
        int iterations = 0;
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
            System.out.println("5 - f(h(x)\n");
            System.out.println("6 - h(g(x)\n");
            try {
                f = scanner.nextInt();
                if (f > 6 || f < 1) {
                    System.out.println("Przecież tu nie było funkcji " + f);
                    return;
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
                } catch (InputMismatchException e) {
                    System.out.println("Prawdopodobnie podano liczbę zmiennoprzecinkową z kropką. Panowie, tak się nie robi, wychodzimy.\n");
                    return;
                }
                iterations = Integer.MAX_VALUE;

            } else if (choice == 2) {
                System.out.println("Podaj liczbe iteracji:");
                epsilon = - 1.0;
                try {
                    iterations = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("To chyba nie integer?\n");
                    return;
                }

            } else {
                System.out.println("Podano zły numer.\n");
            }

            Algorithms.euler(left, right, epsilon, iterations, f, choice);
            Algorithms.bisection(left, right, epsilon, iterations, f, choice);

            System.out.println("\n\nKontynuować?\n");
            System.out.println("0 - nie");
            System.out.println("1 - tak");
            con = scanner.nextInt();
        }
    }
}
