package EcommerceApplication.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@ToString
public class Cart {
    private Map<String, Integer> categoryVsCountMap;
    private Integer totalAmount;

    public Cart() {
        this.totalAmount = 0;
        categoryVsCountMap = new HashMap<>();
    }
    public Map<String, Integer> getCartItems() {
        return categoryVsCountMap;
    }
    public void clearCart() {
        categoryVsCountMap = new HashMap<>();
    }
}
