# 🎟️ Proyek Mesin Tiket (Ticket Machine) - Java & BlueJ

Proyek ini adalah implementasi sederhana dari sebuah **mesin tiket (Ticket Machine)** menggunakan bahasa pemrograman **Java** dan dirancang untuk dijalankan pada IDE **BlueJ**.  

Program ini mensimulasikan fungsionalitas dasar mesin tiket, di mana pengguna dapat memasukkan uang, mencetak tiket, dan menerima kembalian.

---

## 🎯 Tujuan Proyek
Tujuan dari proyek ini adalah untuk memahami konsep dasar **Pemrograman Berorientasi Objek (OOP)** seperti:
- Class  
- Object  
- Method  
- Constructor  
- Encapsulation  

---

## ✨ Fitur Utama
- **Harga Fleksibel**: Harga tiket dapat ditentukan saat mesin (objek) pertama kali dibuat.  
- **Validasi Input**: Mesin hanya menerima nominal uang yang positif.  
- **Transaksi Aman**: Tiket hanya akan dicetak jika saldo yang dimasukkan pengguna mencukupi.  
- **Manajemen Saldo**: Mesin melacak saldo pengguna saat ini dan total uang yang terkumpul.  
- **Pengembalian Uang**: Pengguna dapat menarik kembali seluruh saldo yang telah dimasukkan sebelum tiket dicetak.  

---

## 📝 Penjelasan Kode: `TicketMachine.java`

### 1. Atribut (Fields)
Atribut menyimpan data atau state dari objek.  

```java
private int price;
private int balance;
private int total;
```
### 2. Konstruktor (Constructor)
Digunakan untuk inisialisasi nilai awal atribut.
```java
public TicketMachine(int cost)
{
    price = cost;
    balance = 0;
    total = 0;
}
```
### 3. Metode (Methods)
```java
public int getPrice()
{
    return price;
}
public int getBalance()
{
    return balance;
}
public void insertMoney(int amount)
{
    if(amount > 0) {
        balance = balance + amount;
    }
    else {
        System.out.println("Use a positive amount rather than: " + amount);
    }
}
public void printTicket()
{
    if(balance >= price) {
        // Simulasi cetak tiket
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();

        total = total + price;
        balance = balance - price;
    }
    else {
        int amountLeftToPay = price - balance;
        System.out.println("You must insert at least: " + amountLeftToPay + " more cents.");
    }
}
public int refundBalance()
{
    int amountToRefund;
    amountToRefund = balance;
    balance = 0;
    return amountToRefund;
}
```

