public class Test {

    private int variable;
    private final int constant;
    public static void main(String[] args) {

    }

    public void addTests(ArrayList<Test> tests) {

    }

    public void addTest(Test test) {

    }

    public boolean isSuccessful(Test test){

    }

    public Test(int variable, int constant) {
        this.constant = constant;
        this.variable = variable;
    }

    public int getVariable() {
        return variable;
    }

    public void setVariable(int variable) {
        this.variable = variable;
    }

    public int getConstant() {
        return constant;
    }

    public void increaseVariable(int value) {
        this.variable += value;
    }
}

public abstract class Test2 {

    private int variable = 1;
    private final int constant = 2;
    private String str = "Hello";
    public static void main(String[] args) {

    }

    public abstract void addTests(ArrayList<Test> tests);

    public abstract void addTest(Test test);

    public boolean isSuccessful(Test test){

    }

    public Test(int variable, int constant) {
        this.constant = constant;
        this.variable = variable;
    }

    public abstract int getVariable()

    public abstract void setVariable(int variable)

    public int getConstant() {
        return constant;
    }

    public void increaseVariable(int value) {
        this.variable += value;
    }
}