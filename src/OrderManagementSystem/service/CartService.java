package OrderManagementSystem.service;

import java.util.Map;

public interface CartService {
    void addItemsToCart(String productCategoryId, int count);
    void removeItemsFromCart(String productCategoryId, int count);
    void clearCart();
    Map<String, Integer> getCartItems();
}
