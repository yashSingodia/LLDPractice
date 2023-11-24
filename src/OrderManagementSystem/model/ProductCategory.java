package OrderManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    private List<Product> products;
    private final String id;
    private final String name;

    public ProductCategory(String id, String name) {
        this.products = new ArrayList<>();
        this.id = id;
        this.name = name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }
}
