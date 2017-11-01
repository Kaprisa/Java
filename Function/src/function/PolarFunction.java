package function;

public class PolarFunction extends Function {

    private final String angleName;
    private double angle = 0;

    public PolarFunction(String formula, String radius, String angle) {
        super(formula, radius);
        this.angleName = angle;
    }
    public  PolarFunction(String formula) {
        this(formula, "x", "y");
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
        this.changeExpression();
    }

    public void setRadius(double radius) {
        super.setX(radius);
    }

    public double getRadius() {
        return super.getX();
    }

    @Override
    protected String findMathematicalExpression() {
        return super.findMathematicalExpression().replaceAll(angleName, String.format("%.2f", angle));
    }

    @Override
    public String toString() {
        return "PolarFunction{ " +
                "formula='" + formula + '\'' +
                ", " + xName + " = " + x +
                ", " + angleName + " = " + angle +
                " }";
    }
}
