package Ecommerce.models;

import Ecommerce.util.RandomIdGeneratorUtil;

public class Product {
    private final String productId;
    private final String productName;
    private int quantity;

    public Product(String productName, int quantity, Address address) {
        this.productId = RandomIdGeneratorUtil.generateId();
        this.productName = productName;
        this.quantity = quantity;
        this.address = address;
    }

    private final Address address;

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Address getAddress() {
        return address;
    }
}
