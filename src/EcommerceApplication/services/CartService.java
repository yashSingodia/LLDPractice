package EcommerceApplication.services;

import EcommerceApplication.exceptions.ProductNotFoundException;

import java.util.Map;

public interface CartService {
    void addItemsToCart(String productId, int count);
    void removeItemsFromCart(String productId, int count) throws ProductNotFoundException;
    void clearCart();
    Map<String, Integer> getCartItems();
}
