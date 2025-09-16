

PROJECT TITLE:
Digital Clock Application

PURPOSE OF PROJECT:
Proyek ini bertujuan untuk membuat aplikasi jam digital sederhana menggunakan prinsip Object-Oriented Programming (OOP). Program ini menampilkan waktu saat ini, memperbarui tampilan setiap detik, dan menerapkan konsep OOP seperti enkapsulasi, pewarisan (inheritance), serta penggunaan objek dan kelas.




AUTHORS:
Himawan Rakha

USER INSTRUCTIONS:
- Jalankan program untuk menampilkan jam digital yang akan diperbarui otomatis setiap detik.
- Anda dapat memodifikasi kode untuk menambah fitur seperti alarm atau stopwatch.

--------------------------------------------------------------------------------
PENJELASAN KODE:
--------------------------------------------------------------------------------
Struktur kode terdiri dari beberapa bagian utama:

1. **Class Clock**
   - Bertugas menyimpan dan mengelola waktu (jam, menit, detik).
   - Memiliki method untuk meng-update dan menampilkan waktu secara real-time.
   - Menggunakan timer atau loop untuk memperbarui waktu setiap detik.

2. **Class Main (atau Main Function)**
   - Menjadi entry point program.
   - Membuat objek dari class Clock.
   - Menjalankan fungsi utama untuk menampilkan dan memperbarui jam pada layar.

3. **Konsep OOP yang digunakan:**
   - Encapsulation: Data jam, menit, dan detik disimpan dalam objek dan hanya bisa diakses melalui method yang disediakan.
   - Inheritance (jika ada subclass, misal DigitalClock/AnalogClock): Dapat digunakan untuk mengembangkan jenis jam lain dengan mewarisi class Clock.
   - Polymorphism: Method yang bisa di-override pada subclass untuk tampilan atau perilaku yang berbeda.

4. **Alur Program:**
   - Program dijalankan dari fungsi utama.
   - Objek Clock dibuat, lalu mulai loop atau timer untuk memperbarui waktu setiap detik.
   - Waktu ditampilkan ke user, baik melalui console atau GUI sederhana.

--------------------------------------------------------------------------------
Contoh kode (pseudo-code):
--------------------------------------------------------------------------------
```java
class Clock {
    private int hour;
    private int minute;
    private int second;

    public void updateTime() {
        // Update waktu dari sistem setiap detik
    }

    public void displayTime() {
        // Tampilkan waktu ke layar
    }
}

public class Main {
    public static void main(String[] args) {
        Clock clock = new Clock();
        while (true) {
            clock.updateTime();
            clock.displayTime();
            // Tunggu 1 detik
        }
    }
}
```
--------------------------------------------------------------------------------

Dengan struktur tersebut, Anda dapat mengembangkan aplikasi jam digital sederhana dan menambahkan fitur lain sesuai kebutuhan.
