package function;
//import mathematics.Expression;

public class Function extends AFunction {


//    protected String formula;
//    protected final String xName;
//    protected double x = 0;
//
//    private Expression expression;
//
//    //public Grap
//
//    public double getX() {
//        return x;
//    }
//
//    public void setX(double x) {
//        this.x = x;
//        changeExpression();
//    }
//
    public Function(String formula, String argument) {
        super(formula, argument);
        //this.xName = argument;
        //this.formula = formula.toLowerCase();
        //this.expression = new Expression(this.findMathematicalExpression());
    }

    public Function(String formula) {
        this(formula, "x");
    }

//    public double getValue() {
//        return this.expression.getValue();
//    }
//
//    public String getxName() {
//        return xName;
//    }
//
//    @Override
//    public String toString() {
//        return "Function{" +
//                "formula='" + formula + '\'' +
//                ", " + xName + "=" + x +
//                '}';
//    }
//
//    public void setFormula(String formula) {
//        this.formula = formula;
//    }
//
    protected String findMathematicalExpression() {
        return this.formula.replaceAll(xName, String.format("%.2f", this.x));
    }


//
//    public String getExpression() {
//        return this.expression.getExpression();
//    }
//
//    protected void changeExpression() {
//        this.expression.setExpression(findMathematicalExpression());
//    }


}
