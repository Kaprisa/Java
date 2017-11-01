package mathematics;

public class Expression {
    private String expression;
    private double value;

    public Expression(String expression) {
        setExpression(expression);
    }

    public double getValue() {
        return value;
    }

    private void findValue(String exp) {
        this.value = Calculator.calc(exp);
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
        findValue(expression);
    }

    @Override
    public String toString() {
        return "Expression{" +
                "expression='" + expression + '\'' +
                ", value=" + value +
                '}';
    }
}
