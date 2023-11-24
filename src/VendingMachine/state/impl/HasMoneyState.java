package VendingMachine.state.impl;

import VendingMachine.VendingMachine;
import VendingMachine.state.State;
import VendingMachine.Item;
import VendingMachine.Coin;

import java.util.List;

public class HasMoneyState implements State {

    public HasMoneyState() {
        System.out.println("Vending machine is in HasMoneyState. ");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {
        throw new RuntimeException();
    }

    @Override
    public int getChange(int returnMoney) {
        return 0;
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item) {

    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) {
        return null;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) {
        return null;
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) {

    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) {
        vendingMachine.setState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Accepting coins. ");
        vendingMachine.getCoinList().add(coin);
    }
}
