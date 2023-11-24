package OrderManagementSystem.model;

public class Warehouse {
    private final Inventory inventory;
    private final Address address;

    public Warehouse(Inventory inventory, Address address) {
        this.inventory = inventory;
        this.address = address;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Address getAddress() {
        return address;
    }
}
