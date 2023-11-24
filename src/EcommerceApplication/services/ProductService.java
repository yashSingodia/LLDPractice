package EcommerceApplication.services;

import EcommerceApplication.exceptions.ProductNotFoundException;
import EcommerceApplication.models.Product;

import java.util.Map;

public interface ProductService {
    void addProduct(Product product);

    Product getProduct(String productId) throws ProductNotFoundException;

    void updateProductsInInventory(Map<String, Integer> cartItems);

    boolean checkSufficientInventoryForProduct(int orderedQuantity, String productId);
}
