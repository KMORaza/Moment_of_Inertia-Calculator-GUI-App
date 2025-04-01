package MomentOfInertiaCalcGUI;
import java.util.Scanner;
public class IsoscelesTriangle extends Body {
    double L;
    double beta;
    public IsoscelesTriangle() {
        name = "Isosceles Triangle";
    }
    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter common side length (L, m): ");
        L = scanner.nextDouble();
        System.out.print("Enter vertex half-angle (β, degrees): ");
        beta = scanner.nextDouble();
        beta = beta * Math.PI / 180.0; // convert to radians
    }
    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: {
                double h = L * Math.cos(beta);
                double b = 2 * L * Math.sin(beta);
                // I = (1/36) * m * (b² + h²), where b = 2L sin(β), h = L cos(β) (through tip, ⊥ to plane)
                return (1.0 / 36.0) * mass * (b * b + h * h);
            }
            default: return 0;
        }
    }
}