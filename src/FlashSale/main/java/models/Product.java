package FlashSale.main.java.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
}

