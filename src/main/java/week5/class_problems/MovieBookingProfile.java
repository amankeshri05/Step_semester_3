package week5.class_problems;

public class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otp;

    public MovieBookingProfile() {}

    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isConfirmed() { return confirmed; }
    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }

    public void setOtp(String otp) { this.otp = otp; } // no getter anywhere — write-only

    public static void main(String[] args) {
        System.out.println(new MovieBookingProfile("Rahul Dev").getName()); // Rahul Dev

        MovieBookingProfile p = new MovieBookingProfile("Rahul Dev");
        p.setConfirmed(true);
        System.out.println(p.isConfirmed()); // true

        p.setOtp("4471"); // no observable output — cannot be retrieved
    }
}