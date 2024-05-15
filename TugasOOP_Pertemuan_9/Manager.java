class Manager extends Pegawai {
    public Manager(String nama, String departemen, char jenisKelamin) {
        super(nama, departemen, jenisKelamin);
    }

    @Override
    public void setGajiPokok(int gajiPokok) {
        super.setGajiPokok(gajiPokok);
        this.gajiTHR = gajiPokok * 2;
    }

    @Override
    public void displayInfo() {
        System.out.println("Jabatan : Manager");
        System.out.println("Nama : " + nama);
        System.out.println("Departemen : " + departemen);
        System.out.println("NIP : " + nip);
        System.out.println("Gaji Pokok : " + gajiPokok);
        System.out.println("Gaji THR : " + gajiTHR);
        System.out.println("Cuti : " + cuti);
        System.out.println("=======================================");
    }
}
