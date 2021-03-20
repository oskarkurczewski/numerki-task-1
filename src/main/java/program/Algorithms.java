package program;

import java.util.Scanner;

public class Algorithms {
    public static void euler(double left, double right, double epsilon, int iterations, int f) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        double x;

        while ((Math.abs(right - left) > epsilon) && (i < iterations) && (left != right)) {
            switch (f){
                case (1):
                    x = right - Functions.polynomial(right) * (right-left) / (Functions.polynomial(right)-Functions.polynomial(left));
                    left = right;
                    right = x;
                    i++;
                    break;
                case (2):
                    x = right - Functions.trigonometric(right) * (right-left) / (Functions.trigonometric(right)-Functions.trigonometric(left));
                    left = right;
                    right = x;
                    i++;
                    break;
                case (3):
                    x = right - Functions.exponential(right) * (right-left) / (Functions.exponential(right)-Functions.exponential(left));
                    left = right;
                    right = x;
                    i++;
                    break;
            }
        }
    }

    public static void bisection(double left, double right, double epsilon, int iterations, int f) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        double x;

        while ((Math.abs(right - left) > epsilon) && (i < iterations) && (left != right)) {
            switch (f){
                case (1):
                    x = (left+right)/2;
                    if (Functions.polynomial(left) * Functions.polynomial(x) < 0) right = x;
                    else left = x;
                    i++;
                    break;
                case (2):
                    x = (left+right)/2;
                    if (Functions.trigonometric(left) * Functions.trigonometric(x) < 0) right = x;
                    else left = x;
                    i++;
                    break;
                case (3):
                    x = (left+right)/2;
                    if (Functions.exponential(left) * Functions.exponential(x) < 0) right = x;
                    else left = x;
                    i++;
                    break;
            }
        }
    }
}
