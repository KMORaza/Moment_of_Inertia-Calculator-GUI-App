package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class RectangularCuboid extends Body {

    double height;
    double width;
    double depth;

    public RectangularCuboid() {
        name = "Rectangular Cuboid";
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter height (h, m): ");
        height = scanner.nextDouble();
        System.out.print("Enter width (w, m): ");
        width = scanner.nextDouble();
        System.out.print("Enter depth (d, m): ");
        depth = scanner.nextDouble();
    }

    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: return (1.0 / 12.0) * mass * (width * width + depth * depth); // I = (1/12) * m * (w² + d²) (about height axis)
            case 2: return (1.0 / 12.0) * mass * (height * height + depth * depth); // I = (1/12) * m * (h² + d²) (about width axis)
            case 3: return (1.0 / 12.0) * mass * (height * height + width * width); // I = (1/12) * m * (h² + w²) (about depth axis)
            default: return 0;
        }
    }
}