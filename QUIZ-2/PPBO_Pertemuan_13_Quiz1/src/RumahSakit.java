import java.util.ArrayList;

public class RumahSakit {
    private String nama;
    private String alamat;
    private String noTelepon;
    private ArrayList<Dokter> daftarDokter;
    private ArrayList<Antrian> daftarAntrian;

    public RumahSakit(String nama, String alamat, String noTelepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.daftarDokter = new ArrayList<Dokter>();
        this.daftarAntrian = new ArrayList<Antrian>();
    }

    public ArrayList<Dokter> getDokter() {
        return daftarDokter;
    }

    public ArrayList<Antrian> geAntrian() {
        return daftarAntrian;
    }

    public void cekListDokter() {
        if (daftarDokter.size() == 0) {
            System.out.println("BELUM ADA DOKTER YANG TERSEDIA");
            return;
        }
        System.out.println("BERIKUT DOKTER YANG TERSEDIA SAAT INI");
        System.out.println("=====================================");
        int no = 1;
        for (Dokter dok : daftarDokter) {
            System.out.printf("%d. Nama : %s, Spesialis : %s\n", no, dok.getNama(), dok.getSpesialis());
            no++;
        }
    }

    public void cekAntrianPasien() {
        System.out.println("ANTRIAN RUMAH SAKIT SAAT INI");
        System.out.println("=====================================");
        for (Dokter dokter : daftarDokter) {
            System.out.printf("DR. %s\n", dokter.getNama());
            ArrayList<Antrian> daftarAntrian = dokter.geAntrian();
            if (daftarAntrian.size() == 0) {
                System.out.println("ANTRIAN KOSONG");
                System.out.println("=================");
                continue;
            }
            for (Antrian antrian : daftarAntrian) {
                System.out.printf("ID ANTRIAN : %s, Atas nama : %s\n", antrian.getId(), antrian.getPasien().getNama());
            }
            System.out.println("=================");
        }

    }

    public void tambahAntrian(Antrian antrian) {
        daftarAntrian.add(antrian);
    }

    public void tambahDokter(Dokter dokter) {
        for (Dokter dokter2 : daftarDokter) {
            if (dokter2.getNama() == dokter.getNama()) {
                System.out.println("DOKTER SUDAH TERDAFTAR");
                return;
            }
        }
        System.out.println("SUKSES");
        dokter.setId(String.format("D_%s_%d", dokter.getSpesialis(), daftarDokter.size() + 1));
        daftarDokter.add(dokter);
    }

    public void periksa(Pasien pasien) {
        boolean stat = false;
        for (Antrian antrian : daftarAntrian) {
            if (antrian.getPasien() == pasien)
                stat = true;
            break;
        }
        if (!stat) {
            System.out.println("BELUM DAFTAR");
            return;
        }
        if (daftarAntrian.get(0).getPasien() == pasien) {
            System.out.println("SUKSES");
            daftarAntrian.get(0).getDokter().periksa();
            daftarAntrian.remove(0);

        } else {
            System.out.println("BELUM SAATNYA PERIKSA");
        }
    }
}
