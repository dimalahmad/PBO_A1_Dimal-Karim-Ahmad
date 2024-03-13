

public class Barang {
    String nama;
    int harga;
    int jumlah;

    public Barang(String nama, int harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    // Method untuk mengatur nama barang
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Method untuk mengatur harga barang
    public void setHarga(int harga) {
        this.harga = harga;
    }

    // Method untuk mengatur jumlah barang
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}