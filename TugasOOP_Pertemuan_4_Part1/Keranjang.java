
import java.util.ArrayList;

class Keranjang {
    ArrayList<Barang> daftarBarang = new ArrayList<>();
    int count = 0;

    public void tambahBarang(Barang barang) {
        if (daftarBarang.size() < 5) {
            daftarBarang.add(barang);
            count++;
        } else {
            System.out.println("Keranjang sudah penuh!");
        }
    }

    public void printHasil() {
        System.out.println("\nJumlah Barang Di Keranjang Saat Ini : " + daftarBarang.size());
        System.out.println("Barang Pada Keranjang:");

        int totalHarga = 0;
        for (Barang barang : daftarBarang) {
            System.out.println("#" + barang.nama + ", jumlah : " + barang.jumlah);
            totalHarga += barang.harga * barang.jumlah;
        }

        System.out.println("\nTotal Harga Yang Harus di Bayar: " + totalHarga);
    }

    public void printBerhasilMemasukkan() {
        for (int i = 0; i < count; i++) {
            System.out.println("Berhasil memasukkan ke keranjang");
        }
    }
}