import java.util.ArrayList;

public class Mahasiswa {

    private String nama;
    private String nrp;
    private String jurusan;
    private ArrayList<MataKuliah> daftarMataKuliah;

    /**
     * @param nama 
     * @param nrp 
     * @param jurusan ]
     */
    public Mahasiswa(String nama, String nrp, String jurusan) {
        this.nama = nama;
        this.nrp = nrp;
        this.jurusan = jurusan;
        this.daftarMataKuliah = new ArrayList<>(); 
    }

    /**
     * @param mk 
     */
    public void tambahMataKuliah(MataKuliah mk) {
        this.daftarMataKuliah.add(mk); 
        mk.tambahMahasiswa(this);
    }

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

    public String getNama() {
        return this.nama;
    }
    
    public String getnrp() {
        return this.nrp;
    }
}