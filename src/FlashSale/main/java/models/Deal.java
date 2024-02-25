package FlashSale.main.java.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Deal {
    private String dealId;
    private String productId;
    private double price;
    private int quantity;
    private DealStatus dealStatus;
    private long endTimeStamp;
}
