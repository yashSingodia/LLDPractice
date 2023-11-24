package OrderManagementSystem.service.impl;

import OrderManagementSystem.model.Warehouse;
import OrderManagementSystem.service.WarehouseService;
import OrderManagementSystem.strategy.WarehouseSelectionStrategy;

import java.util.List;

public class WarehouseServiceImpl implements WarehouseService {
    private final List<Warehouse> warehouseList;
    private final WarehouseSelectionStrategy warehouseSelectionStrategy;

    public WarehouseServiceImpl(List<Warehouse> warehouseList, WarehouseSelectionStrategy warehouseSelectionStrategy) {
        this.warehouseList = warehouseList;
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
    }

    @Override
    public void addWarehouse(Warehouse warehouse) {
        warehouseList.add(warehouse);
    }

    @Override
    public void removeWarehouse(Warehouse warehouse) {
        warehouseList.remove(warehouse);
    }

    @Override
    public Warehouse selectWarehouse() {
        // strategy pattern used to find the correct strategy
        return warehouseSelectionStrategy.pickWarehouse(warehouseList);
    }
}
