package MomentOfInertiaCalcGUI;
import java.util.Scanner;
public class Quadrilateral extends Body {
    double width;
    double height;
    public Quadrilateral() {
        name = "Quadrilateral";
    }
    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter width (m): ");
        width = scanner.nextDouble();
        System.out.print("Enter height (m): ");
        height = scanner.nextDouble();
    }
    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: return (1.0 / 12.0) * mass * (width * width + height * height); // I = (1/12) * m * (w² + h²) (center, ⊥ to plane)
            case 2: return (1.0 / 12.0) * mass * height * height;                    // I = (1/12) * m * h² (through width)
            case 3: return (1.0 / 12.0) * mass * width * width;                     // I = (1/12) * m * w² (through height)
            default: return 0;
        }
    }
}