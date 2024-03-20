import java.util.ArrayList;
import java.util.List;

public class Perpustakaan {
    String nama;
    String lokasi;
    ArrayList<Buku> listBuku;
    int jmlHariOperasional;

    Perpustakaan() {
        System.out.println("TEST");
        listBuku = new ArrayList<Buku>();
        jmlHariOperasional = 6;
    }

    Perpustakaan(String nama, String lokasi, int jmlHariOperasional) {
       this.nama = nama;
       this.lokasi = lokasi;
       this.jmlHariOperasional = jmlHariOperasional;
       listBuku = new ArrayList<Buku>();
    }

    void printSemuaBuku() {
        for (Buku buku : this.listBuku) {
            System.out.println(buku.judul);
        }
    }

    int jmlHariLibur() {
        int totalHari = 7;
        int hariLibur = totalHari - jmlHariOperasional;

        return hariLibur;
    }

    void tambahBuku(List<Buku> bukuBaru) {
        for(Buku b : bukuBaru) {
            // diisi apa ya?

        }

        for(int i = 0; i< bukuBaru.size(); i++) {
            Buku b = bukuBaru.get(i);
            //diisi apa ya?
            this.listBuku.add( b);
        }
    }


}
