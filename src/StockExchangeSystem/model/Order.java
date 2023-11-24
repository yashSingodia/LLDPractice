package StockExchangeSystem.model;

import java.time.LocalTime;

public class Order {
    private final String orderId;
    private final String stockName;
    private Double price;
    private int quantity;
    private final LocalTime localTime;

    public Order(String orderId, String stockName, Double price, int quantity, LocalTime localTime) {
        this.orderId = orderId;
        this.stockName = stockName;
        this.price = price;
        this.quantity = quantity;
        this.localTime = localTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getStockName() {
        return stockName;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }
}
