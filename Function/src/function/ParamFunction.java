package function;

public class ParamFunction extends Function {

    private final String yName;
    private double y = 0;

    public ParamFunction(String formula, String argument1, String argument2) {
        super(formula, argument1);
        this.yName = argument2;
    }
    public  ParamFunction(String formula) {
        this(formula, "x", "y");
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        this.changeExpression();
    }

    @Override
    protected String findMathematicalExpression() {
        return super.findMathematicalExpression().replaceAll(yName, String.format("%.2f", y));
    }

    @Override
    public String toString() {
        return "ParamFunction{ " +
                "formula='" + formula + '\'' +
                ", " + xName + " = " + x +
                ", " + yName + " = " + y +
                " }";
    }
}
