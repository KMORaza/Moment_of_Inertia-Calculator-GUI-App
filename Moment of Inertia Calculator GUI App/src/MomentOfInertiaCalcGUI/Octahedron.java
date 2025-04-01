package MomentOfInertiaCalcGUI;
import java.util.Scanner;
public class Octahedron extends Body {
    double side;
    public Octahedron() {
        name = "Regular Octahedron";
    }
    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter mass (kg): ");
        mass = scanner.nextDouble();
        System.out.print("Enter side length (s, m): ");
        side = scanner.nextDouble();
    }
    @Override
    public double calculateMI(int axis) {
        switch (axis) {
            case 1: return (1.0 / 10.0) * mass * side * side; // I = (1/10) * m * s² (through center, ⊥ to faces)
            default: return 0;
        }
    }
}