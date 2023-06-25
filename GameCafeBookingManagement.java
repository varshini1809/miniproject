import java.sql.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


class GameCafeBookingManagement {

    private final Connection connection;

    public GameCafeBookingManagement() throws Exception {

        // Create a connection to the database
        String url = "jdbc:mysql://localhost:3306/game_cafe_booking";
        String username = "root";
        String password = "root";
        connection = DriverManager.getConnection(url, username, password);
    }

    public void bookTable(String customerName, int numberOfPlayers, String bookingDate) throws SQLException {
        Statement statement = connection.createStatement();

        // Insert the booking into the database
        String sql = "INSERT INTO bookings VALUES (" + "'" + customerName + "'," + "'" + numberOfPlayers + "'," + "'" + bookingDate + "')";
        statement.executeUpdate(sql);

        System.out.println("Booking details:");
        System.out.println("Customer name: " + customerName);
        System.out.println("Number of players: " + numberOfPlayers);
        System.out.println("Booking date: " + bookingDate);
    }

    public void cancelBooking(int bookingId) throws SQLException {
        Statement statement = connection.createStatement();

        // Cancel the booking
        String sql = "DELETE FROM bookings WHERE booking_id = " + bookingId;
        statement.executeUpdate(sql);

        System.out.println("Booking canceled.");
    }

    public List<Booking> viewPastBookings(String customerName) throws SQLException {
        Statement statement = connection.createStatement();

        // Create a list to store the bookings
        List<Booking> bookings = new ArrayList<>();

        // Get the list of bookings for the customer
        String sql = "SELECT * FROM bookings WHERE customer_name = '" + customerName + "'";
        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {
            Booking book = new Booking();
            book.setBookingId(resultSet.getInt("booking_id"));
            book.setCustomerName(resultSet.getString("customer_name"));
            book.setNumberOfPlayers(resultSet.getInt("number_of_players"));
            book.setBookingDate(resultSet.getString("booking_date"));
            bookings.add(book);
        }


        return bookings;
    }

    public List<Booking> searchBookings(String search) throws SQLException {
        Statement statement = connection.createStatement();

        // Create a list to store the bookings
        List<Booking> bookings = new ArrayList<>();


        String sql = "SELECT * FROM bookings WHERE customer_name LIKE '%" + search + "%'";
        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {
            Booking booking = new Booking();
            booking.setBookingId(resultSet.getInt("booking_id"));
            booking.setCustomerName(resultSet.getString("customer_name"));
            booking.setNumberOfPlayers(resultSet.getInt("number_of_players"));
            booking.setBookingDate(resultSet.getString("booking_date"));
            bookings.add(booking);
        }
        return bookings;
    }

}
