package TicketBookingSystem.model;

public class Seat {
    private final String seatId;
    private final int rowNo;
    private final int seatNo;

    public Seat(String seatId, int rowNo, int seatNo) {
        this.seatId = seatId;
        this.rowNo = rowNo;
        this.seatNo = seatNo;
    }

    public String getSeatId() {
        return seatId;
    }

    public int getRowNo() {
        return rowNo;
    }

    public int getSeatNo() {
        return seatNo;
    }
}
