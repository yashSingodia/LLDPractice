package VendingMachine.state.impl;

import VendingMachine.VendingMachine;
import VendingMachine.Coin;
import VendingMachine.Item;
import VendingMachine.state.State;

import java.util.List;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Vending Machine is in Selection State. ");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {
        throw new RuntimeException();
    }

    @Override
    public int getChange(int returnMoney) {
        System.out.println("Returned the change in the coin dispense tray " + returnMoney);
        return returnMoney;
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item) {
        throw new RuntimeException();
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) {
        System.out.println("Returning full money back to the coin dispense tray.");
        vendingMachine.setState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) {
        throw new RuntimeException();
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) {
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        int paidByUser = 0;

        for (Coin coin : vendingMachine.getCoinList()) {
            paidByUser += coin.getValue();
        }

        if (paidByUser < item.getPrice()) {
            System.out.println("Insufficient Amount");
            refundFullMoney(vendingMachine);
            throw new RuntimeException();
        } else if (paidByUser >= item.getPrice()) {
            if (paidByUser > item.getPrice()) {
                getChange(paidByUser - item.getPrice());
            }
//            vendingMachine.setState(new DispenseState());
        }

    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) {
        throw new RuntimeException();
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        throw new RuntimeException();
    }
}
