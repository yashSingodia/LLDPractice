package OrderManagementSystem.strategy;

import OrderManagementSystem.model.Warehouse;

import java.util.List;

public class DefaultWarehouseSelectionStrategy implements WarehouseSelectionStrategy{
    @Override
    public Warehouse pickWarehouse(List<Warehouse> warehouseList) {
        // return warehouse based on certain rules
        return warehouseList.get(0);
    }
}
