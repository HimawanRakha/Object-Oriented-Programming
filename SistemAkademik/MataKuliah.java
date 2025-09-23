import java.util.ArrayList;

public class MataKuliah {
   
    private String kodeMK;
    private String namaMK;
    private int sks;
    private Dosen dosenPengampu;
    private ArrayList<Mahasiswa> daftarMahasiswa;

    /**
     * @param kodeMK 
     * @param namaMK
     * @param sks
     * @param dosen 
     */
    public MataKuliah(String kodeMK, String namaMK, int sks, Dosen dosen) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
        this.dosenPengampu = dosen;
        this.daftarMahasiswa = new ArrayList<>(); 
    }

    /**
     * @param mahasiswa
     */
    public void tambahMahasiswa(Mahasiswa mahasiswa) {
        this.daftarMahasiswa.add(mahasiswa);
    }

    public void info() {
        System.out.println("========================================");
        System.out.println("Kode Mata Kuliah: " + this.kodeMK);
        System.out.println("Nama Mata Kuliah: " + this.namaMK);
        System.out.println("SKS: " + this.sks);
        System.out.println("Dosen Pengampu: " + this.dosenPengampu.getNama());
        System.out.println("--- Daftar Mahasiswa Terdaftar ---");
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Belum ada mahasiswa yang mengambil mata kuliah ini.");
        } else {
            for (int i = 0; i < daftarMahasiswa.size(); i++) {
                Mahasiswa mhs = daftarMahasiswa.get(i);
                System.out.println((i + 1) + ". " + mhs.getnrp() + " - " + mhs.getNama());
            }
        }
        System.out.println("========================================");
    }

    public String getNamaMK() {
        return this.namaMK;
    }
}