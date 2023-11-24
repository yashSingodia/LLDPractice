package StockExchangeSystem;

import StockExchangeSystem.model.SellOrder;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class StockExchangeDAO {

    private PriorityQueue<SellOrder> sellOrderPriorityQueue = new PriorityQueue<>(new Comparator<SellOrder>() {
        @Override
        public int compare(SellOrder o1, SellOrder o2) {
            if (Objects.equals(o1.getPrice(), o2.getPrice())) {
                return o2.getQuantity() - o1.getQuantity();
            }
            return Double.compare(o1.getPrice(), o2.getPrice());
        }
    });

    public void addSellOrder(SellOrder sellOrder) {
        sellOrderPriorityQueue.add(sellOrder);
    }

    public PriorityQueue<SellOrder> getSellOrderPriorityQueue() {
        return sellOrderPriorityQueue;
    }
}
