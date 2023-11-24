package LibraryManagementSystem.exceptions;

public class BookAlreadyReservedException extends LibraryManagementException{
    public BookAlreadyReservedException(String message) {
        super(message);
    }
}
