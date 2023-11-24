package EcommerceApplication.services.impl;

import EcommerceApplication.exceptions.ProductNotFoundException;
import EcommerceApplication.models.Product;
import EcommerceApplication.repository.ProductRepository;
import EcommerceApplication.services.ProductService;

import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public Product getProduct(String productId) throws ProductNotFoundException {
        Product product = null;
        try {
            product = productRepository.getProduct(productId);
            return product;
        } catch (ProductNotFoundException e) {
            System.out.println("Product for this id is not found, kindly check");
            throw e;
        }
    }

    @Override
    public void updateProductsInInventory(Map<String, Integer> cartItems) {
        productRepository.updateProductQuantity(cartItems);
    }

    @Override
    public boolean checkSufficientInventoryForProduct(int orderedQuantity, String productId) {
        Product product = null;
        try {
            product = productRepository.getProduct(productId);
        } catch (ProductNotFoundException e) {
            System.out.println("Product inventory is not present");
            throw new RuntimeException(e);
        }
        if (product.getQuantity() >= orderedQuantity) {
            return true;
        } else {
            return false;
        }
    }
}
