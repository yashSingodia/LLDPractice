package OrderManagementSystem.service.impl;

import OrderManagementSystem.model.Inventory;
import OrderManagementSystem.model.Product;
import OrderManagementSystem.model.ProductCategory;
import OrderManagementSystem.service.InventoryService;

import java.util.List;

public class InventoryServiceImpl implements InventoryService {

    private final Inventory inventory;

    public InventoryServiceImpl(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void addItemsToInventory(ProductCategory productCategory, int count) {
        boolean found = false;

        List<ProductCategory> existingProductCategory = inventory.getProductCategoryList();
        for (ProductCategory productCat : existingProductCategory) {
            if (productCategory.equals(productCategory)) {

                found = true;
                Product product = productCategory.getProducts().get(0);

                while (count > 0) {
                    productCategory.addProduct(product);
                    count--;
                }

            }
        }
        if (!found) {
            existingProductCategory.add(productCategory);
        }
    }

    @Override
    public void removeItemsFromInventory(ProductCategory categoryId, int count) {

    }
}
