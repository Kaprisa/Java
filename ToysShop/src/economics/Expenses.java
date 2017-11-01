package economics;

public class Expenses {
    private int Q; //Объем производства
    private int TC, FC, VC, ATC, AFC, AVC;

    public Expenses(int q, int FC, int VC) {
        Q = q;
        this.FC = FC; //Постоянные затраты
        this.VC = VC; //Общие текущие затраты
        calculateCosts();
    }

    public int getQ() {
        return Q;
    }

    public void setQ(int q) {
        Q = q;
        calculateCosts();
    }

    public int getTC() {
        return TC;
    }

    public void setVC(int VС) {
        this.VC = VС;
        calculateCosts();
    }

    public int getFC() {
        return FC;
    }

    public void setFС(int FC) {
        this.FC = FC;
        calculateCosts();
    }

    public int getVC() {
        return VC;
    }

    public int getMC(int Q, int TC) {
        return (this.TC - TC)/(this.Q - Q);
    }

    public int getMC(Expenses another) {
        return (this.TC - another.TC)/(this.Q - another.Q);//Предельные затраты
    }

    public int getMC(int TC) {
        return this.TC - TC; //Предельные затраты при приросте выпуска на 1
    }

    public int getATC() {
        return ATC;
    }

    public int getAFC() {
        return AFC;
    }

    public int getAVC() {
        return AVC;
    }

    public void addVC(int money) {
        setVC(VC + money);
        calculateCosts();
    }

    public void addFC(int money) {
        setFС(FC + money);
        calculateCosts();
    }


    private void calculateCosts() {
        TC = VC + FC; //Переменные затраты
        if (Q > 0) {
            ATC = TC / Q;
            AFC = FC / Q;
            AVC = VC / Q;
        } else {
            ATC = 0;
            AFC = 0;
            AVC = 0;
        }
    }

    @Override
    public String toString() {
        return "Затраты на объём производства " + Q +
                "\n\t Суммарные " + TC +
                "\n\t Постоянные " + FC +
                "\n\t Переменные " + VC +
                "\n\t Средние суммарные " + ATC +
                "\n\t Средние постоянные " + AFC +
                "\n\t Средние переменные " + AVC + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expenses expenses = (Expenses) o;

        if (Q != expenses.Q) return false;
        if (FC != expenses.FC) return false;
        if (VC != expenses.VC) return false;
        return Q == expenses.Q;
    }

    @Override
    public int hashCode() {
        int result = Q;
        result = 31 * result + FC;
        result = 31 * result + VC;
        return result;
    }
}
