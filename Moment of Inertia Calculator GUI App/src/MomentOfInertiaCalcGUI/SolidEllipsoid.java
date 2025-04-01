package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class SolidEllipsoid extends Body {

    double a;
    double b;
    double c;

    public SolidEllipsoid() {
        name = "Solid Ellipsoid";
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter semiaxis a (m): ");
        a = scanner.nextDouble();
        System.out.print("Enter semiaxis b (m): ");
        b = scanner.nextDouble();
        System.out.print("Enter semiaxis c (m): ");
        c = scanner.nextDouble();
    }

    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: return (1.0 / 5.0) * mass * (b * b + c * c); // I = (1/5) * m * (b² + c²) (about a-axis)
            case 2: return (1.0 / 5.0) * mass * (a * a + c * c); // I = (1/5) * m * (a² + c²) (about b-axis)
            case 3: return (1.0 / 5.0) * mass * (a * a + b * b); // I = (1/5) * m * (a² + b²) (about c-axis)
            default: return 0;
        }
    }
}