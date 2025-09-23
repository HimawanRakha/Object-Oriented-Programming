/**
 * Class utama untuk menjalankan simulasi sistem akademik.
 */
public class SistemAkademik {
    public static void main(String[] args) {
        // 1. Buat beberapa objek Dosen
        Dosen dosenTI = new Dosen("Dr. Budi Hartono", "198203102008011001", "Rekayasa Perangkat Lunak");
        Dosen dosenSI = new Dosen("Dr. Citra Dewi", "198507202010012002", "Sistem Informasi Manajemen");

        // 2. Buat beberapa objek Mahasiswa
        Mahasiswa mhs1 = new Mahasiswa("Andi Wijaya", "225150200111001", "Teknik Informatika");
        Mahasiswa mhs2 = new Mahasiswa("Rina Sari", "235150400111002", "Sistem Informasi");

        // 3. Buat beberapa objek Mata Kuliah dan hubungkan dengan Dosen
        MataKuliah mkPBO = new MataKuliah("TIF101", "Pemrograman Berorientasi Objek", 3, dosenTI);
        MataKuliah mkSIM = new MataKuliah("SIF202", "Manajemen Sistem Informasi", 3, dosenSI);
        MataKuliah mkBasisData = new MataKuliah("TIF102", "Sistem Basis Data", 3, dosenTI);
        
        System.out.println(">>> PROSES PENGAMBILAN MATA KULIAH <<< \n");
        
        // 4. Mahasiswa mengambil mata kuliah
        // Andi mengambil PBO dan Basis Data
        mhs1.tambahMataKuliah(mkPBO);
        mhs1.tambahMataKuliah(mkBasisData);
        
        // Rina mengambil PBO dan SIM
        mhs2.tambahMataKuliah(mkPBO);
        mhs2.tambahMataKuliah(mkSIM);
        
        System.out.println("Proses pengambilan mata kuliah selesai. \n");
        
        System.out.println(">>> CETAK KARTU RENCANA STUDI (KRS) <<< \n");
        
        // 5. Tampilkan KRS masing-masing mahasiswa
        mhs1.lihatKRS();
        System.out.println(); // Beri spasi
        mhs2.lihatKRS();
        System.out.println();
        
        System.out.println(">>> LIHAT DAFTAR PESERTA MATA KULIAH <<< \n");

        // 6. Tampilkan daftar mahasiswa di setiap mata kuliah
        mkPBO.info();
        System.out.println();
        mkSIM.info();
        System.out.println();
        mkBasisData.info();
    }
}