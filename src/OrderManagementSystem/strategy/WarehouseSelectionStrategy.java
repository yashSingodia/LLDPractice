package OrderManagementSystem.strategy;

import OrderManagementSystem.model.Warehouse;

import java.util.List;

public interface WarehouseSelectionStrategy {
    Warehouse pickWarehouse(List<Warehouse> warehouseList);
}
