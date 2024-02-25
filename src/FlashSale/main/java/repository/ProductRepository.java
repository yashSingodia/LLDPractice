package FlashSale.main.java.repository;

import exceptions.ProductNotFoundException;
import models.Product;

import java.util.HashMap;

public class ProductRepository {
    private final HashMap<String, Product> productsMap;

    public ProductRepository() {
        this.productsMap = new HashMap<>();
    }

    public void addProducts(String productId, Product product) {
        productsMap.put(productId, product);
    }

    public Product getProduct(String productId) throws ProductNotFoundException {
        if (!productsMap.containsKey(productId)) {
            throw new ProductNotFoundException(String.format("Product %s not found", productId));
        }
        return productsMap.get(productId);
    }

    public void updateQuantities(String productId, int updatedQuantities) throws ProductNotFoundException {
        Product product = getProduct(productId);
        product.setQuantity(updatedQuantities);
        productsMap.put(productId, product);
    }

    public void removeProducts(String productId) {
        // check if exists
        productsMap.remove(productId);
    }

    public void decreaseQuantity(String productId) throws ProductNotFoundException {
        Product product = getProduct(productId);
        updateQuantities(productId, product.getQuantity() - 1);
    }
}
