package shop;
// Доделать с explicit implicit
import economics.Expenses;
import economics.Profit;
import exceptions.BuyException;

public abstract class Shop {
    private final String address;
    private final String name;
    private final int square;
    private int Q;

    private Expenses expenses;

    private Profit profit;

    private void addProceed(int proceed) {
        this.profit.addProceed(proceed);
    }

    public void addExpenses(int FC, int VC) {
        this.expenses.addFC(FC);
        this.expenses.addVC(VC);
        this.profit.addExplicitExpenses(FC + VC);
    }

    public void addExpenses(int FC, int VC, int implicit) {
        addExpenses(FC, VC);
        this.profit.addImplicitExpenses(implicit);
    }

    public void addQ() {
        this.addQ(1);
    }

    public void addQ(int Q) {
        this.Q += Q;
        this.expenses.setQ(this.Q);
    }

    public String getExpensesInfo() {
        return this.expenses.toString();
    }


    public Shop(String name, String address, int square) {
        this.name = name;
        this.address = address;
        this.square = square;
        this.expenses = new Expenses(0, 0, 0);
        this.profit = new Profit(0, 0, 0);
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getSquare() {
        return square;
    }

    public String getProfitInfo() {
        return profit.toString();
    }

    protected void check(int money, int price) {
        int moneyDifference = money - price;
        if (moneyDifference < 0) {
            throw new BuyException("У вас недостаточно денег, нужно еще " + ( - moneyDifference ) + "\n");
        } else {
            this.addProceed(price);
            System.out.println( "Ваша покупка успешно оплачена! " +
                                "\n Ваша сдача " + moneyDifference +
                                "\n Ждем вас снова!\n");
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", square=" + square +
                ", Q=" + Q +
                ", expenses=" + expenses +
                ", profit=" + profit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (square != shop.square) return false;
        if (Q != shop.Q) return false;
        if (address != null ? !address.equals(shop.address) : shop.address != null) return false;
        if (name != null ? !name.equals(shop.name) : shop.name != null) return false;
        if (expenses != null ? !expenses.equals(shop.expenses) : shop.expenses != null) return false;
        return profit != null ? profit.equals(shop.profit) : shop.profit == null;
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + square;
        result = 31 * result + Q;
        result = 31 * result + (expenses != null ? expenses.hashCode() : 0);
        result = 31 * result + (profit != null ? profit.hashCode() : 0);
        return result;
    }
}
