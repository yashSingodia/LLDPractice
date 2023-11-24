package VendingMachine;

public class Coin {
    private CoinType coinType;

    public Coin(CoinType coinType) {
        this.coinType = coinType;
    }

    public int getValue() {
        return coinType.getValue();
    }
}
