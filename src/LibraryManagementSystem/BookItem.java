package LibraryManagementSystem;

import LibraryManagementSystem.exceptions.BookAlreadyReservedException;

import java.util.Date;

public class BookItem extends Book{
    private Date borrowedAt;

    private String bookId;
    private String memberId;
    private BookStatus bookStatus;
    private Date dueData;
    private int price;
    private Date dateOfPurchase;

    public boolean checkout(String memberId) {
        if (this.bookStatus.equals(BookStatus.RESERVED)) {
            throw new BookAlreadyReservedException("Book Already Reserved Exception");
        }
        this.setBookStatus(BookStatus.RESERVED);
        this.setMemberId(memberId);
        return true;
    }

    private void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    private void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookId() {
        return bookId;
    }


}
