package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class ThinRod extends Body {
    double length;

    public ThinRod() {
        name = "Thin Rod";
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter length (m): ");
        length = scanner.nextDouble();
    }

    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: return (1.0 / 12.0) * mass * length * length; // I = (1/12) * m * L² (center, ⊥ to length)
            case 2: return (1.0 / 3.0) * mass * length * length;  // I = (1/3) * m * L² (end, ⊥ to length)
            default: return 0;
        }
    }
}