package VendingMachine;

public enum CoinType {
    ONE_RUPEE(1),
    FIVE_RUPEE(5),
    TEN_RUPEE(10);
    int value;
    CoinType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
