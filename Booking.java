import java.util.Date;
public class Booking {

    private int bookingId;
    private String customerName;
    private int numberOfPlayers;
    private String bookingDate;

    public Booking() {
    }

    public Booking(int bookingId, String customerName, int numberOfPlayers, String bookingDate) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.numberOfPlayers = numberOfPlayers;
        this.bookingDate = bookingDate;
    }

    public int getBookingId() {

        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customerName='" + customerName + '\'' +
                ", numberOfPlayers=" + numberOfPlayers +
                ", bookingDate=" + bookingDate +
                '}';
    }
}

