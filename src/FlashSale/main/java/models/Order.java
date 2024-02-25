package FlashSale.main.java.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private String orderId;
    private String userId;
    private long timestamp;
    private double amount;
}
