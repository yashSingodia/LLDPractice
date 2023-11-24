package EcommerceApplication.services.impl;

import EcommerceApplication.exceptions.ProductNotFoundException;
import EcommerceApplication.models.Cart;
import EcommerceApplication.services.CartService;
import EcommerceApplication.services.ProductService;

import java.util.Map;

public class CartServiceImpl implements CartService {

    private final Cart cart;
    private final ProductService productService;
    public CartServiceImpl(Cart cart, ProductService productService) {
        this.cart = cart;
        this.productService = productService;
    }

    @Override
    public void addItemsToCart(String productCategoryId, int count) {
        Map<String, Integer> cartItems = cart.getCartItems();
        int priceOfProduct = 0;
        if (cartItems.containsKey(productCategoryId)) {
            int productCount = cartItems.get(productCategoryId);
            cartItems.put(productCategoryId, productCount + count);

            try {
                priceOfProduct = (int) productService.getProduct(productCategoryId).getPrice();
            } catch (ProductNotFoundException e) {
                throw new RuntimeException(e);
            }
            cart.setTotalAmount(cart.getTotalAmount() + count * priceOfProduct);

        } else {

            cartItems.put(productCategoryId, count);
            try {
                priceOfProduct = (int) productService.getProduct(productCategoryId).getPrice();
            } catch (ProductNotFoundException e) {
                throw new RuntimeException(e);
            }
            cart.setTotalAmount(cart.getTotalAmount() + count * priceOfProduct);
        }
        System.out.println("Items added successfully in cart." );
    }

    @Override
    public void removeItemsFromCart(String productCategoryId, int count) throws ProductNotFoundException {
        // remove items from cart
        Map<String, Integer> cartItems = cart.getCartItems();
        if (cartItems.containsKey(productCategoryId)) {
            int productCount = cartItems.get(productCategoryId);

            if (productCount - count == 0) {
                cartItems.remove(productCategoryId);
//                cart.setTotalAmount(cart.getTotalAmount() - );
            } else {
                cartItems.put(productCategoryId, productCount - count);
            }
        } else {
            throw new ProductNotFoundException("");
        }
    }

    @Override
    public void clearCart() {
        cart.clearCart();
    }

    @Override
    public Map<String, Integer> getCartItems() {
        return cart.getCartItems();
    }
}