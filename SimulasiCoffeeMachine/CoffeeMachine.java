import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Kelas MesinKopi sebagai pengontrol utama.
 * Mengelola resep, stok bahan baku, dan transaksi.
 */
public class MesinKopi {
    private ArrayList<Kopi> daftarKopi;
    private ArrayList<String> logTransaksi;

    // Stok bahan baku
    private int stokBijiKopi;
    private int stokSusu;
    private int stokGula;
    private int stokCupKecil;
    private int stokCupBesar;

    public MesinKopi(int kopi, int susu, int gula, int cupKecil, int cupBesar) {
        this.daftarKopi = new ArrayList<>();
        this.logTransaksi = new ArrayList<>();
        this.stokBijiKopi = kopi;
        this.stokSusu = susu;
        this.stokGula = gula;
        this.stokCupKecil = cupKecil;
        this.stokCupBesar = cupBesar;
    }

    public void tambahKopi(Kopi resep) {
        daftarKopi.add(resep);
    }
    
    public ArrayList<Kopi> getDaftarKopi() {
        return daftarKopi;
    }

    public void tampilkanMenu() {
        System.out.println("===== MENU KOPI HARI INI =====");
        for (int i = 0; i < daftarKopi.size(); i++) {
            Kopi k = daftarKopi.get(i);
            System.out.printf("%d. %-15s | Ukuran Kecil: Rp %d | Ukuran Besar: Rp %d\n", 
                              (i + 1), k.getNama(), k.getHarga("Kecil"), k.getHarga("Besar"));
        }
        System.out.println();
    }
    
    public void tampilkanStatusStok() {
        System.out.println("\n--- Status Stok Bahan Baku ---");
        System.out.println("Biji Kopi : " + stokBijiKopi + " unit");
        System.out.println("Susu      : " + stokSusu + " unit");
        System.out.println("Gula      : " + stokGula + " unit");
        System.out.println("Cup Kecil : " + stokCupKecil + " pcs");
        System.out.println("Cup Besar : " + stokCupBesar + " pcs");
        System.out.println("------------------------------");
    }

    // Metode untuk memeriksa ketersediaan semua bahan
    private boolean cekStokBahan(Kopi kopi, String ukuran, boolean pakaiGula) {
        boolean cukup = true;
        if (stokBijiKopi < kopi.getKebutuhanKopi()) {
            System.out.println("ADMIN ALERT: Stok biji kopi tidak cukup!");
            cukup = false;
        }
        if (stokSusu < kopi.getKebutuhanSusu()) {
            System.out.println("ADMIN ALERT: Stok susu tidak cukup!");
            cukup = false;
        }
        if (pakaiGula && stokGula < 1) {
            System.out.println("ADMIN ALERT: Stok gula habis!");
            cukup = false;
        }
        if (ukuran.equalsIgnoreCase("Kecil") && stokCupKecil < 1) {
            System.out.println("ADMIN ALERT: Stok cup kecil habis!");
            cukup = false;
        }
        if (ukuran.equalsIgnoreCase("Besar") && stokCupBesar < 1) {
            System.out.println("ADMIN ALERT: Stok cup besar habis!");
            cukup = false;
        }
        return cukup;
    }

    public void prosesPesanan(int nomorKopi, String ukuran, boolean pakaiGula, int jumlahUang) {
        if (nomorKopi < 1 || nomorKopi > daftarKopi.size()) {
            System.out.println("Nomor kopi tidak valid.");
            return;
        }
        Kopi kopiPilihan = daftarKopi.get(nomorKopi - 1);
        int harga = kopiPilihan.getHarga(ukuran);
        
        System.out.println("Total harga: Rp " + harga);

        if (jumlahUang < harga) {
            System.out.println("Maaf, uang Anda tidak cukup. Uang dikembalikan.");
            return;
        }
        
        if (!cekStokBahan(kopiPilihan, ukuran, pakaiGula)) {
            System.out.println("Mohon maaf, bahan baku untuk pesanan Anda tidak mencukupi.");
            return;
        }
        
        // Jika semua OK, kurangi stok
        stokBijiKopi -= kopiPilihan.getKebutuhanKopi();
        stokSusu -= kopiPilihan.getKebutuhanSusu();
        if (pakaiGula) stokGula--;
        if (ukuran.equalsIgnoreCase("Kecil")) stokCupKecil--;
        else stokCupBesar--;
        
        // Proses pesanan
        System.out.println("\nPembayaran diterima. Kopi sedang dibuat...");
        System.out.println("Silakan ambil " + kopiPilihan.getNama() + " ukuran " + ukuran + " Anda.");
        System.out.println("Kembalian Anda: Rp " + (jumlahUang - harga));
        
        // Catat ke log
        String detailPesanan = kopiPilihan.getNama() + " [" + ukuran + "]" 
                             + (pakaiGula ? " (Pakai Gula)" : " (Tanpa Gula)");
        catatLog(detailPesanan, harga);
    }
    
    public void isiUlangStok(String bahan, int jumlah) {
        switch (bahan.toLowerCase()) {
            case "kopi": stokBijiKopi += jumlah; break;
            case "susu": stokSusu += jumlah; break;
            case "gula": stokGula += jumlah; break;
            case "cupkecil": stokCupKecil += jumlah; break;
            case "cupbesar": stokCupBesar += jumlah; break;
            default: System.out.println("Nama bahan tidak dikenal."); return;
        }
        System.out.println("Stok " + bahan + " berhasil ditambah sebanyak " + jumlah + ".");
    }
    
    private void catatLog(String detail, int harga) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String log = String.format("- Pesanan '%s' seharga Rp %d pada %s", detail, harga, dtf.format(LocalDateTime.now()));
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