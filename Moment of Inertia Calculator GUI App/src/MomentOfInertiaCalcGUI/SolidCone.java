package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class SolidCone extends Body {
    double radius;
    double height;

    public SolidCone() {
        name = "Solid Cone";
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter radius (m): ");
        radius = scanner.nextDouble();
        System.out.print("Enter height (m): ");
        height = scanner.nextDouble();
    }

    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: return (1.0 / 20.0) * mass * (radius * radius + 4 * height * height); // I = (1/20) * m * (r² + 4h²) (symmetry axis, vertex to base)
            case 2: return (3.0 / 20.0) * mass * radius * radius;                         // I = (3/20) * m * r² (⊥ to symmetry axis through base)
            default: return 0;
        }
    }
}