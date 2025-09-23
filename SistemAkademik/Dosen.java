
public class Dosen {
    
    private String nama;
    private String nip;
    private String bidangKeahlian;

    /**
     * @param nama 
     * @param nip 
     * @param bidangKeahlian 
     */
    public Dosen(String nama, String nip, String bidangKeahlian) {
        this.nama = nama;
        this.nip = nip;
        this.bidangKeahlian = bidangKeahlian;
    }

    /**
     * @return
     */
    public String getNama() {
        return this.nama;
    }

    /**
     * @return 
     */
    public String getNip() {
        return this.nip;
    }

    /**
     * @return 
     */
    public String getInfo() {
        return "Nama Dosen: " + nama + ", NIP: " + nip + ", Keahlian: " + bidangKeahlian;
    }
}