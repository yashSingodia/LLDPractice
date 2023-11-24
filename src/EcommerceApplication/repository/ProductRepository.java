package EcommerceApplication.repository;

import EcommerceApplication.exceptions.ProductNotFoundException;
import EcommerceApplication.models.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private HashMap<String, Product> productMap;

    public ProductRepository() {
        this.productMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (productMap.containsKey(product.getProductId())) {
            Product orginalProduct = productMap.get(product.getProductId());

            productMap.put(product.getProductId(), new Product(
                    orginalProduct.getProductId(),
                    orginalProduct.getProductName(),
                    orginalProduct.getQuantity() + product.getQuantity(),
                    orginalProduct.getPrice()));
        } else {
            productMap.put(product.getProductId(), product);
        }
        System.out.println("Product added successfully for name " + product.getProductName());
    }

    public Product getProduct(String productId) throws ProductNotFoundException {
        if (productMap.containsKey(productId)) {
            return productMap.get(productId);
        } else {
            throw new ProductNotFoundException("Product is not present in the inventory");
        }
    }

    public void updateProductQuantity(Map<String, Integer> cartItems) {
        // removing cartItems from products map
        for (Map.Entry entry : cartItems.entrySet()) {
            Product product = productMap.get(entry.getKey());

            // updating the remaining quantity of products
            int remainingQuantity = product.getQuantity() - (Integer) entry.getValue();
            if (remainingQuantity == 0) {
                productMap.remove(entry.getKey());
            } else {
                product.setQuantity(remainingQuantity);
            }
        }
    }
}
