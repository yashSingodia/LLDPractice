package VendingMachine;

public class Item {
    private final String id;
    private final String name;
    private int price;

    public Item(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
