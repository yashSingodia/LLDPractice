package Ecommerce.exceptions;

public class ProductAlreadyPresentException extends EcommerceException{
    public ProductAlreadyPresentException(String message) {
        super(message);
    }
}
