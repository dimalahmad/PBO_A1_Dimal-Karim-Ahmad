public class Antrian {
    public static enum tipePasiens{
        MANDIRI,
        BPJS
    }
    private Dokter dokter;
    private Pasien pasien;
    private String idAntrian;
    private String keluhan;
    public Antrian(Dokter dokter, Pasien pasien, String idAntrian, String keluhan) {
        this.dokter = dokter;
        this.pasien = pasien;
        this.keluhan = keluhan;
        this.idAntrian = idAntrian;
    }
    public Pasien getPasien(){
        return pasien;
    }
    public Dokter getDokter(){
        return dokter;
    }
    public String getKeluhan(){
        return keluhan;
    }
    public String getId(){
        return idAntrian;
    }
}
