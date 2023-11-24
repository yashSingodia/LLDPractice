package StockExchangeSystem.model;

import java.time.LocalTime;

public class BuyOrder extends Order{
    public BuyOrder(String orderId, String stockName, Double price, int quantity, LocalTime localTime) {
        super(orderId, stockName, price, quantity, localTime);
    }
}
