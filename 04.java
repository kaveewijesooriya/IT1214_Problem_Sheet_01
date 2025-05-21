class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

     int getTicketNumber() {
        return ticketNumber;
    }
    String getCustomerName() {
        return customerName;
    }

     int getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        return "Ticket #" + ticketNumber + " - " + customerName + " (Seat " + seatNumber + ")";
    }
}

class BookingSystem {
    private static final int MAX_SEATS = 10;
    private Ticket[] tickets;
    private int ticketCount;

    public BookingSystem() {
        tickets = new Ticket[MAX_SEATS];
        ticketCount = 0;
    }

    public boolean bookTicket(int ticketNumber, String customerName, int seatNumber) {

        if (seatNumber < 1 || seatNumber > MAX_SEATS) {
            System.out.println("Invalid seat number. Please choose between 1-" + MAX_SEATS);
            return false;
        }


        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getSeatNumber() == seatNumber) {
                System.out.println("Seat " + seatNumber + " is already booked.");
                return false;
            }
        }

        if (ticketCount >= MAX_SEATS) {
            System.out.println("Sorry, all seats are booked.");
            return false;
        }

        tickets[ticketCount] = new Ticket(ticketNumber, customerName, seatNumber);
        ticketCount++;
        System.out.println("Ticket booked successfully for " + customerName + " at seat " + seatNumber);
        return true;
    }

    public boolean cancelTicket(int ticketNumber) {
        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getTicketNumber() == ticketNumber) {
                for (int j = i; j < ticketCount - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }
                ticketCount--;
                tickets[ticketCount] = null;
                System.out.println("Ticket #" + ticketNumber + " cancelled successfully.");
                return true;
            }
        }
        System.out.println("Ticket #" + ticketNumber + " not found.");
        return false;
    }
 void displayBookings() {
        if (ticketCount == 0) {
            System.out.println("No tickets booked currently.");
            return;
        }

        System.out.println("Current Bookings:");
        for (int i = 0; i < ticketCount; i++) {
            System.out.println(tickets[i]);
        }
    }
}

 class Cinema {
    public static void main(String[] args) {
        BookingSystem cinema = new BookingSystem();

        cinema.bookTicket(1, "Alice", 1);
        cinema.bookTicket(2, "Bob", 2);
        cinema.bookTicket(3, "Charlie", 3);


        cinema.cancelTicket(2);


        cinema.bookTicket(4, "Dana", 2);

        cinema.displayBookings();
    }
}