import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

public class Responder
{
    private HashMap<String, String> responseMap;
    private ArrayList<String> defaultResponses;
    private Random randomGenerator;

    public Responder()
    {
        responseMap = new HashMap<>();
        defaultResponses = new ArrayList<>();
        fillResponseMap();
        fillDefaultResponses();
        randomGenerator = new Random();
    }

    public String generateResponse(HashSet<String> words, String fullInput)
    {
        // 1️⃣ Periksa apakah fullInput mengandung salah satu key di responseMap
        for (String key : responseMap.keySet()) {
            if (fullInput.contains(key)) {
                return responseMap.get(key);
            }
        }

        // 2️⃣ Jika tidak, periksa kata per kata (fallback)
        for (String word : words) {
            String response = responseMap.get(word);
            if (response != null) {
                return response;
            }
        }

        // 3️⃣ Jika tidak ada yang cocok, kembalikan default response
        return pickDefaultResponse();
    }

    private void fillResponseMap()
    {
        responseMap.put("gabisa akses frs", 
                "Mungkin ini masalah pada device Anda. Pastikan koneksi internet stabil dan coba refresh kembali.\n" +
                "Jika ada permasalahan bisa dijelaskan lebih lanjut.");

        responseMap.put("frs belum disetujui", 
                "Silakan hubungi dosen wali dan lakukan konsultasi terlebih dahulu.\n" +
                "Jika ada permasalahan bisa dijelaskan lebih lanjut.");

        responseMap.put("kelas penuh", 
                "Mohon maaf kelas yang Anda pilih sudah penuh, silakan pilih kelas lain.\n" +
                "Jika ada permasalahan bisa dijelaskan lebih lanjut.");

        responseMap.put("jadwal tabrakan", 
                "Terjadi bentrok jadwal antara dua mata kuliah. Silakan ubah salah satu kelas atau pilih waktu lain yang tidak konflik.\n" +
                "Jika ada permasalahan bisa dijelaskan lebih lanjut.");

        responseMap.put("sistem down", 
                "Kami sedang melakukan pemeliharaan sistem FRS. Mohon tunggu beberapa saat dan coba kembali nanti.\n" +
                "Jika ada permasalahan bisa dijelaskan lebih lanjut.");

        responseMap.put("kelas tidak ditemukan", 
                "Nama atau kode kelas tidak dikenali. Pastikan ejaan sesuai data akademik.\n" +
                "Jika ada permasalahan bisa dijelaskan lebih lanjut.");

        responseMap.put("akses ditolak", 
                "Anda tidak memiliki hak akses untuk fitur ini. Pastikan akun Anda aktif sebagai mahasiswa.\n" +
                "Jika ada permasalahan bisa dijelaskan lebih lanjut.");

        responseMap.put("sks melebihi", 
                "Jumlah SKS Anda melebihi batas maksimum semester ini. Kurangi mata kuliah agar sesuai aturan.\n" +
                "Jika ada permasalahan bisa dijelaskan lebih lanjut.");

        responseMap.put("prasyarat", 
                "Anda belum memenuhi prasyarat mata kuliah ini. Pastikan sudah lulus mata kuliah pendukungnya.\n" +
                "Jika ada permasalahan bisa dijelaskan lebih lanjut.");
                
        responseMap.put("tidak bisa ambil frs", 
                "Pastikan anda memenuhi persyaratan untuk bisa mengambil frs pada semester ini\n" +
                "Jika ada permasalahan bisa dijelaskan lebih lanjut.");
    }

    private void fillDefaultResponses()
    {
        defaultResponses.add("Terima kasih telah menghubungi tim teknis FRS. Bisa dijelaskan lebih detail kendalanya?");
        defaultResponses.add("Sejauh ini belum ada laporan serupa. Bisa informasikan perangkat dan browser yang Anda gunakan?");
        defaultResponses.add("Menarik, kami perlu informasi lebih lanjut terkait hal ini.");
        defaultResponses.add("Kami membutuhkan sedikit informasi tambahan agar dapat membantu Anda.");
        defaultResponses.add("Sudahkah Anda mencoba untuk logout dan login ulang atau membersihkan cache browser?");
        defaultResponses.add("Panduan mengenai hal ini ada di buku petunjuk FRS. Sudahkah Anda membacanya?");
        defaultResponses.add("Deskripsi kendala Anda masih agak umum. Apakah ada pihak yang bisa memberikan penjelasan teknis lebih rinci?");
        defaultResponses.add("Hal tersebut merupakan bagian dari sistem, bukan bug.");
        defaultResponses.add("Bisakah Anda jelaskan lebih lanjut mengenai kendala yang Anda alami?");
    }

    private String pickDefaultResponse()
    {
        int index = randomGenerator.nextInt(defaultResponses.size());
        return defaultResponses.get(index);
    }
}
