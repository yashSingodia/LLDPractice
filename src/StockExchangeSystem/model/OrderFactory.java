package StockExchangeSystem.model;

import java.time.LocalTime;

public class OrderFactory {
    public static Order getOrder(OrderType orderType, String orderId, String stockName, Double price, int quantity, LocalTime localTime) {
        if (orderType == OrderType.BUY_ORDER) {
            return new BuyOrder(orderId, stockName, price, quantity, localTime);
        } else if(orderType == OrderType.SELL_ORDER){
            return new SellOrder(orderId, stockName, price, quantity, localTime);
        }
        return null;
    }
}
