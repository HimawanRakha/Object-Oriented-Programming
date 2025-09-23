public class SistemAkademik {
    public static void main(String[] args) {
        // dosen
        Dosen dosenTI = new Dosen("Dr. Budi Hartono", "198203102008011001", "Rekayasa Perangkat Lunak");
        Dosen dosenSI = new Dosen("Dr. Citra Dewi", "198507202010012002", "Sistem Informasi Manajemen");

        // mahasiswa
        Mahasiswa mhs1 = new Mahasiswa("Andi Wijaya", "225150200111001", "Teknik Informatika");
        Mahasiswa mhs2 = new Mahasiswa("Rina Sari", "235150400111002", "Sistem Informasi");

        // mata kuliah
        MataKuliah mkPBO = new MataKuliah("TIF101", "Pemrograman Berorientasi Objek", 3, dosenTI);
        MataKuliah mkSIM = new MataKuliah("SIF202", "Manajemen Sistem Informasi", 3, dosenSI);
        MataKuliah mkBasisData = new MataKuliah("TIF102", "Sistem Basis Data", 3, dosenTI);
        
        System.out.println(">>> PROSES PENGAMBILAN MATA KULIAH <<< \n");
        
    //    ambil mata kuliah
        mhs1.tambahMataKuliah(mkPBO);
        mhs1.tambahMataKuliah(mkBasisData);
        mhs2.tambahMataKuliah(mkPBO);
        mhs2.tambahMataKuliah(mkSIM);
        
        System.out.println("Proses pengambilan mata kuliah selesai. \n");
        
        System.out.println(">>> CETAK KARTU RENCANA STUDI (KRS) <<< \n");
       
        mhs1.lihatKRS();
        System.out.println(); 
        mhs2.lihatKRS();
        System.out.println();
        
        System.out.println(">>> LIHAT DAFTAR PESERTA MATA KULIAH <<< \n");

        mkPBO.info();
        System.out.println();
        mkSIM.info();
        System.out.println();
        mkBasisData.info();
    }
}