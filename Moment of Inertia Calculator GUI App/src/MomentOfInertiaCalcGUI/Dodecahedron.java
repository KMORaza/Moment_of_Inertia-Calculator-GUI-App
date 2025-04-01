package MomentOfInertiaCalcGUI;
import java.util.Scanner;
public class Dodecahedron extends Body {
    double side;
    public Dodecahedron() {
        name = "Regular Dodecahedron";
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
            case 1: return (1.0 / 5.0) * mass * side * side * (3 + Math.sqrt(5)) / 4; // I = (1/5) * m * s² * (3 + √5) / 4 (through center, vertex-to-vertex)
            default: return 0;
        }
    }
}