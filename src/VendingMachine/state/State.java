package VendingMachine.state;

import VendingMachine.VendingMachine;
import VendingMachine.Coin;
import VendingMachine.Item;

import java.util.List;

public interface State {
    public void clickOnInsertCoinButton(VendingMachine vendingMachine);

    public void insertCoin(VendingMachine vendingMachine, Coin coin);

    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine);

    public void chooseProduct(VendingMachine vendingMachine, int codeNumber);

    public int getChange(int returnMoney);

    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber);

    public List<Coin> refundFullMoney(VendingMachine vendingMachine);

    public void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item);
}
