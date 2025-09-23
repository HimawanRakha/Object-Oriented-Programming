import java.util.ArrayList;

/**
 * Class Mahasiswa merepresentasikan seorang mahasiswa.
 */
public class Mahasiswa {
    // Atribut atau variabel
    private String nama;
    private String nrp;
    private String jurusan;
    private ArrayList<MataKuliah> daftarMataKuliah;

    /**
     * Constructor untuk membuat objek Mahasiswa baru.
     * @param nama Nama lengkap mahasiswa.
     * @param nrp Nomor Induk Mahasiswa.
     * @param jurusan Program studi.
     */
    public Mahasiswa(String nama, String nrp, String jurusan) {
        this.nama = nama;
        this.nrp = nrp;
        this.jurusan = jurusan;
        this.daftarMataKuliah = new ArrayList<>(); // Inisialisasi ArrayList kosong
    }

    /**
     * Menambahkan mata kuliah yang diambil oleh mahasiswa.
     * Metode ini juga secara otomatis mendaftarkan mahasiswa ini ke kelas MataKuliah.
     * @param mk Objek MataKuliah yang diambil.
     */
    public void tambahMataKuliah(MataKuliah mk) {
        this.daftarMataKuliah.add(mk); // Tambahkan MK ke daftar milik mahasiswa
        mk.tambahMahasiswa(this);    // Daftarkan mahasiswa ini ke MK tersebut
    }

    /**
     * Menampilkan Kartu Rencana Studi (KRS) mahasiswa.
     */
    public void lihatKRS() {
        System.out.println("===== KARTU RENCANA STUDI (KRS) =====");
        System.out.println("nrp: " + this.nrp);
        System.out.println("Nama: " + this.nama);
        System.out.println("Jurusan: " + this.jurusan);
        System.out.println("--- Daftar Mata Kuliah yang Diambil ---");
        
        if (daftarMataKuliah.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        } else {
            int totalSks = 0;
            for (int i = 0; i < daftarMataKuliah.size(); i++) {
                MataKuliah mk = daftarMataKuliah.get(i);
                System.out.println((i + 1) + ". " + mk.getNamaMK());
            }
        }
        System.out.println("=======================================");
    }
    
    // Metode getter sederhana
    public String getNama() {
        return this.nama;
    }
    
    public String getnrp() {
        return this.nrp;
    }
}