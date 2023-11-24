package OrderManagementSystem;

import OrderManagementSystem.model.Cart;
import OrderManagementSystem.model.ProductCategory;
import OrderManagementSystem.model.User;
import OrderManagementSystem.model.Warehouse;
import OrderManagementSystem.service.CartService;
import OrderManagementSystem.service.OrderService;
import OrderManagementSystem.service.UserService;
import OrderManagementSystem.service.WarehouseService;

public class ProductDeliverySystem {
    private final UserService userService;
    private final WarehouseService warehouseService;
    private final OrderService orderService;
    private final CartService cartService;

    public ProductDeliverySystem(UserService userService, WarehouseService warehouseService, OrderService orderService, CartService cartService) {
        this.userService = userService;
        this.warehouseService = warehouseService;
        this.orderService = orderService;
        this.cartService = cartService;
    }

    public User getUser(String userId) {
        return userService.getUser(userId);
    }

    public Warehouse getWarehouse() {
        return warehouseService.selectWarehouse();
    }

    public void addItemsToCart(ProductCategory productCategory, int count) {
        cartService.addItemsToCart(productCategory.getId(), count);
    }


}
