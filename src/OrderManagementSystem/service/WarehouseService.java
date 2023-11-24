package OrderManagementSystem.service;

import OrderManagementSystem.model.Warehouse;
import OrderManagementSystem.strategy.WarehouseSelectionStrategy;

public interface WarehouseService {

    void addWarehouse(Warehouse warehouse);

    void removeWarehouse(Warehouse warehouse);

    Warehouse selectWarehouse();
}
