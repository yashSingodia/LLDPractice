package StockExchangeSystem.service;

import java.time.LocalTime;

public interface StockExchangeService {
    void addSellOrder(String orderId, String stockName, Double price, int quantity, LocalTime time);

    void matchAndExecuteBuyOrder(String orderId, String stockName, Double price, int quantity, LocalTime time);
}
