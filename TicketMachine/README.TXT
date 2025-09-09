Proyek Mesin Tiket dengan Java & BlueJ
Ini adalah implementasi sederhana dari sebuah mesin tiket (Ticket Machine) yang dibuat menggunakan bahasa pemrograman Java dan dirancang untuk dijalankan pada IDE BlueJ. Proyek ini mensimulasikan fungsionalitas dasar mesin tiket, di mana pengguna dapat memasukkan uang, mencetak tiket, dan menerima kembalian.

Tujuan dari proyek ini adalah untuk memahami konsep dasar Pemrograman Berorientasi Objek (OOP) seperti class, object, method, constructor, dan encapsulation.

Fitur Utama
Harga Fleksibel: Harga tiket dapat ditentukan saat mesin (objek) pertama kali dibuat.

Validasi Input: Mesin hanya menerima nominal uang yang positif.

Transaksi Aman: Tiket hanya akan dicetak jika saldo yang dimasukkan oleh pengguna mencukupi.

Manajemen Saldo: Mesin dapat melacak saldo pengguna saat ini dan total uang yang terkumpul.

Pengembalian Uang: Pengguna dapat menarik kembali seluruh saldo yang telah dimasukkan sebelum tiket dicetak.

Penjelasan Kode: TicketMachine.java
Berikut adalah rincian dari setiap bagian kode yang ada di dalam class TicketMachine.

1. Atribut (Fields)
Atribut adalah variabel yang menyimpan data atau state dari sebuah objek. Class ini memiliki tiga atribut:

private int price;
private int balance;
private int total;

price: Menyimpan harga satu tiket. Nilainya diatur melalui constructor dan tidak akan berubah.

balance: Menyimpan jumlah uang yang telah dimasukkan oleh pengguna saat ini. Nilainya akan bertambah saat pengguna memasukkan uang dan berkurang saat tiket dicetak.

total: Menyimpan total akumulasi uang yang telah dikumpulkan oleh mesin dari semua tiket yang terjual.

2. Konstruktor (Constructor)
Konstruktor adalah method khusus yang dipanggil saat sebuah objek baru dibuat. Fungsinya adalah untuk menginisialisasi nilai awal dari atribut.

public TicketMachine(int cost)
{
    price = cost;
    balance = 0;
    total = 0;
}

Ketika objek TicketMachine baru dibuat, kita harus memberikan nilai cost (harga tiket).

price akan diisi dengan nilai cost.

balance dan total diatur ke 0 karena mesin masih baru dan belum ada transaksi.

3. Metode (Methods)
Metode mendefinisikan perilaku atau aksi yang bisa dilakukan oleh objek.

getPrice() dan getBalance()
Kedua method ini adalah accessor methods (atau getters) yang berfungsi untuk mengembalikan nilai dari atribut privat.

public int getPrice()
{
    return price;
}

public int getBalance()
{
    return balance;
}

insertMoney(int amount)
Method ini digunakan untuk menambahkan uang ke dalam mesin.

public void insertMoney(int amount)
{
    if(amount > 0) {
        balance = balance + amount;
    }
    else {
        System.out.println("Use a positive amount rather than: " + amount);
    }
}

Method menerima parameter amount (jumlah uang yang dimasukkan).

Terdapat pengecekan: jika amount lebih besar dari 0, maka nilai balance akan ditambahkan.

Jika tidak, sebuah pesan error akan ditampilkan.

printTicket()
Method ini adalah inti dari fungsionalitas mesin. Fungsinya untuk mencetak tiket.

public void printTicket()
{
    if(balance >= price) {
        // ... (kode untuk mencetak tiket) ...

        total = total + price;
        balance = balance - price;
    }
    else {
        int amountLeftToPay = price - balance;
        System.out.println("You must insert at least: " + amountLeftToPay + " more cents.");
    }
}

Pertama, method ini memeriksa apakah balance (saldo saat ini) cukup untuk membeli tiket (>= price).

Jika cukup:

Sebuah "tiket" disimulasikan dengan mencetak beberapa baris teks ke konsol.

total uang yang terkumpul diperbarui.

balance dikurangi seharga tiket.

Jika tidak cukup: Pesan error akan ditampilkan, memberitahu pengguna berapa banyak uang lagi yang dibutuhkan.

refundBalance()
Method ini memungkinkan pengguna untuk mengambil kembali semua uang yang telah mereka masukkan.

public int refundBalance()
{
    int amountToRefund;
    amountToRefund = balance;
    balance = 0;
    return amountToRefund;
}

Nilai balance saat ini disimpan dalam variabel sementara amountToRefund.

balance direset kembali menjadi 0.

Jumlah uang yang dikembalikan (amountToRefund) dikirim sebagai nilai balik dari method ini.

Cara Menjalankan di BlueJ
Buka proyek di BlueJ dan kompilasi class TicketMachine.

Klik kanan pada class, pilih new TicketMachine(int cost) dan masukkan harga tiket (misal: 500).

Sebuah objek akan muncul di bagian bawah. Klik kanan pada objek tersebut untuk memanggil method-method yang ada dan menguji fungsionalitasnya.