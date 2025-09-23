import java.util.ArrayList;

/**
 * Class MataKuliah merepresentasikan sebuah mata kuliah yang ditawarkan.
 */
public class MataKuliah {
    // Atribut atau variabel
    private String kodeMK;
    private String namaMK;
    private int sks;
    private Dosen dosenPengampu;
    private ArrayList<Mahasiswa> daftarMahasiswa;

    /**
     * Constructor untuk membuat objek MataKuliah baru.
     * @param kodeMK Kode unik mata kuliah.
     * @param namaMK Nama lengkap mata kuliah.
     * @param sks Jumlah SKS.
     * @param dosen Objek Dosen yang mengampu mata kuliah ini.
     */
    public MataKuliah(String kodeMK, String namaMK, int sks, Dosen dosen) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
        this.dosenPengampu = dosen;
        this.daftarMahasiswa = new ArrayList<>(); // Inisialisasi ArrayList kosong
    }

    /**
     * Mendaftarkan seorang mahasiswa ke dalam mata kuliah ini.
     * @param mahasiswa Objek Mahasiswa yang akan ditambahkan.
     */
    public void tambahMahasiswa(Mahasiswa mahasiswa) {
        this.daftarMahasiswa.add(mahasiswa);
    }

    /**
     * Menampilkan informasi detail tentang mata kuliah, termasuk dosen dan daftar mahasiswanya.
     */
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

    // Metode getter sederhana jika diperlukan
    public String getNamaMK() {
        return this.namaMK;
    }
}