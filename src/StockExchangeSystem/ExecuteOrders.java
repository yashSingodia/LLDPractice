package StockExchangeSystem;

public class ExecuteOrders {
    public void executeOrder(String buyOrderId, Double sellingPrice, int quantity, String sellerOrderID) {
        System.out.println(buyOrderId + " " + sellingPrice + " " + quantity + " " + sellerOrderID);
    }
}
