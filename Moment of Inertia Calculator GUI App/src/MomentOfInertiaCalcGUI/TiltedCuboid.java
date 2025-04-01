package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class TiltedCuboid extends Body {

    double d;
    double w;
    double l;

    public TiltedCuboid() {
        name = "Tilted Cuboid";
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter depth (d, m): ");
        d = scanner.nextDouble();
        System.out.print("Enter width (w, m): ");
        w = scanner.nextDouble();
        System.out.print("Enter length (l, m): ");
        l = scanner.nextDouble();
    }

    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: return (1.0 / 12.0) * mass * (w * w + l * l); // I = (1/12) * m * (w² + l²) (about vertical axis, depth)
            default: return 0;
        }
    }
}