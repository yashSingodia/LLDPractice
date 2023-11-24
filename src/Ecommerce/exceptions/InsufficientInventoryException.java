package Ecommerce.exceptions;

public class InsufficientInventoryException extends EcommerceException{
    public InsufficientInventoryException(String message) {
        super(message);
    }
}
