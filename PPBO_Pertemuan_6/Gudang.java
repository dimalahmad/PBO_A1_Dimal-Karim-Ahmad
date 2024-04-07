import java.util.HashMap;

public class Gudang {
    public enum Bahan {KAYU, BAUT, CAT}

    private final int MAX_KURSI = 20;
    private final int MAX_MEJA = 10;
    private final int MAX_LEMARI = 5;

    private HashMap<Bahan, Integer> stokBahan = new HashMap<>();
    private HashMap<Toko.TipeBarang, Integer> isiGudang = new HashMap<>();

    public Gudang() {
        stokBahan.put(Bahan.KAYU, 0);
        stokBahan.put(Bahan.BAUT, 0);
        stokBahan.put(Bahan.CAT, 0);
    }

    public void tambahBahan(Bahan bahan, int jumlah) {
        stokBahan.put(bahan, stokBahan.get(bahan) + jumlah);
    }

    public void buatBarang(Toko.TipeBarang tipeBarang, int jumlah) {
        int kayuDiperlukan = 0, bautDiperlukan = 0, catDiperlukan = 0;
        switch (tipeBarang) {
            case KURSI:
                kayuDiperlukan = 2 * jumlah;
                bautDiperlukan = 10 * jumlah;
                catDiperlukan = 1 * jumlah;
                if (bahanPembuatanMencukupi(Bahan.KAYU, kayuDiperlukan) &&
                        bahanPembuatanMencukupi(Bahan.BAUT, bautDiperlukan) &&
                        bahanPembuatanMencukupi(Bahan.CAT, catDiperlukan)) {
                    tambahBahanKeGudang(tipeBarang, jumlah);
                    kurangiBahan(Bahan.KAYU, kayuDiperlukan);
                    kurangiBahan(Bahan.BAUT, bautDiperlukan);
                    kurangiBahan(Bahan.CAT, catDiperlukan);
                    System.out.println(jumlah + " KURSI berhasil ditambahkan ke Gudang");
                } else {
                    System.out.println("Bahan tidak cukup untuk membuat KURSI");
                }
                break;
            case MEJA:
                kayuDiperlukan = 3 * jumlah;
                bautDiperlukan = 20 * jumlah;
                catDiperlukan = 2 * jumlah;
                if (bahanPembuatanMencukupi(Bahan.KAYU, kayuDiperlukan) &&
                        bahanPembuatanMencukupi(Bahan.BAUT, bautDiperlukan) &&
                        bahanPembuatanMencukupi(Bahan.CAT, catDiperlukan)) {
                    tambahBahanKeGudang(tipeBarang, jumlah);
                    kurangiBahan(Bahan.KAYU, kayuDiperlukan);
                    kurangiBahan(Bahan.BAUT, bautDiperlukan);
                    kurangiBahan(Bahan.CAT, catDiperlukan);
                    System.out.println(jumlah + " MEJA berhasil ditambahkan ke Gudang");
                } else {
                    System.out.println("Bahan tidak cukup untuk membuat MEJA");
                }
                break;
            case LEMARI:
                kayuDiperlukan = 5 * jumlah;
                bautDiperlukan = 30 * jumlah;
                catDiperlukan = 3 * jumlah;
                if (bahanPembuatanMencukupi(Bahan.KAYU, kayuDiperlukan) &&
                        bahanPembuatanMencukupi(Bahan.BAUT, bautDiperlukan) &&
                        bahanPembuatanMencukupi(Bahan.CAT, catDiperlukan)) {
                    tambahBahanKeGudang(tipeBarang, jumlah);
                    kurangiBahan(Bahan.KAYU, kayuDiperlukan);
                    kurangiBahan(Bahan.BAUT, bautDiperlukan);
                    kurangiBahan(Bahan.CAT, catDiperlukan);
                    System.out.println(jumlah + " LEMARI berhasil ditambahkan ke Gudang");
                } else {
                    System.out.println("Bahan tidak cukup untuk membuat LEMARI");
                }
                break;
        }
    }

    private boolean bahanPembuatanMencukupi(Bahan bahan, int jumlahDiperlukan) {
        return stokBahan.getOrDefault(bahan, 0) >= jumlahDiperlukan;
    }

    private void tambahBahanKeGudang(Toko.TipeBarang tipeBarang, int jumlah) {
        isiGudang.put(tipeBarang, isiGudang.getOrDefault(tipeBarang, 0) + jumlah);
    }

    private void kurangiBahan(Bahan bahan, int jumlah) {
        stokBahan.put(bahan, stokBahan.getOrDefault(bahan, 0) - jumlah);
    }

    public void cekStokBahan() {
        System.out.println("\nSTOK BAHAN :");
        System.out.println("Jumlah : BAUT, saat ini adalah : " + stokBahan.get(Bahan.BAUT) + " buah");
        System.out.println("Jumlah : KAYU, saat ini adalah : " + stokBahan.get(Bahan.KAYU) + " buah");
        System.out.println("Jumlah : CAT, saat ini adalah : " + stokBahan.get(Bahan.CAT) + " buah\n");
    }
    public boolean barangTersedia(Toko.TipeBarang tipeBarang, int jumlah) {
        return isiGudang.getOrDefault(tipeBarang, 0) >= jumlah;
    }

    public void keluarkanBarang(Toko.TipeBarang tipeBarang, int jumlah) {
        isiGudang.put(tipeBarang, isiGudang.getOrDefault(tipeBarang, 0) - jumlah);
    }

    public void tambahBarang(Toko.TipeBarang tipeBarang, int jumlah) {
        isiGudang.put(tipeBarang, isiGudang.getOrDefault(tipeBarang, 0) + jumlah);
    }
    public void cekIsiGudang() {
        StringBuilder result = new StringBuilder("\nISI GUDANG :\n");
        result.append("Jumlah : MEJA saat ini adalah : ").append(isiGudang.getOrDefault(Toko.TipeBarang.MEJA, 0)).append(" buah\n");
        result.append("Jumlah : KURSI, saat ini adalah : ").append(isiGudang.getOrDefault(Toko.TipeBarang.KURSI, 0)).append(" buah\n");
        result.append("Jumlah : LEMARI, saat ini adalah : ").append(isiGudang.getOrDefault(Toko.TipeBarang.LEMARI, 0)).append(" buah\n");
        System.out.println(result.toString());
    }
}
