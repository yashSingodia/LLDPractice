package EcommerceApplication.exceptions;

public class UserNotAuthenticatedException extends EcommerceException{
    public UserNotAuthenticatedException(String message) {
        super(message);
    }
}
