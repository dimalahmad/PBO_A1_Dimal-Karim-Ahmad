import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieApp movieApp = new MovieApp();
        Scanner scanner = new Scanner(System.in);

        // Menambahkan beberapa film
        movieApp.addFilm("Avengers: Endgame", "Action", 180, 50);
        movieApp.addFilm("Joker", "Drama", 122, 60);

        // Menampilkan semua film
        movieApp.displayAllFilms();

        // Mencari film berdasarkan judul
        System.out.println("Masukkan judul film untuk mencari: ");
        String filmTitle = scanner.nextLine();
        movieApp.searchFilm(filmTitle);

        // Memesan tiket
        System.out.println("Masukkan nomor film untuk memesan tiket: ");
        int filmNumber = scanner.nextInt();
        System.out.println("Masukkan jumlah tiket yang ingin dipesan: ");
        int numberOfTickets = scanner.nextInt();
        System.out.println("Masukkan pembayaran: ");
        double payment = scanner.nextDouble();
        movieApp.bookFilm(filmNumber, numberOfTickets, payment);

        // Menampilkan semua film setelah memesan tiket
        movieApp.displayAllFilms();
    }
}
