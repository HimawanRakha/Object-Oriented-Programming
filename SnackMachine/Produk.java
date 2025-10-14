public class Produk {
    private String nama;
    private int harga;
    private int stok;

    public Produk(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok() {
        if (stok > 0) {
            stok--;
        }
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }
}