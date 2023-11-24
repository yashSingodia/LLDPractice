package VendingMachine;

public class ItemShelf {
    private Item item;
    private int codeNumber;

    private boolean soldOut;


    public ItemShelf(Item item, int codeNumber) {
        this.item = item;
        this.codeNumber = codeNumber;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCodeNumber() {
        return codeNumber;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }


    public void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }
}
