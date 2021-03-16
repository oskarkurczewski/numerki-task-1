package program;

import java.util.Scanner;

public class Algorithm {
    public void euler(double left, double right, boolean estimation, double f) {
        Scanner scanner = new Scanner(System.in);
        int i = 0, iterations = Integer.MAX_VALUE;
        double x, epsilon = -1.0;
        
        if (estimation == true) {
            System.out.println("");
            epsilon = scanner.nextDouble();
        }
        else {
            System.out.println("");
            iterations = scanner.nextInt();
        }
        while ((Math.abs(right - left) > epsilon) && (i < iterations) && (left != right)) {
            x = right - f(right) * (right-left) / (f(right)-f(left));
            left = right;
            right = x;
            i++;
        }
    }
}
