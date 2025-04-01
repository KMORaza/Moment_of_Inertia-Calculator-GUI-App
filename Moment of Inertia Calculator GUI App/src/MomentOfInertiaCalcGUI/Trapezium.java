package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class Trapezium extends Body {

    double top;
    double bottom;
    double height;

    public Trapezium() {
        name = "Trapezium";
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter top length (m): ");
        top = scanner.nextDouble();
        System.out.print("Enter bottom length (m): ");
        bottom = scanner.nextDouble();
        System.out.print("Enter height (m): ");
        height = scanner.nextDouble();
    }

    @Override
    public double calculateMI(int axis) {
        double h = height;
        double a = top, b = bottom;
        switch (axis) {
            case 1: return (1.0 / 36.0) * mass * h * (a * a + a * b + b * b); // I = (1/36) * m * h * (a² + ab + b²) (centroid, ⊥ to plane)
            case 2: return (1.0 / 12.0) * mass * h * (a + b);                 // I = (1/12) * m * h * (a + b) (parallel to bases)
            default: return 0;
        }
    }
}