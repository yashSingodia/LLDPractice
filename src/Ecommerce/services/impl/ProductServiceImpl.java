package Ecommerce.services.impl;

import Ecommerce.exceptions.InsufficientInventoryException;
import Ecommerce.models.Buyer;
import Ecommerce.models.Product;
import Ecommerce.repository.ProductRepository;
import Ecommerce.services.ProductService;

import java.util.HashMap;

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
    public Product getProduct(String productId) {
        return productRepository.getProduct(productId);
    }

    @Override
    public boolean checkInventory(int orderedQuantity, String productId) {
        synchronized (this) {
            Product product = productRepository.getProduct(productId);
            if (product.getQuantity() >= orderedQuantity) {
                int remainingQuantity = product.getQuantity() - orderedQuantity;
                product.setQuantity(remainingQuantity);
                return true;
            } else {
                throw new InsufficientInventoryException("Inventory is insufficient");
            }

        }
    }
}
