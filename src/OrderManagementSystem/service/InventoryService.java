package OrderManagementSystem.service;

import OrderManagementSystem.model.ProductCategory;

import java.util.Map;

public interface InventoryService {
    void addItemsToInventory(ProductCategory categoryId, int count);
    void removeItemsFromInventory(ProductCategory categoryId, int count);
}
