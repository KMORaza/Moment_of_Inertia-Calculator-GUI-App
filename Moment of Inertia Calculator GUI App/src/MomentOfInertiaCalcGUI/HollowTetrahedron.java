package MomentOfInertiaCalcGUI;
import java.util.Scanner;
public class HollowTetrahedron extends Body {
    double side;
    public HollowTetrahedron() {
        name = "Hollow Tetrahedron";
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
            case 1: return (1.0 / 6.0) * mass * side * side; // I = (1/6) * m * s² (vertex to center of mass)
            default: return 0;
        }
    }
}