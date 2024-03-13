import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah barang: ");
        int jumlahBarang = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        if (jumlahBarang <= 0) {
            System.out.println("Tidak ada barang yang dimasukkan.");
            return;
        }

        Keranjang keranjang1 = new Keranjang();

        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println("Masukkan detail barang ke-" + (i + 1) + ":");
            System.out.print("Nama: ");
            String namaBarang = scanner.nextLine();
            System.out.print("Harga: ");
            int hargaBarang = scanner.nextInt();
            System.out.print("Jumlah: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            Barang barang = new Barang(namaBarang, hargaBarang, jumlah);
            keranjang1.tambahBarang(barang);
        }

        keranjang1.printBerhasilMemasukkan();
        System.out.println("\n===============================");
        keranjang1.printHasil();
    }
}
