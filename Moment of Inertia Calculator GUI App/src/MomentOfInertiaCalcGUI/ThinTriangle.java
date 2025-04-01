package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class ThinTriangle extends Body {
    double base;
    double height;

    public ThinTriangle() {
        name = "Thin Triangle";
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter base (m): ");
        base = scanner.nextDouble();
        System.out.print("Enter height (m): ");
        height = scanner.nextDouble();
    }

    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: return (1.0 / 36.0) * mass * (base * base + height * height); // I = (1/36) * m * (b² + h²) (centroid, ⊥ to plane)
            case 2: return (1.0 / 18.0) * mass * height * height;                  // I = (1/18) * m * h² (through base)
            default: return 0;
        }
    }
}