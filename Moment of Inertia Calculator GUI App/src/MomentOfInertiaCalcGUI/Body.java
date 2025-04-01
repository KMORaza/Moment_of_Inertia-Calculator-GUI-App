package MomentOfInertiaCalcGUI;
public abstract class Body {
    protected double mass;
    protected String name;
    public abstract double calculateMI(int axis);
    public abstract void getInput();
    public String getName() {
        return name;
    }
}