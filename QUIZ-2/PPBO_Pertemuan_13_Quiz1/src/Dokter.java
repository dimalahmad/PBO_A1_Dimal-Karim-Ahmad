import java.util.ArrayList;

public class Dokter extends Orang {
    private String idDokter;
    private String nomorSTR;
    private String spesialis;
    private ArrayList<Antrian> daftarAntrian;

    public Dokter(String nama, String tanggaLahir, JENIS_KELAMIN jenisKelamin, String nomorSTR, String spesialis) {
        super(nama, tanggaLahir, jenisKelamin);
        this.nomorSTR = nomorSTR;
        this.spesialis = spesialis;
        this.idDokter = "";
        this.daftarAntrian = new ArrayList<Antrian>();
    }

    public ArrayList<Antrian> geAntrian() {
        return daftarAntrian;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public String getId() {
        return idDokter;
    }

    public void setId(String id) {
        idDokter = id;
    }

    public void daftar(RumahSakit rumahSakit) {
        rumahSakit.tambahDokter(this);
    }

    public void periksa() {
        daftarAntrian.remove(0);
    }

    public boolean tambahAntrian(Antrian antrian) {
        for (Antrian dataAntrian : daftarAntrian) {
            if (dataAntrian.getKeluhan() == antrian.getKeluhan() && dataAntrian.getDokter() == antrian.getDokter()) {
                System.out.println("PASIEN SUDAH TERDAFTAR");
                return false;
            }
        }
        daftarAntrian.add(antrian);
        return true;
    }
}
