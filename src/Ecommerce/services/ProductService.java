package Ecommerce.services;

import Ecommerce.models.Product;

public interface ProductService {
    void addProduct(Product product);

    Product getProduct(String productId);

    boolean checkInventory(int orderedQuantity, String productId);
}
