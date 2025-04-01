package MomentOfInertiaCalcGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class MomentOfInertiaGUI extends JFrame {
    private JComboBox<String> bodyComboBox;
    private JComboBox<String> axisComboBox;
    private JPanel inputPanel;
    private Map<String, JTextField> inputFields;    
    private JLabel resultLabel;
    private Body currentBody;

    public MomentOfInertiaGUI() {
        setTitle("Moment of Inertia Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setSize(450, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        String[] bodies = {
            "Solid Sphere", 
            "Thin Rod", 
            "Thin Disk", 
            "Thin Ring", 
            "Annular Disk",
            "Quadrilateral", 
            "Solid Cylinder", 
            "Hollow Cylinder", 
            "Hollow Sphere",
            "Thin Triangle", 
            "Solid Pyramid", 
            "Hollow Pyramid", 
            "Trapezium",
            "Thick-walled Tube", 
            "Hollow Tetrahedron", 
            "Solid Tetrahedron",
            "Solid Cone", 
            "Hollow Cone", 
            "Torus", 
            "Solid Ellipsoid", 
            "Cube",
            "Rectangular Cuboid", 
            "Diagonal Cuboid", 
            "Tilted Cuboid", 
            "Isosceles Triangle",
            "Regular Octahedron", 
            "Regular Dodecahedron", 
            "Regular Icosahedron", 
            "Spherical Shell"
        };
        bodyComboBox = new JComboBox<>(bodies);
        bodyComboBox.addActionListener(e -> updateInputFields());
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Select Body:"));
        topPanel.add(bodyComboBox);
        add(topPanel, BorderLayout.NORTH);

        // Input panel (dynamically updated)
        inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        inputFields = new HashMap<>();
        add(new JScrollPane(inputPanel), BorderLayout.CENTER);

        // Axis selection
        axisComboBox = new JComboBox<>();
        bodyComboBox.addActionListener(e -> updateAxisOptions());
        JPanel axisPanel = new JPanel(new FlowLayout());
        axisPanel.add(new JLabel("Select Axis:"));
        axisPanel.add(axisComboBox);
        add(axisPanel, BorderLayout.EAST);

        // Calculate button and result
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(e -> calculateMI());
        resultLabel = new JLabel("Moment of Inertia: ");
        resultLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(calculateButton);
        bottomPanel.add(resultLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        updateInputFields(); // Initialize with first body
        updateAxisOptions();
    }

    private void updateInputFields() {
        inputPanel.removeAll();
        inputFields.clear();
        String selectedBody = (String) bodyComboBox.getSelectedItem();

        switch (selectedBody) {
            case "Solid Sphere":
                currentBody = new SolidSphere();
                addInputField("Mass (kg)");
                addInputField("Radius (m)");
                break;
            case "Thin Rod":
                currentBody = new ThinRod();
                addInputField("Mass (kg)");
                addInputField("Length (m)");
                break;
            case "Thin Disk":
                currentBody = new ThinDisk();
                addInputField("Mass (kg)");
                addInputField("Radius (m)");
                break;
            case "Thin Ring":
                currentBody = new ThinRing();
                addInputField("Mass (kg)");
                addInputField("Radius (m)");
                break;
            case "Annular Disk":
                currentBody = new AnnularDisk();
                addInputField("Mass (kg)");
                addInputField("Inner Radius (m)");
                addInputField("Outer Radius (m)");
                break;
            case "Quadrilateral":
                currentBody = new Quadrilateral();
                addInputField("Mass (kg)");
                addInputField("Width (m)");
                addInputField("Height (m)");
                break;
            case "Solid Cylinder":
                currentBody = new SolidCylinder();
                addInputField("Mass (kg)");
                addInputField("Radius (m)");
                addInputField("Height (m)");
                break;
            case "Hollow Cylinder":
                currentBody = new HollowCylinder();
                addInputField("Mass (kg)");
                addInputField("Inner Radius (m)");
                addInputField("Outer Radius (m)");
                addInputField("Height (m)");
                break;
            case "Hollow Sphere":
                currentBody = new HollowSphere();
                addInputField("Mass (kg)");
                addInputField("Inner Radius (m)");
                addInputField("Outer Radius (m)");
                break;
            case "Thin Triangle":
                currentBody = new ThinTriangle();
                addInputField("Mass (kg)");
                addInputField("Base (m)");
                addInputField("Height (m)");
                break;
            case "Solid Pyramid":
                currentBody = new SolidPyramid();
                addInputField("Mass (kg)");
                addInputField("Base Side (m)");
                addInputField("Height (m)");
                break;
            case "Hollow Pyramid":
                currentBody = new HollowPyramid();
                addInputField("Mass (kg)");
                addInputField("Base Side (m)");
                addInputField("Height (m)");
                break;
            case "Trapezium":
                currentBody = new Trapezium();
                addInputField("Mass (kg)");
                addInputField("Top Length (m)");
                addInputField("Bottom Length (m)");
                addInputField("Height (m)");
                break;
            case "Thick-walled Tube":
                currentBody = new ThickWalledTube();
                addInputField("Mass (kg)");
                addInputField("Inner Radius (r1, m)");
                addInputField("Outer Radius (r2, m)");
                addInputField("Length (h, m)");
                break;
            case "Hollow Tetrahedron":
                currentBody = new HollowTetrahedron();
                addInputField("Mass (kg)");
                addInputField("Side Length (m)");
                break;
            case "Solid Tetrahedron":
                currentBody = new SolidTetrahedron();
                addInputField("Mass (kg)");
                addInputField("Side Length (m)");
                break;
            case "Solid Cone":
                currentBody = new SolidCone();
                addInputField("Mass (kg)");
                addInputField("Radius (m)");
                addInputField("Height (m)");
                break;
            case "Hollow Cone":
                currentBody = new HollowCone();
                addInputField("Mass (kg)");
                addInputField("Radius (m)");
                addInputField("Height (m)");
                break;
            case "Torus":
                currentBody = new Torus();
                addInputField("Mass (kg)");
                addInputField("Minor Radius (a, m)");
                addInputField("Major Radius (b, m)");
                break;
            case "Solid Ellipsoid":
                currentBody = new SolidEllipsoid();
                addInputField("Mass (kg)");
                addInputField("Semiaxis a (m)");
                addInputField("Semiaxis b (m)");
                addInputField("Semiaxis c (m)");
                break;
            case "Cube":
                currentBody = new Cube();
                addInputField("Mass (kg)");
                addInputField("Side Length (m)");
                break;
            case "Rectangular Cuboid":
                currentBody = new RectangularCuboid();
                addInputField("Mass (kg)");
                addInputField("Height (h, m)");
                addInputField("Width (w, m)");
                addInputField("Depth (d, m)");
                break;
            case "Diagonal Cuboid":
                currentBody = new DiagonalCuboid();
                addInputField("Mass (kg)");
                addInputField("Height (D, m)");
                addInputField("Width (W, m)");
                addInputField("Length (L, m)");
                break;
            case "Tilted Cuboid":
                currentBody = new TiltedCuboid();
                addInputField("Mass (kg)");
                addInputField("Depth (d, m)");
                addInputField("Width (w, m)");
                addInputField("Length (l, m)");
                break;
            case "Isosceles Triangle":
                currentBody = new IsoscelesTriangle();
                addInputField("Mass (kg)");
                addInputField("Common Side Length (L, m)");
                addInputField("Vertex Half-Angle (β, degrees)");
                break;
            case "Regular Octahedron":
                currentBody = new Octahedron();
                addInputField("Mass (kg)");
                addInputField("Side Length (s, m)");
                break;
            case "Regular Dodecahedron":
                currentBody = new Dodecahedron();
                addInputField("Mass (kg)");
                addInputField("Side Length (s, m)");
                break;
            case "Regular Icosahedron":
                currentBody = new Icosahedron();
                addInputField("Mass (kg)");
                addInputField("Side Length (s, m)");
                break;
            case "Spherical Shell":
                currentBody = new SphericalShell();
                addInputField("Mass (kg)");
                addInputField("Inner Radius (r1, m)");
                addInputField("Outer Radius (r2, m)");
                break;
        }
        inputPanel.revalidate();
        inputPanel.repaint();
    }

    private void addInputField(String label) {
        inputPanel.add(new JLabel(label));
        JTextField field = new JTextField(10);
        inputPanel.add(field);
        inputFields.put(label, field);
    }

    private void updateAxisOptions() {
        axisComboBox.removeAllItems();
        String selectedBody = (String) bodyComboBox.getSelectedItem();
        switch (selectedBody) {
            case "Solid Sphere": axisComboBox.addItem("1. Any diameter"); break;
            case "Thin Rod":
                axisComboBox.addItem("1. Center, ⊥ to length");
                axisComboBox.addItem("2. End, ⊥ to length");
                break;
            case "Thin Disk":
            case "Thin Ring":
            case "Annular Disk":
                axisComboBox.addItem("1. Center, perpendicular to plane");
                axisComboBox.addItem("2. Center, in plane");
                break;
            case "Quadrilateral":
                axisComboBox.addItem("1. Center, perpendicular to plane");
                axisComboBox.addItem("2. Through width");
                axisComboBox.addItem("3. Through height");
                break;
            case "Solid Cylinder":
            case "Hollow Cylinder":
            case "Thick-walled Tube":
                axisComboBox.addItem("1. Longitudinal");
                axisComboBox.addItem("2. Perpendicular to axis");
                break;
            case "Hollow Sphere":
            case "Spherical Shell":
                axisComboBox.addItem("1. Any diameter");
                break;
            case "Thin Triangle":
                axisComboBox.addItem("1. Centroid, perpendicular to plane");
                axisComboBox.addItem("2. Through base");
                break;
            case "Solid Pyramid":
            case "Hollow Pyramid":
                axisComboBox.addItem("1. Vertex to base");
                axisComboBox.addItem("2. perpendicular to base");
                break;
            case "Trapezium":
                axisComboBox.addItem("1. Centroid, perpendicular to plane");
                axisComboBox.addItem("2. Parallel to bases");
                break;
            case "Hollow Tetrahedron":
            case "Solid Tetrahedron":
                axisComboBox.addItem("1. Through vertex and center of mass");
                break;
            case "Solid Cone":
            case "Hollow Cone":
                axisComboBox.addItem("1. Symmetry axis (vertex to base)");
                axisComboBox.addItem("2. Perpendicular to symmetry axis through base");
                break;
            case "Torus":
                axisComboBox.addItem("1. Symmetry axis (⊥ to plane)");
                axisComboBox.addItem("2. Diameter through center");
                break;
            case "Solid Ellipsoid":
                axisComboBox.addItem("1. About a-axis");
                axisComboBox.addItem("2. About b-axis");
                axisComboBox.addItem("3. About c-axis");
                break;
            case "Cube":
                axisComboBox.addItem("1. Through center, ⊥ to faces");
                axisComboBox.addItem("2. Through center, along edge");
                axisComboBox.addItem("3. Through opposite edges");
                axisComboBox.addItem("4. Through opposite vertices");
                break;
            case "Rectangular Cuboid":
                axisComboBox.addItem("1. About height axis");
                axisComboBox.addItem("2. About width axis");
                axisComboBox.addItem("3. About depth axis");
                break;
            case "Diagonal Cuboid":
                axisComboBox.addItem("1. About longest diagonal");
                break;
            case "Tilted Cuboid":
                axisComboBox.addItem("1. About vertical axis (depth)");
                break;
            case "Isosceles Triangle":
                axisComboBox.addItem("1. Through tip, ⊥ to plane");
                break;
            case "Regular Octahedron":
                axisComboBox.addItem("1. Through center, ⊥ to faces");
                break;
            case "Regular Dodecahedron":
            case "Regular Icosahedron":
                axisComboBox.addItem("1. Through center, vertex-to-vertex");
                break;
        }
    }

    private void calculateMI() {
        try {
            // Parse input fields and set values for the current body
            if (currentBody instanceof SolidSphere) {
                SolidSphere body = (SolidSphere) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.radius = Double.parseDouble(inputFields.get("Radius (m)").getText());
            } else if (currentBody instanceof ThinRod) {
                ThinRod body = (ThinRod) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.length = Double.parseDouble(inputFields.get("Length (m)").getText());
            } else if (currentBody instanceof ThinDisk) {
                ThinDisk body = (ThinDisk) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.radius = Double.parseDouble(inputFields.get("Radius (m)").getText());
            } else if (currentBody instanceof ThinRing) {
                ThinRing body = (ThinRing) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.radius = Double.parseDouble(inputFields.get("Radius (m)").getText());
            } else if (currentBody instanceof AnnularDisk) {
                AnnularDisk body = (AnnularDisk) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.innerR = Double.parseDouble(inputFields.get("Inner Radius (m)").getText());
                body.outerR = Double.parseDouble(inputFields.get("Outer Radius (m)").getText());
            } else if (currentBody instanceof Quadrilateral) {
                Quadrilateral body = (Quadrilateral) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.width = Double.parseDouble(inputFields.get("Width (m)").getText());
                body.height = Double.parseDouble(inputFields.get("Height (m)").getText());
            } else if (currentBody instanceof SolidCylinder) {
                SolidCylinder body = (SolidCylinder) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.radius = Double.parseDouble(inputFields.get("Radius (m)").getText());
                body.height = Double.parseDouble(inputFields.get("Height (m)").getText());
            } else if (currentBody instanceof HollowCylinder) {
                HollowCylinder body = (HollowCylinder) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.innerR = Double.parseDouble(inputFields.get("Inner Radius (m)").getText());
                body.outerR = Double.parseDouble(inputFields.get("Outer Radius (m)").getText());
                body.height = Double.parseDouble(inputFields.get("Height (m)").getText());
            } else if (currentBody instanceof HollowSphere) {
                HollowSphere body = (HollowSphere) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.innerR = Double.parseDouble(inputFields.get("Inner Radius (m)").getText());
                body.outerR = Double.parseDouble(inputFields.get("Outer Radius (m)").getText());
            } else if (currentBody instanceof ThinTriangle) {
                ThinTriangle body = (ThinTriangle) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.base = Double.parseDouble(inputFields.get("Base (m)").getText());
                body.height = Double.parseDouble(inputFields.get("Height (m)").getText());
            } else if (currentBody instanceof SolidPyramid) {
                SolidPyramid body = (SolidPyramid) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.base = Double.parseDouble(inputFields.get("Base Side (m)").getText());
                body.height = Double.parseDouble(inputFields.get("Height (m)").getText());
            } else if (currentBody instanceof HollowPyramid) {
                HollowPyramid body = (HollowPyramid) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.base = Double.parseDouble(inputFields.get("Base Side (m)").getText());
                body.height = Double.parseDouble(inputFields.get("Height (m)").getText());
            } else if (currentBody instanceof Trapezium) {
                Trapezium body = (Trapezium) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.top = Double.parseDouble(inputFields.get("Top Length (m)").getText());
                body.bottom = Double.parseDouble(inputFields.get("Bottom Length (m)").getText());
                body.height = Double.parseDouble(inputFields.get("Height (m)").getText());
            } else if (currentBody instanceof ThickWalledTube) {
                ThickWalledTube body = (ThickWalledTube) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.innerR = Double.parseDouble(inputFields.get("Inner Radius (r1, m)").getText());
                body.outerR = Double.parseDouble(inputFields.get("Outer Radius (r2, m)").getText());
                body.height = Double.parseDouble(inputFields.get("Length (h, m)").getText());
            } else if (currentBody instanceof HollowTetrahedron) {
                HollowTetrahedron body = (HollowTetrahedron) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.side = Double.parseDouble(inputFields.get("Side Length (m)").getText());
            } else if (currentBody instanceof SolidTetrahedron) {
                SolidTetrahedron body = (SolidTetrahedron) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.side = Double.parseDouble(inputFields.get("Side Length (m)").getText());
            } else if (currentBody instanceof SolidCone) {
                SolidCone body = (SolidCone) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.radius = Double.parseDouble(inputFields.get("Radius (m)").getText());
                body.height = Double.parseDouble(inputFields.get("Height (m)").getText());
            } else if (currentBody instanceof HollowCone) {
                HollowCone body = (HollowCone) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.radius = Double.parseDouble(inputFields.get("Radius (m)").getText());
                body.height = Double.parseDouble(inputFields.get("Height (m)").getText());
            } else if (currentBody instanceof Torus) {
                Torus body = (Torus) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.minorR = Double.parseDouble(inputFields.get("Minor Radius (a, m)").getText());
                body.majorR = Double.parseDouble(inputFields.get("Major Radius (b, m)").getText());
            } else if (currentBody instanceof SolidEllipsoid) {
                SolidEllipsoid body = (SolidEllipsoid) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.a = Double.parseDouble(inputFields.get("Semiaxis a (m)").getText());
                body.b = Double.parseDouble(inputFields.get("Semiaxis b (m)").getText());
                body.c = Double.parseDouble(inputFields.get("Semiaxis c (m)").getText());
            } else if (currentBody instanceof Cube) {
                Cube body = (Cube) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.side = Double.parseDouble(inputFields.get("Side Length (m)").getText());
            } else if (currentBody instanceof RectangularCuboid) {
                RectangularCuboid body = (RectangularCuboid) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.height = Double.parseDouble(inputFields.get("Height (h, m)").getText());
                body.width = Double.parseDouble(inputFields.get("Width (w, m)").getText());
                body.depth = Double.parseDouble(inputFields.get("Depth (d, m)").getText());
            } else if (currentBody instanceof DiagonalCuboid) {
                DiagonalCuboid body = (DiagonalCuboid) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.D = Double.parseDouble(inputFields.get("Height (D, m)").getText());
                body.W = Double.parseDouble(inputFields.get("Width (W, m)").getText());
                body.L = Double.parseDouble(inputFields.get("Length (L, m)").getText());
            } else if (currentBody instanceof TiltedCuboid) {
                TiltedCuboid body = (TiltedCuboid) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.d = Double.parseDouble(inputFields.get("Depth (d, m)").getText());
                body.w = Double.parseDouble(inputFields.get("Width (w, m)").getText());
                body.l = Double.parseDouble(inputFields.get("Length (l, m)").getText());
            } else if (currentBody instanceof IsoscelesTriangle) {
                IsoscelesTriangle body = (IsoscelesTriangle) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.L = Double.parseDouble(inputFields.get("Common Side Length (L, m)").getText());
                body.beta = Double.parseDouble(inputFields.get("Vertex Half-Angle (β, degrees)").getText()) * Math.PI / 180.0;
            } else if (currentBody instanceof Octahedron) {
                Octahedron body = (Octahedron) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.side = Double.parseDouble(inputFields.get("Side Length (s, m)").getText());
            } else if (currentBody instanceof Dodecahedron) {
                Dodecahedron body = (Dodecahedron) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.side = Double.parseDouble(inputFields.get("Side Length (s, m)").getText());
            } else if (currentBody instanceof Icosahedron) {
                Icosahedron body = (Icosahedron) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.side = Double.parseDouble(inputFields.get("Side Length (s, m)").getText());
            } else if (currentBody instanceof SphericalShell) {
                SphericalShell body = (SphericalShell) currentBody;
                body.mass = Double.parseDouble(inputFields.get("Mass (kg)").getText());
                body.r1 = Double.parseDouble(inputFields.get("Inner Radius (r1, m)").getText());
                body.r2 = Double.parseDouble(inputFields.get("Outer Radius (r2, m)").getText());
            }

            int axis = Integer.parseInt(((String) axisComboBox.getSelectedItem()).split("\\.")[0]);
            double mi = currentBody.calculateMI(axis);
            if (mi == 0) {
                resultLabel.setText("Moment of Inertia: Invalid axis!");
            } else {
                resultLabel.setText("Moment of Inertia: " + String.format("%.4f", mi) + " kg·m²");
            }
        } catch (NumberFormatException | NullPointerException e) {
            resultLabel.setText("Moment of Inertia: Invalid input!");
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            MomentOfInertiaGUI gui = new MomentOfInertiaGUI();
            gui.setVisible(true);
        });
    }
}