package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class SolidSphere extends Body {
    double radius;

    public SolidSphere() {
        name = "Solid Sphere";
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
        // I = (2/5) * m * r² (about any diameter)
        return (2.0 / 5.0) * mass * radius * radius;
    }
}