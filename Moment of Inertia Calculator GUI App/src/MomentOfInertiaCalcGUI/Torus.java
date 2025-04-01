package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class Torus extends Body {
    double minorR;
    double majorR;

    public Torus() {
        name = "Torus";
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter minor radius (a, m): ");
        minorR = scanner.nextDouble();
        System.out.print("Enter major radius (b, m): ");
        majorR = scanner.nextDouble();
    }

    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: return mass * (majorR * majorR + (3.0 / 4.0) * minorR * minorR);      // I = m * (b² + (3/4)a²) (symmetry axis, ⊥ to plane)
            case 2: return (1.0 / 2.0) * mass * (majorR * majorR + (5.0 / 4.0) * minorR * minorR); // I = (1/2) * m * (b² + (5/4)a²) (diameter through center)
            default: return 0;
        }
    }
}