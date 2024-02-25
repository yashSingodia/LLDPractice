package OrderManagementSystem.service.impl;

import OrderManagementSystem.model.Cart;
import OrderManagementSystem.service.CartService;

import java.util.Map;

public class CartServiceImpl implements CartService {

    // instead of having a cart object here, as we would have to create multiple objects of cartServiceImpl for each user
    // take userId as input and fetch cart from the user using userService

    private final Cart cart;

    public CartServiceImpl(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void addItemsToCart(String productCategoryId, int count) {
        Map<String, Integer> cartItems = cart.getCart();

        if (cartItems.containsKey(productCategoryId)) {
            int productCount = cartItems.get(productCategoryId);
            cart.getCart().put(productCategoryId, productCount + count);
        } else {
            cart.getCart().put(productCategoryId, count);
        }

    }

    @Override
    public void removeItemsFromCart(String productCategoryId, int count) {

    }

    @Override
    public void clearCart() {
        cart.clearCart();
    }

    @Override
    public Map<String, Integer> getCartItems() {
        return cart.getCart();
    }
}
