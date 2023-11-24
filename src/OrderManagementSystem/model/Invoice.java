package OrderManagementSystem.model;

public class Invoice {
    private double totalFinalPrice;
    private Order order;

    public Invoice(Order order) {
        this.totalFinalPrice = generateInvoice(order);
    }

    public double generateInvoice(Order order) {
        return 200;
    }

    public double getTotalFinalPrice() {
        return totalFinalPrice;
    }
}
