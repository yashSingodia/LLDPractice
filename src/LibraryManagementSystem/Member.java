package LibraryManagementSystem;

import LibraryManagementSystem.exceptions.BookAlreadyReservedException;
import LibraryManagementSystem.exceptions.CheckoutException;
import LibraryManagementSystem.exceptions.LibraryManagementException;

import java.util.Objects;

public class Member extends Account {
    private int totalBooksCheckedOut;

    public boolean checkOutBookItem(BookItem bookItem) {
        if (this.totalBooksCheckedOut >= Constants.MAX_BOOKS_ISSUED_TO_USER) {
            throw new LibraryManagementException("Max Books already issued to the user");
        } else {

            BookReservation bookReservation = BookReservation.fetchBookReservationDetails(bookItem.getBookId());
            if (Objects.nonNull(bookReservation) && !Objects.equals(bookReservation.getMemberId(), this.getId())) {
                throw new BookAlreadyReservedException(
                        String.format("Book is already reserverd with member %s", bookReservation.getMemberId()));
            }
            boolean isCheckedout = bookItem.checkout(this.getId());

            if (!isCheckedout) {
                throw new CheckoutException(String.format("Error while checking out bookItem %s", bookItem));
            }

            this.incrememntBooksCheckedout();
            return true;
        }
    }

    private void incrememntBooksCheckedout() {
        this.totalBooksCheckedOut = this.totalBooksCheckedOut + 1;
    }
}
