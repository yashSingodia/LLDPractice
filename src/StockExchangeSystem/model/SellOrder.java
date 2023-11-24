package StockExchangeSystem.model;

import java.time.LocalTime;

public class SellOrder extends Order{
    public SellOrder(String orderId, String stockName, Double price, int quantity, LocalTime localTime) {
        super(orderId, stockName, price, quantity, localTime);
    }
}
