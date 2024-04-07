import java.util.ArrayList;
import java.util.List;

public class Toko {
    public enum TipeBarang {MEJA, KURSI, LEMARI}

    private List<Pembeli> antrian = new ArrayList<>();
    private Gudang gudangBarang = new Gudang();

    public Gudang getGudangBarang() {
        return gudangBarang;
    }

    public void tambahAntrian(Pembeli pembeli) {
        antrian.add(pembeli);
        System.out.println("Berhasil menambahkan antrian");
    }

    public void selesaikanAntrian() {
        if (!antrian.isEmpty()) {
            Pembeli pembeli = antrian.get(0);
            TipeBarang tipeBarang = pembeli.getBarangDiBeli();
            int jumlahBarang = pembeli.getJumlahBarang();
            switch (tipeBarang) {
                case KURSI:
                    if (gudangBarang.barangTersedia(TipeBarang.KURSI, jumlahBarang)) {
                        gudangBarang.keluarkanBarang(TipeBarang.KURSI, jumlahBarang);
                        System.out.println(jumlahBarang + " " + tipeBarang.toString().toUpperCase() + " berhasil di keluarkan dari gudang");
                    } else {
                        System.out.println("Tidak cukup " + tipeBarang.toString().toUpperCase() + " untuk memenuhi pesanan");
                    }
                    break;
                case MEJA:
                    if (gudangBarang.barangTersedia(TipeBarang.MEJA, jumlahBarang)) {
                        gudangBarang.keluarkanBarang(TipeBarang.MEJA, jumlahBarang);
                        System.out.println(jumlahBarang + " " + tipeBarang.toString().toUpperCase() + " berhasil di keluarkan dari gudang");
                    } else {
                        System.out.println("Tidak cukup " + tipeBarang.toString().toUpperCase() + " untuk memenuhi pesanan");
                    }
                    break;
                case LEMARI:
                    if (gudangBarang.barangTersedia(TipeBarang.LEMARI, jumlahBarang)) {
                        gudangBarang.keluarkanBarang(TipeBarang.LEMARI, jumlahBarang);
                        System.out.println(jumlahBarang + " " + tipeBarang.toString().toUpperCase() + " berhasil di keluarkan dari gudang");
                    } else {
                        System.out.println("Tidak cukup " + tipeBarang.toString().toUpperCase() + " untuk memenuhi pesanan");
                    }
                    break;
            }
            antrian.remove(0);
            System.out.println("Antrian terdepan berhasil di selesaikan");
        } else {
            System.out.println("Antrian kosong");
        }
    }

    public void cekIsiAntrian() {
        if (!antrian.isEmpty()) {
            System.out.println("\nLIST ANTRIAN :");
            for (int i = 0; i < antrian.size(); i++) {
                Pembeli pembeli = antrian.get(i);
                System.out.println("Antrian ke-" + (i + 1) + ", nama : " + pembeli.getNama() +
                        ", barang di beli : " + pembeli.getBarangDiBeli().toString() +
                        ", jumlah barang dibeli : " + pembeli.getJumlahBarang());
            }
            System.out.println("");
        } else {
            System.out.println("\nAntrian kosong\n");
        }
    }
}
