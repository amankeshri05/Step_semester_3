package week5.class_problems;

public class CineScreen {
    private int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0) {
            System.out.println("Construction rejected: seatsTotal must be positive");
            this.seatsTotal = 0;
            this.seatsAvailable = 0;
        } else {
            this.seatsTotal = seatsTotal;
            this.seatsAvailable = seatsTotal;
        }
    }

    public void bookSeat() {
        if (seatsAvailable > 0) seatsAvailable--;
    }

    public void cancelBooking() {
        if (seatsAvailable < seatsTotal) seatsAvailable++;
    }

    public int getSeatsAvailable() { return seatsAvailable; }

    public static void main(String[] args) {
        new CineScreen(0); // construction rejected

        CineScreen c = new CineScreen(2);
        c.bookSeat(); c.bookSeat(); c.bookSeat();
        System.out.println(c.getSeatsAvailable()); // 0

        c.cancelBooking(); c.cancelBooking(); c.cancelBooking();
        System.out.println(c.getSeatsAvailable()); // 2
    }
}