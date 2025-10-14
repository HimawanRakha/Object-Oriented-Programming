import java.util.Scanner;
import java.util.InputMismatchException;

public class AplikasiVendingMachine {

    public static void main(String[] args) {
        VendingMachine mesin = new VendingMachine();
        mesin.tambahProduk(new Produk("Wafer Cokelat", 2000, 10));
        mesin.tambahProduk(new Produk("Keripik Kentang", 3000, 8));
        mesin.tambahProduk(new Produk("Minuman Soda", 5000, 5));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n MENU APLIKASI  SNACK VENDING MACHINE");
            System.out.println("1. Beli Produk");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar dari Aplikasi");
            System.out.print("Pilih menu (1-3): ");

            try {
                int pilihanMenu = scanner.nextInt();

                switch (pilihanMenu) {
                    case 1:
                        menuPembelian(mesin, scanner);
                        break;
                    case 2:
                        menuAdmin(mesin, scanner);
                        break;
                    case 3:
                        System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                        scanner.close(); 
                        return; 
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.next(); 
            }
        }
    }

    public static void menuPembelian(VendingMachine mesin, Scanner scanner) {
        mesin.tampilkanMenu();
        
        try {
            System.out.print("Masukkan nomor produk yang ingin Anda beli: ");
            int nomorProduk = scanner.nextInt();

            System.out.print("Silakan masukkan uang Anda: ");
            int jumlahUang = scanner.nextInt();

            mesin.prosesTransaksi(nomorProduk, jumlahUang);

        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid! Harap masukkan angka untuk nomor produk dan jumlah uang.");
            scanner.next(); 
        }
    }

    public static void menuAdmin(VendingMachine mesin, Scanner scanner) {
        System.out.print("Masukkan password admin: ");
        String password = scanner.next();
        if (password.equals("rakha")) {
            System.out.println("Login admin berhasil!");
            
            while (true) {
                System.out.println("\nMenu Admin");
                System.out.println("1. Isi Ulang Stok");
                System.out.println("2. Lihat Log Transaksi");
                System.out.println("3. Kembali ke Menu Utama");
                System.out.print("Pilih menu (1-3): ");
                
                try {
                    int pilihanAdmin = scanner.nextInt();
                    if (pilihanAdmin == 1) {
                        mesin.tampilkanMenu();
                        System.out.print("Pilih nomor produk yang akan diisi ulang: ");
                        int noProduk = scanner.nextInt();
                        System.out.print("Masukkan jumlah stok tambahan: ");
                        int jumlah = scanner.nextInt();
                        mesin.isiUlangStok(noProduk, jumlah);
                    } else if (pilihanAdmin == 2) {
                        mesin.tampilkanLogTransaksi();
                    } else if (pilihanAdmin == 3) {
                        break; 
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid! Harap masukkan angka.");
                    scanner.next(); 
                }
            }
        } else {
            System.out.println("Password salah. Akses ditolak.");
        }
    }
}