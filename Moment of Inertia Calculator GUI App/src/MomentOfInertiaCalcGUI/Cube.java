package MomentOfInertiaCalcGUI;
import java.util.Scanner;
public class Cube extends Body {
    double side;
    public Cube() {
        name = "Cube";
    }
    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter side length (m): ");
        side = scanner.nextDouble();
    }
    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: return (1.0 / 6.0) * mass * side * side;  // I = (1/6) * m * s² (through center, ⊥ to faces)
            case 2: return (1.0 / 12.0) * mass * side * side; // I = (1/12) * m * s² (through center, along edge)
            case 3: return (1.0 / 3.0) * mass * side * side;  // I = (1/3) * m * s² (through opposite edges)
            case 4: return (2.0 / 3.0) * mass * side * side;  // I = (2/3) * m * s² (through opposite vertices)
            default: return 0;
        }
    }
}