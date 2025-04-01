package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class SolidPyramid extends Body {
    double base;
    double height;

    public SolidPyramid() {
        name = "Solid Pyramid";
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter base side (m): ");
        base = scanner.nextDouble();
        System.out.print("Enter height (m): ");
        height = scanner.nextDouble();
    }

    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: return (1.0 / 20.0) * mass * (base * base + height * height); // I = (1/20) * m * (b² + h²) (vertex to base)
            case 2: return (1.0 / 20.0) * mass * base * base;                      // I = (1/20) * m * b² (⊥ to base)
            default: return 0;
        }
    }
}