public class Booking {
    private int bookingId;
    private String title;
    private String genre;
    private int duration;
    private int numberOfTickets;
    private double payment;

    public Booking(int bookingId, String title, String genre, int duration, int numberOfTickets, double payment) {
        this.bookingId = bookingId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.numberOfTickets = numberOfTickets;
        this.payment = payment;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Booking " + bookingId + ": " + title + "\nJumlah Tiket: " + numberOfTickets + "\nPembayaran: $" + payment;
    }
}
