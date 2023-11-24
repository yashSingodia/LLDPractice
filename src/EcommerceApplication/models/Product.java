package EcommerceApplication.models;

import EcommerceApplication.util.RandomIdGeneratorUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private final String productId;
    private final String productName;
    private Integer quantity;
    private double price;

    public Product(String productName, Integer quantity, double price) {
        this.productId = RandomIdGeneratorUtil.generateId();
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public Product(String productId, String productName, Integer quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}
