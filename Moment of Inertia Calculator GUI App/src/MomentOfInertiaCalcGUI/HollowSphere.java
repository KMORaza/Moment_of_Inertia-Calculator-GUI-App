package MomentOfInertiaCalcGUI;
import java.util.Scanner;
public class HollowSphere extends Body {
    double innerR;
    double outerR;
    public HollowSphere() {
        name = "Hollow Sphere";
    }
    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter inner radius (m): ");
        innerR = scanner.nextDouble();
        System.out.print("Enter outer radius (m): ");
        outerR = scanner.nextDouble();
    }
    @Override
    public double calculateMI(int axis) {
        // I = (2/5) * m * (r₂⁵ - r₁⁵) / (r₂³ - r₁³) (about any diameter)
        double num = (2.0 / 5.0) * mass * (Math.pow(outerR, 5) - Math.pow(innerR, 5));
        double den = Math.pow(outerR, 3) - Math.pow(innerR, 3);
        return num / den;
    }
}