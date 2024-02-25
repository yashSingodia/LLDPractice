package FlashSale.main.java.service;

import exceptions.ProductNotFoundException;
import models.Product;
import repository.ProductRepository;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(String productId, Product product) {
        productRepository.addProducts(productId, product);
    }
    public Product getProduct(String productId) throws ProductNotFoundException {
        return productRepository.getProduct(productId);
    }

    public void decreaseQuantity(String productId) throws ProductNotFoundException {
        productRepository.decreaseQuantity(productId);
    }
}
