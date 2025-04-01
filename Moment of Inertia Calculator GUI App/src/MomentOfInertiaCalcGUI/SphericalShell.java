package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class SphericalShell extends Body {
    double r1;
    double r2;

    public SphericalShell() {
        name = "Spherical Shell";
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter inner radius (r1, m): ");
        r1 = scanner.nextDouble();
        System.out.print("Enter outer radius (r2, m): ");
        r2 = scanner.nextDouble();
    }

    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: {
                double num = (2.0 / 3.0) * mass * (Math.pow(r2, 3) - Math.pow(r1, 3));
                double den = Math.pow(r2, 3) - Math.pow(r1, 3);
                // I = (2/3) * m * (r₂³ - r₁³) / (r₂³ - r₁³) * (r₂² + r₁² - r₁r₂) (about any diameter)
                return num / den * (r2 * r2 + r1 * r1 - r1 * r2);
            }
            default: return 0;
        }
    }
}