import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MovieApp {
    private List<Film> films;
    private List<Booking> bookings;

    public MovieApp() {
        this.films = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public void addFilm(String title, String genre, int duration, int availableSeats) {
        films.add(new Film(title, genre, duration, availableSeats));
    }

    public void displayAllFilms() {
        System.out.println("List of Films:");
        for (Film film : films) {
            System.out.println(film);
        }
    }

    public void searchFilm(String title) {
        boolean found = false;
        for (Film film : films) {
            if (film.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Film Tersedia");
                System.out.println(film);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Film Tidak Tersedia");
        }
    }

    public void bookFilm(int filmNumber, int numberOfTickets, double payment) {
        if (filmNumber > 0 && filmNumber <= films.size()) {
            Film filmToBook = films.get(filmNumber - 1);
            if (filmToBook.getAvailableSeats() >= numberOfTickets) {
                int bookingId = new Random().nextInt(1000); // Generate random booking ID
                filmToBook.decreaseAvailableSeats(numberOfTickets);
                bookings.add(new Booking(bookingId, filmToBook.getTitle(), filmToBook.getGenre(), filmToBook.getDuration(), numberOfTickets, payment));
                System.out.println("Pesanan berhasil dengan detail pesanan:");
                System.out.println("Film: " + filmToBook.getTitle());
                System.out.println("Jumlah Tiket: " + numberOfTickets);
                System.out.println("Pembayaran: $" + payment);
                System.out.println("Booking " + bookingId);
            } else {
                System.out.println("Pesanan tidak dapat diproses. Kursi tidak tersedia.");
            }
        } else {
            System.out.println("Film dengan nomor tersebut tidak ditemukan.");
        }
    }

    public void searchBooking(int bookingId) {
        boolean found = false;
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                System.out.println(booking);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Pesanan Tidak Ditemukan");
        }
    }

    private class Film {
        private String title;
        private String genre;
        private int duration;
        private int availableSeats;

        public Film(String title, String genre, int duration, int availableSeats) {
            this.title = title;
            this.genre = genre;
            this.duration = duration;
            this.availableSeats = availableSeats;
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

        public int getAvailableSeats() {
            return availableSeats;
        }

        public void decreaseAvailableSeats(int amount) {
            availableSeats -= amount;
        }

        @Override
        public String toString() {
            return title + " " + genre + " - Duration: " + duration + " mins Available Seats: " + availableSeats;
        }
    }
}
