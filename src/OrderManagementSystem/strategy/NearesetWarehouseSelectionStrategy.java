package OrderManagementSystem.strategy;

import OrderManagementSystem.model.Warehouse;

import java.util.List;

public class NearesetWarehouseSelectionStrategy implements WarehouseSelectionStrategy{

    @Override
    public Warehouse pickWarehouse(List<Warehouse> warehouseList) {
        // can be filtered based on address
        return warehouseList.get(0);
    }
}
