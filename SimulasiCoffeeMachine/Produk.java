/**
 * Kelas Kopi merepresentasikan resep untuk satu jenis kopi.
 * Isinya adalah informasi harga dan bahan yang dibutuhkan.
 */
public class Kopi {
    private String nama;
    private int hargaKecil;
    private int hargaBesar;
    private int butuhKopi; // Takaran biji kopi
    private int butuhSusu;  // Takaran susu, 0 jika tidak pakai

    public Kopi(String nama, int hargaKecil, int hargaBesar, int butuhKopi, int butuhSusu) {
        this.nama = nama;
        this.hargaKecil = hargaKecil;
        this.hargaBesar = hargaBesar;
        this.butuhKopi = butuhKopi;
        this.butuhSusu = butuhSusu;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga(String ukuran) {
        if (ukuran.equalsIgnoreCase("Kecil")) {
            return hargaKecil;
        } else {
            return hargaBesar;
        }
    }

    public int getKebutuhanKopi() {
        return butuhKopi;
    }
    
    public int getKebutuhanSusu() {
        return butuhSusu;
    }
}