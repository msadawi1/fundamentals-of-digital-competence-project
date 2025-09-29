import java.util.Scanner;

/**
 * This program calculates the volume of various 3D shapes
 * (sphere, pyramid, cone, and cylinder) to determine the
 * amount of resin required for 3D printing.
 *
 * Users can input the dimensions of the desired shape,
 * and the program will compute the corresponding volume,
 * which represents the estimated resin needed.
 *
 * Formulas used:
 *  - Sphere: (4/3) * π * r^3
 *  - Pyramid (square base): (l^2 * h) / 3
 *  - Cone: (π * r^2 * h) / 3
 *  - Cylinder: π * r^2 * h
 */


public class Printing {
    // shapes variables (values from user)
    static boolean start = true;
    static final double PI = 3.14;
    static double radius;
    static double length;
    static double height;
    static double Total;

    static double ball_Scale(double r) {
        return (4.0 / 3.0) * PI * r * r * r;
    }

    static double pyr_Scale(double l, double h) {
        return ((l * l) * h) / 3;
    }

    static double cone_Scale(double r, double h) {
        return ((r * r * PI) * h) / 3;
    }

    static double cyl_Scale(double r, double h) {
        return 1.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (start) {
            Total = 0; // Reset Total at the start of each loop
            System.out.println("""
==============================
   Welcome to Resin Calculator
==============================
Please select a 3D model to calculate the required resin:
""");
            System.out.println("""
1 - Ball (Sphere)
2 - Pyramid (Four-Faceted)
3 - Cone
4 - Cylinder
5 - Exit Program
""");
            System.out.print("Enter your choice (1-5): ");
            int choise = input.nextInt();
            switch (choise) {
                case 1 -> {
                    System.out.print("Enter the radius of the Ball (in cm): ");
                    radius = input.nextDouble();
                    Total = ball_Scale(radius);
                    System.out.println("You selected: Ball (Sphere)");
                }
                case 2 -> {
                    System.out.print("Enter the base length of the Pyramid (in cm): ");
                    length = input.nextDouble();
                    System.out.print("Enter the height of the Pyramid (in cm): ");
                    height = input.nextDouble();
                    Total = pyr_Scale(length, height);
                    System.out.println("You selected: Pyramid (Four-Faceted)");
                }
                case 3 -> {
                    System.out.print("Enter the radius of the Cone (in cm): ");
                    radius = input.nextDouble();
                    System.out.print("Enter the height of the Cone (in cm): ");
                    height = input.nextDouble();
                    Total = cone_Scale(radius, height);
                    System.out.println("You selected: Cone");
                }
                case 4 -> {
                    System.out.print("Enter the radius of the Cylinder (in cm): ");
                    radius = input.nextDouble();
                    System.out.print("Enter the height of the Cylinder (in cm): ");
                    height = input.nextDouble();
                    Total = cyl_Scale(radius, height);
                    System.out.println("You selected: Cylinder");
                }
                case 5 -> {
                    start = false;
                    System.out.println("\nThank you for using the Resin Calculator. Goodbye!");
                }
                default ->
                    System.out.println("Invalid option. Please enter a number between 1 and 5.\n");
            }
            if (choise >= 1 && choise <= 4) {
                System.out.printf("\nEstimated resin required: %.2f cm^3\n\n", Total);
            }
        }
    }
}
