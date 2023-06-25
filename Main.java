import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Driver;
import java.sql.Date;
import java.util.Scanner;

import java.util.List;

class Main {

    public static void main(String[] args) throws Exception {
        GameCafeBookingManagement bookingManagement = new GameCafeBookingManagement();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Game Cafe Booking Management System.");

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Book a table");
            System.out.println("2. Cancel a booking");
            System.out.println("3. View past bookings");
            System.out.println("4. Search for bookings");
            System.out.println("5. Exit");

            System.out.println("-------------------------------");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the customer name:");
                    String customerName = scanner.next();
                    System.out.println("Enter the number of players:");
                    int numberOfPlayers = scanner.nextInt();
                    System.out.println("Enter the booking date:");
                    scanner.nextLine();
                    String dateDetails = scanner.nextLine();

                    bookingManagement.bookTable(customerName, numberOfPlayers, dateDetails);
                    break;
                case 2:
                    System.out.println("Enter the booking ID:");
                    int bookingId = scanner.nextInt();
                    bookingManagement.cancelBooking(bookingId);
                    break;
                case 3:
                    System.out.println("Enter the customer name:");
                    String search = scanner.next();
                    List<Booking> bookings = bookingManagement.viewPastBookings(search);
                    for (Booking booking : bookings) {
                        System.out.println(booking);
                    }
                    break;
                case 4:
                    System.out.println("Enter search :");
                    search = scanner.next();
                    bookings = bookingManagement.searchBookings(search);
                    for (Booking booking : bookings) {
                        System.out.println(booking);
                    }
                    break;
                case 5:
                    System.out.println("Exiting.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
