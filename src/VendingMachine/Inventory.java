package VendingMachine;

import java.util.List;
import java.util.Objects;

public class Inventory {
    private List<ItemShelf> itemShelfList;

    public Inventory(List<ItemShelf> itemShelfList) {
        this.itemShelfList = itemShelfList;
    }

    public List<ItemShelf> getItemShelfList() {
        return itemShelfList;
    }

    public void setItemShelfList(List<ItemShelf> itemShelfList) {
        this.itemShelfList = itemShelfList;
    }

    public Item getItem(int codeNumber) {
        for (ItemShelf itemShelf : itemShelfList) {
            if (Objects.equals(itemShelf.getCodeNumber(), codeNumber)) {
                return itemShelf.getItem();
            }
        }
        return null;
    }
}
