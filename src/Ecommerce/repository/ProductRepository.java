package Ecommerce.repository;

import Ecommerce.exceptions.ProductAlreadyPresentException;
import Ecommerce.exceptions.ProductNotFoundException;
import Ecommerce.models.Product;

import java.util.HashMap;

public class ProductRepository {

    private HashMap<String, Product> productMap;

    public ProductRepository() {
        this.productMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (productMap.containsKey(product.getProductId())) {
            throw new ProductAlreadyPresentException("User is already Present");
        }
        productMap.put(product.getProductId(), product);
    }

    public Product getProduct(String productId) {
        if (productMap.containsKey(productId)) {
            return productMap.get(productId);
        } else {
            throw new ProductNotFoundException("Product is not present");
        }
    }
}
