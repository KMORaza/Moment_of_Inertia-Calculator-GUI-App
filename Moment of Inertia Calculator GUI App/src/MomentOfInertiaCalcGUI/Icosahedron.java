package MomentOfInertiaCalcGUI;
import java.util.Scanner;
public class Icosahedron extends Body {
    double side;
    public Icosahedron() {
        name = "Regular Icosahedron";
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
            case 1: return (1.0 / 20.0) * mass * side * side * (3 + Math.sqrt(5)); // I = (1/20) * m * s² * (3 + √5) (through center, vertex-to-vertex)
            default: return 0;
        }
    }
}