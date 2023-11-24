package StockExchangeSystem.service;

import StockExchangeSystem.ExecuteOrders;
import StockExchangeSystem.StockExchangeDAO;
import StockExchangeSystem.model.BuyOrder;
import StockExchangeSystem.model.OrderFactory;
import StockExchangeSystem.model.OrderType;
import StockExchangeSystem.model.SellOrder;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class StockExchangeServiceImpl implements StockExchangeService{

    private final StockExchangeDAO stockExchangeDAO;
    private final ExecuteOrders executeOrders;

    public StockExchangeServiceImpl(StockExchangeDAO stockExchangeDAO, ExecuteOrders executeOrders) {
        this.stockExchangeDAO = stockExchangeDAO;
        this.executeOrders = executeOrders;
    }

    @Override
    public void addSellOrder(String orderId, String stockName, Double price, int quantity, LocalTime time) {
        SellOrder sellOrder = (SellOrder) OrderFactory.getOrder(OrderType.SELL_ORDER, orderId, stockName, price, quantity, time);
        stockExchangeDAO.addSellOrder(sellOrder);
    }

    @Override
    public void matchAndExecuteBuyOrder(String orderId, String stockName, Double price, int quantity, LocalTime time) {
        BuyOrder buyOrder = (BuyOrder) OrderFactory.getOrder(OrderType.BUY_ORDER, orderId, stockName, price, quantity, time);
        executeOrder(buyOrder);
    }

    private void executeOrder(BuyOrder buyOrder) {
        PriorityQueue<SellOrder> sellOrderPriorityQueue = stockExchangeDAO.getSellOrderPriorityQueue();
        List<SellOrder> sellOrderList = new ArrayList<>();

        while (!sellOrderPriorityQueue.isEmpty()) {
            SellOrder sell = sellOrderPriorityQueue.peek();
            if (sell.getPrice() > buyOrder.getPrice()) {
                break;
            } else {
                sellOrderList.add(0, sellOrderPriorityQueue.poll());
            }
        }

        // we have the list of higher value less than current buy
        int buyQuantity = buyOrder.getQuantity();

        for (SellOrder sell : sellOrderList) {
            if (sell.getQuantity() >= buyQuantity) {
                sell.setQuantity(sell.getQuantity() - buyOrder.getQuantity());
                executeOrders.executeOrder(buyOrder.getOrderId(), sell.getPrice(), buyQuantity, sell.getOrderId());
                break;
            } else {
                buyQuantity -= sell.getQuantity();
                executeOrders.executeOrder(buyOrder.getOrderId(), sell.getPrice(), sell.getQuantity(), sell.getOrderId());
                sell.setQuantity(-1);
            }
        }

        for (SellOrder sell : sellOrderList) {
            if (sell.getQuantity() == -1) {
                stockExchangeDAO.addSellOrder(sell);
            }
        }
    }
}
