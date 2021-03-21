package program;

public class Algorithms {
    public static void euler(double left, double right, double epsilon, int iterations, int f, int choice) {
        int i = 0;
        double x = 0;

        if (choice == 1) {
            switch (f) {
                case (1):
                    while ((Functions.polynomial(x) > epsilon) && (left != right)) {
                        x = right - Functions.polynomial(right) * (right - left) / (Functions.polynomial(right) - Functions.polynomial(left));
                        left = right;
                        right = x;
                        i++;
                        break;
                    }
                case (2):
                    while ((Functions.trigonometric(x) > epsilon) && (left != right)) {
                        x = right - Functions.trigonometric(right) * (right - left) / (Functions.trigonometric(right) - Functions.trigonometric(left));
                        left = right;
                        right = x;
                        i++;
                        break;
                    }
                case (3):
                    while ((Functions.exponential(x) > epsilon) && (left != right)) {
                        x = right - Functions.exponential(right) * (right - left) / (Functions.exponential(right) - Functions.exponential(left));
                        left = right;
                        right = x;
                        i++;
                        break;
                    }
                case (4):
                    while ((Functions.comp_expo_poly(x) > epsilon) && (left != right)) {
                        x = right - Functions.comp_expo_poly(right) * (right - left) / (Functions.comp_expo_poly(right) - Functions.comp_expo_poly(left));
                        left = right;
                        right = x;
                        i++;
                        break;
                    }
                case (5):
                    while ((Functions.comp_poly_expo(x) > epsilon) && (left != right)) {
                        x = right - Functions.comp_poly_expo(right) * (right - left) / (Functions.comp_poly_expo(right) - Functions.comp_poly_expo(left));
                        left = right;
                        right = x;
                        i++;
                        break;
                    }
                case (6):
                    while ((Functions.comp_expo_tri(x) > epsilon) && (left != right)) {
                        x = right - Functions.comp_expo_tri(right) * (right - left) / (Functions.comp_expo_tri(right) - Functions.comp_expo_tri(left));
                        left = right;
                        right = x;
                        i++;
                        break;
                    }
            }
        } else if (choice == 2) {
            while ((i < iterations) && (left != right)) {
                switch (f) {
                    case (1):
                        x = right - Functions.polynomial(right) * (right - left) / (Functions.polynomial(right) - Functions.polynomial(left));
                        left = right;
                        right = x;
                        i++;
                        break;
                    case (2):
                        x = right - Functions.trigonometric(right) * (right - left) / (Functions.trigonometric(right) - Functions.trigonometric(left));
                        left = right;
                        right = x;
                        i++;
                        break;
                    case (3):
                        x = right - Functions.exponential(right) * (right - left) / (Functions.exponential(right) - Functions.exponential(left));
                        left = right;
                        right = x;
                        i++;
                        break;
                    case (4):
                        x = right - Functions.comp_expo_poly(right) * (right - left) / (Functions.comp_expo_poly(right) - Functions.comp_expo_poly(left));
                        left = right;
                        right = x;
                        i++;
                        break;
                    case (5):
                        x = right - Functions.comp_poly_expo(right) * (right - left) / (Functions.comp_poly_expo(right) - Functions.comp_poly_expo(left));
                        left = right;
                        right = x;
                        i++;
                        break;
                    case (6):
                        x = right - Functions.comp_expo_tri(right) * (right - left) / (Functions.comp_expo_tri(right) - Functions.comp_expo_tri(left));
                        left = right;
                        right = x;
                        i++;
                        break;
                }
            }
        }

        System.out.println("\nMetoda siecznych: Koniec szukania rozwiazania. Miejsce zerowe w x = " + x);
    }

    public static void bisection(double left, double right, double epsilon, int iterations, int f, int choice) {
        int i = 0;
        double x = 0;

        if (choice == 1) {
            switch (f) {
                case (1):
                    while ((Functions.polynomial(x) > epsilon) && (left != right)) {
                        x = (left+right)/2;
                        if (Functions.polynomial(left) * Functions.polynomial(x) < 0) right = x;
                        else left = x;
                        i++;
                        break;
                    }
                case (2):
                    while ((Functions.trigonometric(x) > epsilon) && (left != right)) {
                        x = (left+right)/2;
                        if (Functions.trigonometric(left) * Functions.trigonometric(x) < 0) right = x;
                        else left = x;
                        i++;
                        break;
                    }
                case (3):
                    while ((Functions.exponential(x) > epsilon) && (left != right)) {
                        x = (left+right)/2;
                        if (Functions.exponential(left) * Functions.exponential(x) < 0) right = x;
                        else left = x;
                        i++;
                        break;
                    }
                case (4):
                    while ((Functions.comp_expo_poly(x) > epsilon) && (left != right)) {
                        x = (left+right)/2;
                        if (Functions.comp_expo_poly(left) * Functions.comp_expo_poly(x) < 0) right = x;
                        else left = x;
                        i++;
                        break;
                    }
                case (5):
                    while ((Functions.comp_poly_expo(x) > epsilon) && (left != right)) {
                        x = (left+right)/2;
                        if (Functions.comp_poly_expo(left) * Functions.comp_poly_expo(x) < 0) right = x;
                        else left = x;
                        i++;
                        break;
                    }
                case (6):
                    while ((Functions.comp_expo_tri(x) > epsilon) && (left != right)) {
                        x = (left+right)/2;
                        if (Functions.comp_expo_tri(left) * Functions.comp_expo_tri(x) < 0) right = x;
                        else left = x;
                        i++;
                        break;
                    }
            }
        } else if (choice == 2) {
            // jeśli iteracje
            while ((i < iterations) && (left != right)) {
                switch (f) {
                    case (1):
                        x = (left + right) / 2;
                        if (Functions.polynomial(left) * Functions.polynomial(x) < 0) right = x;
                        else left = x;
                        i++;
                        break;
                    case (2):
                        x = (left + right) / 2;
                        if (Functions.trigonometric(left) * Functions.trigonometric(x) < 0) right = x;
                        else left = x;
                        i++;
                        break;
                    case (3):
                        x = (left + right) / 2;
                        if (Functions.exponential(left) * Functions.exponential(x) < 0) right = x;
                        else left = x;
                        i++;
                        break;
                    case (4):
                        x = (left + right) / 2;
                        if (Functions.comp_expo_poly(left) * Functions.comp_expo_poly(x) < 0) right = x;
                        else left = x;
                        i++;
                        break;
                    case (5):
                        x = (left + right) / 2;
                        if (Functions.comp_poly_expo(left) * Functions.comp_poly_expo(x) < 0) right = x;
                        else left = x;
                        i++;
                        break;
                    case (6):
                        x = (left + right) / 2;
                        if (Functions.comp_expo_tri(left) * Functions.comp_expo_tri(x) < 0) right = x;
                        else left = x;
                        i++;
                        break;
                }
            }
        }

        System.out.println("\nBisekcja: Koniec szukania rozwiazania. Miejsce zerowe w x = " + x);
    }
}
