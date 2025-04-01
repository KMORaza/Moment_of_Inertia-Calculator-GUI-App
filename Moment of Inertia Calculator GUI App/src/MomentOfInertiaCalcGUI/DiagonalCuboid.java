package MomentOfInertiaCalcGUI;
import java.util.Scanner;
public class DiagonalCuboid extends Body {

    double D;
    double W;
    double L;
    public DiagonalCuboid() {
        name = "Diagonal Cuboid";
    }
    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter height (D, m): ");
        D = scanner.nextDouble();
        System.out.print("Enter width (W, m): ");
        W = scanner.nextDouble();
        System.out.print("Enter length (L, m): ");
        L = scanner.nextDouble();
    }
    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: { 
                double s = Math.sqrt(D * D + W * W + L * L);
                double I_cm = (1.0 / 12.0) * mass * (D * D + W * W + L * L);
                // I ≈ (1/12) * m * (D² + W² + L²) * (s² / (D² + W² + L²)) (approximation about longest diagonal)
                return I_cm * (s * s) / (D * D + W * W + L * L);
            }
            default: return 0;
        }
    }
}