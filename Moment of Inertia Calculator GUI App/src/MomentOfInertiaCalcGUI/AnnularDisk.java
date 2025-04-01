package MomentOfInertiaCalcGUI;
import java.util.Scanner;
public class AnnularDisk extends Body {
    double innerR;
    double outerR;
    public AnnularDisk() {
        name = "Annular Disk";
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
        switch (axis) {
            case 1: return (1.0 / 2.0) * mass * (innerR * innerR + outerR * outerR); // I = (1/2) * m * (r₁² + r₂²) (center, ⊥ to plane)
            case 2: return (1.0 / 4.0) * mass * (innerR * innerR + outerR * outerR); // I = (1/4) * m * (r₁² + r₂²) (center, in plane)
            default: return 0;
        }
    }
}