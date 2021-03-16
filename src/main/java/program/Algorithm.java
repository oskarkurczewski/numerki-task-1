package program;

import java.util.Scanner;

public class Algorithm {
    public void euler(double a, double b, boolean m, int number) {
        Scanner scanner = new Scanner(System.in);
        int i = 0, iterations = Integer.MAX_VALUE;
        double x, epsilon = -1.0;
        
        if (m==false)
        {
            scanner.nextDouble();
        }
        else
        {
            scanner.nextInt();
        }
        while ((Math.abs(b-a)>epsilon) && (i<iterations) && (a!=b))
        {
            x =b- f(b) *(b-a)/(f(b)-f(a));
            a=b;
            b=x;
            i++;
        }
    }
}
