package OrderManagementSystem.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String, Integer> categoryVsCountMap;

    public Cart() {
        categoryVsCountMap = new HashMap<>();
    }
    public Map<String, Integer> getCart() {
        return categoryVsCountMap;
    }
    public void clearCart() {
        categoryVsCountMap = new HashMap<>();
    }
}
