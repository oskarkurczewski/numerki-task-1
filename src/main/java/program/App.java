package program;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        double epsilon;
        int iterations;
        Scanner scanner = new Scanner(System.in);
        Greeter greeter = new Greeter();
        System.out.println("\n\n" + greeter.authorInfo() + "\n\n");

        System.out.println("Wybierz funkcję:\n");
        System.out.println("1. y = x^3 + 2x^2 - 5x +3\n");
        System.out.println("2. y = sin(1/2 x) + 1\n");
        System.out.println("3. y = e^x - 4\n");
        int f = scanner.nextInt();

        System.out.println("Podaj dolny przedział:\n");
        double left = scanner.nextDouble();
        System.out.println("Podaj górny przedział:\n");
        double right = scanner.nextDouble();

        System.out.println("Podaj kryterium zatrzymania algorytmu:\n");
        System.out.println("1. spełnienie warunku nałożonego na dokładność\n");
        System.out.println("2. osiągnięcie zadanej liczby iteracji\n");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Podaj epsilon:");
            epsilon = scanner.nextDouble();
            iterations = Integer.MAX_VALUE;

        }
        else {
            System.out.println("Podaj liczbe iteracji:");
            epsilon = -1.0;
            iterations = scanner.nextInt();
        }

        Algorithms.euler(left, right, epsilon, iterations , f);
        Algorithms.bisection(left, right, epsilon, iterations, f);

//        System.out.println("\n\nWyniki dzialan powinny byc bliskie 0:\n");
//        System.out.print(Functions.exponential(1.38));
//        System.out.println("\n\n");
//        System.out.print(Functions.polynomial(-3.61));
//        System.out.println("\n\n");
//        System.out.print(Functions.trigonometric(-Math.PI));
//
//        System.out.println("\n\n");
//        System.out.println("\n\n");
//        System.out.println("Uwaga złożenie idzie\n");
//        System.out.println(Functions.trigonometric(Functions.polynomial(-3.61)));

    }
}
