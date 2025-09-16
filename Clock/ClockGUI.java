import javax.swing.*;
import java.awt.*;
import java.time.LocalDate; // Diperlukan untuk mendapatkan tanggal
import java.time.LocalTime;

/**
 * Kelas ClockGUI menyediakan antarmuka grafis (GUI) untuk menampilkan jam,
 * tanggal, dan suhu.
 *
 * @author (Your Name)
 * @version (a version number or a date)
 */
public class ClockGUI extends JFrame {

    private ClockDisplay clockLogic;
    private JLabel timeLabel;
    private JLabel dateLabel; // DITAMBAHKAN: Label untuk tanggal
    private JLabel tempLabel; // DITAMBAHKAN: Label untuk suhu

    public ClockGUI() {
        clockLogic = new ClockDisplay();

        setTitle("Jam Digital Lengkap");
        setSize(450, 200); // DIPERBARUI: Jendela dibuat sedikit lebih tinggi
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- Inisialisasi dan Konfigurasi Komponen ---
        // Label untuk Jam (tengah, besar)
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 60));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Label untuk Tanggal (kecil)
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        
        // Label untuk Suhu (kecil)
        tempLabel = new JLabel();
        tempLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        // --- Pengaturan Tata Letak (Layout) ---
        // Frame utama menggunakan BorderLayout
        setLayout(new BorderLayout());

        // Buat panel baru untuk bagian bawah
        JPanel bottomPanel = new JPanel(new BorderLayout());
        // Beri sedikit jarak/padding di sekitar panel bawah
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // Masukkan label tanggal dan suhu ke panel bawah
        bottomPanel.add(dateLabel, BorderLayout.WEST);  // WEST = Kiri
        bottomPanel.add(tempLabel, BorderLayout.EAST); // EAST = Kanan
        
        // Tambahkan semua komponen ke frame utama
        add(timeLabel, BorderLayout.CENTER);  // Jam di tengah
        add(bottomPanel, BorderLayout.SOUTH); // Panel bawah (berisi tanggal & suhu) di bagian bawah

        startClock();
    }

    private void startClock() {
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    /**
     * Memperbarui semua informasi (jam, tanggal, suhu) setiap detik.
     */
    private void updateTime() {
        // 1. Ambil data waktu dan tanggal saat ini dari sistem
        LocalTime nowTime = LocalTime.now();
        LocalDate nowDate = LocalDate.now();
        
        // (Untuk contoh ini, kita gunakan suhu statis)
        double currentTemp = 29.5; 

        // 2. Kirim data terbaru ke objek logika jam
        clockLogic.setTime(nowTime.getHour(), nowTime.getMinute(), nowTime.getSecond());
        clockLogic.setDate(nowDate.getDayOfMonth(), nowDate.getMonthValue(), nowDate.getYear());
        clockLogic.setTemperature(currentTemp);

        // 3. Ambil string yang sudah diformat dari objek logika
        String timeString = clockLogic.getTimeString();
        String dateString = clockLogic.getDateString();
        String tempString = clockLogic.getTempString();
        
        // 4. Tampilkan string tersebut ke setiap label di GUI
        timeLabel.setText(timeString);
        dateLabel.setText(dateString);
        tempLabel.setText(tempString);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClockGUI clockWindow = new ClockGUI();
            clockWindow.setVisible(true);
        });
    }
}