import java.util.ArrayList;

public class RentalManajemen {
    private ArrayList<Kendaraan> daftarKendaraan;
    private ArrayList<Penyewa> daftarPenyewa;

    public RentalManajemen() {
        daftarKendaraan = new ArrayList<>();
        daftarPenyewa = new ArrayList<>();

        inisialisasiData();
    }

    private void inisialisasiData() {

        daftarKendaraan.add(new Mobil("Toyota", "Avanza", 2022, 4));
        daftarKendaraan.add(new Mobil("Daihatsu", "Xenia", 2023, 4));
        daftarKendaraan.add(new Motor("Honda", "Vario 160", 2024, 2));
        daftarKendaraan.add(new Motor("Yamaha", "NMAX", 2023, 2));
        daftarKendaraan.add(new Sepeda("Polygon", "Strattos S5", 2023, "Balap"));
        daftarKendaraan.add(new Sepeda("Thrill", "Ricochet", 2022, "BMX"));

        daftarPenyewa.add(new Penyewa("Budi"));
        daftarPenyewa.add(new Penyewa("Ani"));
        daftarPenyewa.add(new Penyewa("Citra"));

        daftarPenyewa.get(0).sewaKendaraan(daftarKendaraan.get(0)); 
  
        daftarPenyewa.get(1).sewaKendaraan(daftarKendaraan.get(3));
        
  
        daftarPenyewa.get(2).sewaKendaraan(daftarKendaraan.get(0));
    }

   
    public void tampilkanKendaraanTersedia() {

        System.out.println("DAFTAR KENDARAAN YANG TERSEDIA");
        int count = 0;
       
        for (Kendaraan k : daftarKendaraan) {
            if (k.isAvailable()) {
              
                System.out.println("- " + k.getInfoDetail());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Tidak ada kendaraan yang tersedia saat ini.");
        }
    }

    public void tampilkanInfoPenyewa() {
        System.out.println("DAFTAR PENYEWA DAN KENDARAAN DISEWA");

        for (Penyewa p : daftarPenyewa) {
            System.out.println(p.getInfoRental());
            System.out.println("---"); 
        }
    }

    public static void main(String[] args) {
        RentalManajemen rental = new RentalManajemen();

        rental.tampilkanKendaraanTersedia();

        rental.tampilkanInfoPenyewa();
    }
}