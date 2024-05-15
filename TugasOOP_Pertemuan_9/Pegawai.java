class Pegawai {
    protected String nama;
    protected String departemen;
    protected char jenisKelamin;
    protected int gajiPokok;
    protected int gajiTHR;
    protected int cuti;
    protected String nip;

    public Pegawai(String nama, String departemen, char jenisKelamin) {
        this.nama = nama;
        this.departemen = departemen;
        this.jenisKelamin = jenisKelamin;
        this.gajiPokok = 0;
        this.gajiTHR = 0;
        this.cuti = 12;
    }

    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
        this.gajiTHR = gajiPokok;
    }

    public void tambahCuti(int tambahan) {
        this.cuti += tambahan;
    }

    public void setCuti(String jenisCuti) {
        if (jenisCuti.equalsIgnoreCase("pernikahan")) {
            this.tambahCuti(2);
        } else if (jenisCuti.equalsIgnoreCase("persalinan")) {
            if (this.jenisKelamin == 'P') {
                this.tambahCuti(90);
            } else {
                this.tambahCuti(3);
            }
        }
    }

    public void setNip(String nip) {
        if (nip.startsWith("P") || nip.startsWith("S") || nip.startsWith("M")) {
            this.nip = nip;
        } else {
            System.out.println("Format NIP tidak valid!");
        }
    }

    public void setNip(int urutanMasuk) {
        if (this instanceof Manager) {
            this.nip = "M" + String.format("%04d", urutanMasuk);
        } else if (this instanceof Salesman) {
            this.nip = "S" + String.format("%04d", urutanMasuk);
        } else {
            this.nip = "P" + String.format("%04d", urutanMasuk);
        }
    }

    public void displayInfo() {
        System.out.println("Jabatan : Pegawai");
        System.out.println("Nama : " + nama);
        System.out.println("Departemen : " + departemen);
        System.out.println("NIP : " + nip);
        System.out.println("Gaji Pokok : " + gajiPokok);
        System.out.println("Gaji THR : " + gajiTHR);
        System.out.println("Cuti : " + cuti);
        System.out.println("=======================================");
    }
}
