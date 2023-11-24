package OrderManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final String id;
    private List<ProductCategory> productCategoryList;

    public Inventory(String id) {
        this.id = id;
        this.productCategoryList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }
}
