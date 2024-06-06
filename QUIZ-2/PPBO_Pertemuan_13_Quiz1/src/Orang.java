public abstract class Orang {
    private String nama;
    private String tanggalLahir;

    public static enum JENIS_KELAMIN {
        LAKI_LAKI,
        PEREMPUAN
    }

    private JENIS_KELAMIN jenisKelamin;

    protected Orang(String nama, String tanggaLahir, JENIS_KELAMIN jenisKelamin) {
        this.nama = nama;
        this.tanggalLahir = tanggaLahir;
        this.jenisKelamin = jenisKelamin;
    }

    public String getNama() {
        return nama;
    }

}
