import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Kelas utama untuk menjalankan aplikasi Mesin Kopi secara interaktif.
 */
public class AplikasiMesinKopi {

    public static void main(String[] args) {
        // Inisialisasi mesin dengan stok awal bahan baku
        // (kopi, susu, gula, cupKecil, cupBesar)
        MesinKopi mesin = new MesinKopi(100, 80, 100, 50, 50);
        
        // Menambahkan resep-resep kopi ke dalam mesin
        // (nama, hargaKecil, hargaBesar, butuhKopi, butuhSusu)
        mesin.tambahKopi(new Kopi("Espresso", 5000, 7000, 7, 0));
        mesin.tambahKopi(new Kopi("Americano", 6000, 8000, 7, 0));
        mesin.tambahKopi(new Kopi("Cappuccino", 10000, 12000, 7, 5));
        mesin.tambahKopi(new Kopi("Latte", 10000, 12000, 7, 8));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MESIN KOPI OTOMATIS =====");
            System.out.println("1. Pesan Kopi");
            System.out.println("2. Login Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");

            try {
                int pilihan = scanner.nextInt();
                switch (pilihan) {
                    case 1: menuPemesanan(mesin, scanner); break;
                    case 2: menuAdmin(mesin, scanner); break;
                    case 3: System.out.println("Terima kasih!"); scanner.close(); return;
                    default: System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input salah, harap masukkan angka.");
                scanner.next(); // clear buffer
            }
        }
    }

    public static void menuPemesanan(MesinKopi mesin, Scanner scanner) {
        mesin.tampilkanMenu();
        try {
            System.out.print("Pilih nomor kopi: ");
            int noKopi = scanner.nextInt();

            System.out.print("Pilih ukuran (Kecil/Besar): ");
            String ukuran = scanner.next();
            if (!ukuran.equalsIgnoreCase("Kecil") && !ukuran.equalsIgnoreCase("Besar")) {
                System.out.println("Pilihan ukuran tidak valid.");
                return;
            }

            System.out.print("Tambah gula? (Y/T): ");
            boolean pakaiGula = scanner.next().equalsIgnoreCase("Y");

            System.out.print("Masukkan jumlah uang: ");
            int uang = scanner.nextInt();

            mesin.prosesPesanan(noKopi, ukuran, pakaiGula, uang);
        } catch (InputMismatchException e) {
            System.out.println("Input salah, harap masukkan sesuai format.");
            scanner.next(); // clear buffer
        }
    }

    public static void menuAdmin(MesinKopi mesin, Scanner scanner) {
        System.out.print("Masukkan password: ");
        if (scanner.next().equals("admin123")) {
            while (true) {
                System.out.println("\n--- Menu Admin ---");
                System.out.println("1. Cek Stok Bahan Baku");
                System.out.println("2. Isi Ulang Stok");
                System.out.println("3. Lihat Log Transaksi");
                System.out.println("4. Kembali");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();

                if (pilihan == 1) {
                    mesin.tampilkanStatusStok();
                } else if (pilihan == 2) {
                    System.out.print("Nama bahan (kopi, susu, gula, cupkecil, cupbesar): ");
                    String bahan = scanner.next();
                    System.out.print("Jumlah tambahan: ");
                    int jumlah = scanner.nextInt();
                    mesin.isiUlangStok(bahan, jumlah);
                } else if (pilihan == 3) {
                    mesin.tampilkanLogTransaksi();
                } else if (pilihan == 4) {
                    break;
                }
            }
        } else {
            System.out.println("Password salah.");
        }
    }
}