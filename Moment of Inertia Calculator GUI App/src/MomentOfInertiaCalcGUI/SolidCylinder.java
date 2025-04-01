package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class SolidCylinder extends Body {
    double radius;
    double height;

    public SolidCylinder() {
        name = "Solid Cylinder";
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
            case 1: return (1.0 / 12.0) * mass * (3 * radius * radius + height * height); // I = (1/12) * m * (3r² + h²) (longitudinal)
            case 2: return (1.0 / 2.0) * mass * radius * radius;                         // I = (1/2) * m * r² (⊥ to axis)
            default: return 0;
        }
    }
}