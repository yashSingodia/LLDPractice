package VendingMachine;

import VendingMachine.state.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State state;
    private List<Coin> coinList;

    private Inventory inventory;


    public VendingMachine(State state, Inventory inventory) {
        this.state = state;
        this.inventory = inventory;
        coinList = new ArrayList<>();
    }

    public Inventory getInventory() {
        return inventory;
    }
    public State getState() {
        return state;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
