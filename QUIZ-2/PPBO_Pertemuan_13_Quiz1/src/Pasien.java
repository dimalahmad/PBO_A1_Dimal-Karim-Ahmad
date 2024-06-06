import java.util.ArrayList;

public class Pasien extends Orang {
    private String pekerjaan;
    private String domisili;

    public Pasien(String nama, String tanggaLahir, JENIS_KELAMIN jenisKelamin, String pekerjaan, String domisili) {
        super(nama, tanggaLahir, jenisKelamin);
        this.pekerjaan = pekerjaan;
        this.domisili = domisili;
    }

    public void periksa(RumahSakit rumahSakit) {
        rumahSakit.periksa(this);
    }

    public void daftar(RumahSakit rumahSakit, String keluhan, String namaDokter, Antrian.tipePasiens tipePasien) {
        ArrayList<Dokter> daftarDokter = rumahSakit.getDokter();
        int urutDokter = 0;
        for (Dokter dokter : daftarDokter) {
            if (dokter.getNama() == namaDokter) {
                break;
            }
            urutDokter++;
        }
        if (urutDokter < daftarDokter.size()) {
            Dokter dokter = daftarDokter.get(urutDokter);
            int urutPasien = rumahSakit.geAntrian().size() + 1;
            Antrian antrian = new Antrian(daftarDokter.get(urutDokter), this,
                    String.format("%s_%d", dokter.getId(), urutPasien), keluhan);
            boolean added = dokter.tambahAntrian(antrian);
            if (added) {
                System.out.println("SUKSES");
                rumahSakit.tambahAntrian(antrian);
            }

        } else {
            System.out.println("DOKTER TIDAK TERSEDIA");
        }
    }
}
