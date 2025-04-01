package MomentOfInertiaCalcGUI;

import java.util.Scanner;

public class ThickWalledTube extends Body {

    double innerR;
    double outerR;
    double height;

    public ThickWalledTube() {
        name = "Thick-walled Tube";
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter inner radius (r1, m): ");
        innerR = scanner.nextDouble();
        System.out.print("Enter outer radius (r2, m): ");
        outerR = scanner.nextDouble();
        System.out.print("Enter length (h, m): ");
        height = scanner.nextDouble();
    }

    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: return (1.0 / 12.0) * mass * (3 * (innerR * innerR + outerR * outerR) + height * height); // I = (1/12) * m * (3(r₁² + r₂²) + h²) (longitudinal)
            case 2: return (1.0 / 2.0) * mass * (innerR * innerR + outerR * outerR);                         // I = (1/2) * m * (r₁² + r₂²) (⊥ to longitudinal)
            default: return 0;
        }
    }
}