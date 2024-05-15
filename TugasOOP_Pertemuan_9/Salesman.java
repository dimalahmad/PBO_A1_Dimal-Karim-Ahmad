class Salesman extends Pegawai {
    private int target;
    private int penjualan;

    public Salesman(String nama, String departemen, char jenisKelamin) {
        super(nama, departemen, jenisKelamin);
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void setPenjualan(int penjualan) {
        this.penjualan = penjualan;
        this.gajiTHR = (penjualan >= target) ? gajiPokok * 2 : gajiPokok;
    }

    @Override
    public void displayInfo() {
        System.out.println("Jabatan : Salesman");
        System.out.println("Nama : " + nama);
        System.out.println("Departemen : " + departemen);
        System.out.println("NIP : " + nip);
        System.out.println("Gaji Pokok : " + gajiPokok);
        System.out.println("Gaji THR : " + gajiTHR);
        System.out.println("Cuti : " + cuti);
        System.out.println("=======================================");
    }
}
