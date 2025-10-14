import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VendingMachine {
    private ArrayList<Produk> daftarProduk;
    private ArrayList<String> logTransaksi;

    public VendingMachine() {
        daftarProduk = new ArrayList<>();
        logTransaksi = new ArrayList<>();
    }

    public void tambahProduk(Produk produk) {
        daftarProduk.add(produk);
    }

    public void tampilkanMenu() {
        System.out.println("SELAMAT DATANG DI SNACK VENDING MACHINE");
        System.out.println("Berikut daftar menu yang tersedia >>");
        for (int i = 0; i < daftarProduk.size(); i++) {
            Produk p = daftarProduk.get(i);
            String statusStok = (p.getStok() > 0) ? "Stok: " + p.getStok() : "Stok: HABIS";
            System.out.println((i + 1) + ". " + p.getNama() + " - Rp " + p.getHarga() + " (" + statusStok + ")");
        }
        System.out.println();
    }

    public void prosesTransaksi(int nomorProduk, int jumlahUang) {
        if (nomorProduk < 1 || nomorProduk > daftarProduk.size()) {
            System.out.println("Nomor produk tidak valid.");
            return;
        }

        Produk produkPilihan = daftarProduk.get(nomorProduk - 1);

        if (produkPilihan.getStok() <= 0) {
            System.out.println("Maaf, stok " + produkPilihan.getNama() + " sedang habis.");
            return;
        }

        if (jumlahUang >= produkPilihan.getHarga()) {
            int kembalian = jumlahUang - produkPilihan.getHarga();
            produkPilihan.kurangiStok(); 
            catatLog(produkPilihan); 

            System.out.println("\nPembayaran berhasil!");
            System.out.println("Produk '" + produkPilihan.getNama() + "' telah dikeluarkan.");
            System.out.println("Uang kembalian Anda: Rp " + kembalian);
            System.out.println("Terima kasih, silakan ambil produk Anda.\n");
        } else {
            System.out.println("\nMaaf, uang Anda tidak cukup.");
            System.out.println("Uang Anda sebesar Rp " + jumlahUang + " telah dikembalikan.");
        }
    }
    public void isiUlangStok(int nomorProduk, int jumlah) {
        if (nomorProduk >= 1 && nomorProduk <= daftarProduk.size()) {
            Produk produk = daftarProduk.get(nomorProduk - 1);
            produk.tambahStok(jumlah);
            System.out.println("Stok " + produk.getNama() + " berhasil diisi ulang. Stok sekarang: " + produk.getStok() + ".");
        } else {
            System.out.println("Nomor produk tidak valid.");
        }
    }

    private void catatLog(Produk produk) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String log = "- Pembelian '" + produk.getNama() + "' seharga Rp " + produk.getHarga() + " pada " + dtf.format(now);
        logTransaksi.add(log);
    }

    public void tampilkanLogTransaksi() {
        System.out.println("\n--- Log Transaksi ---");
        if (logTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (String log : logTransaksi) {
                System.out.println(log);
            }
        }
        System.out.println("---------------------");
    }
}