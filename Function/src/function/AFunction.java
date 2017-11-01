package function;

import mathematics.Expression;

public abstract class AFunction {
    protected String formula;
    protected final String xName;
    protected double x = 0;

    private Expression expression;

    //public Grap

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        changeExpression();
    }

    public AFunction(String formula, String argument) {
        this.xName = argument;
        this.formula = formula.toLowerCase();
        this.expression = new Expression(this.findMathematicalExpression());
    }

    public AFunction(String formula) {
        this(formula, "x");
    }

    public double getValue() {
        return this.expression.getValue();
    }

    public String getxName() {
        return xName;
    }

    @Override
    public String toString() {
        return "Function{" +
                "formula='" + formula + '\'' +
                ", " + xName + "=" + x +
                '}';
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    protected abstract String findMathematicalExpression();

    public String getExpression() {
        return this.expression.getExpression();
    }

    protected void changeExpression() {
        this.expression.setExpression(findMathematicalExpression());
    }

    public double integrate(double a, double b) {
        int n = 100000;
        double result = 0;
        double h = (b - a) / n;
        for(int i = 0; i < n; i++) {
            this.setX(a + h * (i + 0.5));
            result += this.getValue();
        }
        return result*h;
    }

    public String getFormula() {
        return formula;
    }

    public double findMax(double a, double b) {
        double res = 0, curValue;
        this.setX(a);
        while(this.getX() <= b ) {
            this.setX(this.getX() + 0.1);
            curValue = this.getValue();
            System.out.println(curValue);
            if (curValue > res) res = curValue;
        }
        return res;
    }

    public double findMin(double a, double b) {
        double res, curValue;
        this.setX(a);
        res = this.getValue();
        while(this.getX() <= b ) {
            this.setX(this.getX() + 1/10000);
            curValue = this.getValue();
            if (curValue < res) res = curValue;
        }
        return res;
    }

    //    public double differentiate(double a, double b) {
//        int n = 100;
//        double prevValue;
//        double result = 0;
//        double h = (b - a) / n;
//        this.setX(a);
//        for(int i = 1; i < n; i++) {
//            prevValue = this.getValue();
//            //System.out.println(prevValue);
//            this.setX(a + h * i);
//            System.out.println(this.getValue() - prevValue);
//            result += (this.getValue() - prevValue) / h;
//            //System.out.println(result);
//        }
//        return result;
//    }

}
