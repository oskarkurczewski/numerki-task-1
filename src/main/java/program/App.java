package program;

public class App {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        Functions functions = new Functions();
        System.out.println("\n\n");
        System.out.println(greeter.authorInfo());
        System.out.println("\n\n");

        System.out.println("\n\nWyniki dzialan powinny byc bliskie 0:\n");
        System.out.print(functions.exponential(1.38));
        System.out.println("\n\n");
        System.out.print(functions.polynomial(-3.61));
        System.out.println("\n\n");
        System.out.print(functions.trigonometric(-Math.PI));

        System.out.println("\n\n");
        System.out.println("\n\n");
        System.out.println("Uwaga złożenie idzie\n");
        System.out.println(functions.trigonometric(functions.polynomial(-3.61)));

    }
}
