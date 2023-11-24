package LibraryManagementSystem;

import java.util.Date;

public class BookReservation {
    private String memberId;
    private Date creationDate;


    private ReservationStatus reservationStatus;

    public static BookReservation fetchBookReservationDetails(String bookId) {
        return null;
    }

    public String getMemberId() {
        return memberId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

}
