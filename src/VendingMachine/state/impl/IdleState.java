package VendingMachine.state.impl;

import VendingMachine.VendingMachine;
import VendingMachine.state.State;
import VendingMachine.Item;
import VendingMachine.Coin;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState(VendingMachine vendingMachine) {
        System.out.println("Vending machine is in Idle State. ");
        vendingMachine.setCoinList(new ArrayList<>());
    }

    public IdleState() {
        System.out.println("Vending machine is in Idle State. ");

    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {
        System.out.println("Clicking on insert icon button");
        vendingMachine.setState(new HasMoneyState());
    }

    @Override
    public int getChange(int returnMoney) {
        throw new RuntimeException();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item) {
        throw new RuntimeException();
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) {
        throw new RuntimeException();
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) {
        throw new RuntimeException();
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) {
        throw new RuntimeException();
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) {
        throw new RuntimeException();
    }

    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        throw new RuntimeException();
    }
}
