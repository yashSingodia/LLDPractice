package VendingMachine.state.impl;

import VendingMachine.VendingMachine;
import VendingMachine.Item;
import VendingMachine.Coin;
import VendingMachine.state.State;

import java.util.List;

public class DispenseState implements State {

    public DispenseState(VendingMachine vendingMachine, int codeNumber) {
        System.out.println("Vending Machine is in Dispensed State");
        dispenseProduct(vendingMachine, codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {

    }

    @Override
    public int getChange(int returnMoney) {
        return 0;
    }

    public void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item) {

    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) {
        return null;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) {
        System.out.println("Items are dispensed in the dispense tray");
        Item item = vendingMachine.getInventory().getItem(codeNumber);
//        vendingMachine.getInventory().updateSoldOutItem();
        vendingMachine.setState(new IdleState(vendingMachine));
        return item;
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) {

    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) {

    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {

    }
}
