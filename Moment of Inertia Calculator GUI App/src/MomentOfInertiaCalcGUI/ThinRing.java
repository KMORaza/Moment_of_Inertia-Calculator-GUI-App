package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class ThinRing extends Body {
    double radius;

    public ThinRing() {
        name = "Thin Ring";
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter radius (m): ");
        radius = scanner.nextDouble();
    }

    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: return mass * radius * radius;             // I = m * r² (center, ⊥ to plane)
            case 2: return (1.0 / 2.0) * mass * radius * radius; // I = (1/2) * m * r² (center, in plane)
            default: return 0;
        }
    }
}