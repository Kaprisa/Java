package economics;

public class Money {
    private int dollars;
    private int cents;

    public Money(int dollars, int cents) {
        if (dollars < 0 || cents < 0)
            throw new IllegalArgumentException("Negative dollars or cents");
        this.dollars = dollars;
        this.cents = cents;
    }

    public Money add(Money other) {
        int cents = this.cents + other.cents;
        return new Money(this.dollars + other.dollars + cents / 100, cents % 100);
    }
}

