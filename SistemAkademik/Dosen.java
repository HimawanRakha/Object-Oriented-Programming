/**
 * Class Dosen merepresentasikan seorang dosen pengajar.
 */
public class Dosen {
    // Atribut atau variabel
    private String nama;
    private String nip;
    private String bidangKeahlian;

    /**
     * Constructor untuk membuat objek Dosen baru.
     * @param nama Nama lengkap dosen.
     * @param nip Nomor Induk Pegawai.
     * @param bidangKeahlian Bidang keahlian atau spesialisasi dosen.
     */
    public Dosen(String nama, String nip, String bidangKeahlian) {
        this.nama = nama;
        this.nip = nip;
        this.bidangKeahlian = bidangKeahlian;
    }

    /**
     * Mengembalikan nama dosen.
     * @return String nama dosen.
     */
    public String getNama() {
        return this.nama;
    }

    /**
     * Mengembalikan NIP dosen.
     * @return String NIP dosen.
     */
    public String getNip() {
        return this.nip;
    }

    /**
     * Mengembalikan informasi lengkap tentang dosen.
     * @return String informasi dosen.
     */
    public String getInfo() {
        return "Nama Dosen: " + nama + ", NIP: " + nip + ", Keahlian: " + bidangKeahlian;
    }
}