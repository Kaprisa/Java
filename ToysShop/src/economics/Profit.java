package economics;

import utils.Summator;

public class Profit {
    private int explicitExpenses, implicitExpenses, proceed;
    private int accountingProfit, economicProfite;


    public Profit(int explicitExpenses, int implicitExpenses, int proceed) {
        this.explicitExpenses = explicitExpenses;
        this.implicitExpenses = implicitExpenses;
        this.proceed = proceed;
    }

    public int getExplicitExpenses() {
        return explicitExpenses;
    }

    public void setExplicitExpenses(int explicitExpenses) {
        this.explicitExpenses = explicitExpenses;
    }

    public void setExplicitExpenses(int[] explicitExpensesArray) {
        this.explicitExpenses = Summator.count(explicitExpensesArray);
    }

    public int getProceed() {
        return proceed;
    }

    public void setProceed(int proceed) {
        this.proceed = proceed;
    }

    public int getAccountingProfit() {
        return accountingProfit;
    }

    public int getEconomicProfite() {
        return economicProfite;
    }

    private void calculateProfits() {
        accountingProfit = proceed - explicitExpenses;
        economicProfite = accountingProfit - implicitExpenses;
    }

    public void addProceed(int proceed) {
        setProceed(this.proceed + proceed);
        calculateProfits();
    }

    public boolean isProfitableBusiness() {
        return economicProfite > 0;
    }

    public void addExplicitExpenses(int expenses) {
        setExplicitExpenses(this.explicitExpenses + expenses);
        calculateProfits();
    }

    public void setImplicitExpenses(int expenses) {
        this.implicitExpenses = expenses;
        calculateProfits();
    }
    public void setImplicitExpenses(int[] implicitExpensesArray) {
        this.implicitExpenses = Summator.count(implicitExpensesArray);
        calculateProfits();
    }
    public void addImplicitExpenses(int expenses) {
        setImplicitExpenses(this.implicitExpenses + expenses);
        calculateProfits();
    }

    @Override
    public String toString() {
        return
                "Явные издержки " + explicitExpenses +
                "\nНеявные издержки " + implicitExpenses +
                "\nВаша прибыль " + proceed +
                "\nБухгалтерская прибыль составила " + accountingProfit +
                "\nЭкономическая прибыль " + economicProfite +
                "\nВаш бизнес " + (isProfitableBusiness() ? "выгоден" : "не выгоден.\n");
    }

    public String getImplicitExpensesInfo() {
        return
                "Неявные издержки - стоимость упущенной возможности. " +
                "Деньги, которые вы бы могли получить, если бы вложили свои ресурсы во что-то другое," +
                " например сдали помещение в аренду или работали по найму.\n";
    }

    public String getExplicitExpensesInfo() {
        return "Явные издержки - выплаты, которые вы делаете поставщикам ресурсов(земли, труда, капитала). " +
                "Например заработная плату наёмным работникам, плата за сырьё и материалы, аренда и так далее.\n";
    }
}
