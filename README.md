Berikut adalah README yang telah ditambahkan bagian **Testing** dan **Code Review** dengan format Markdown yang rapi:

---

# Aplikasi Pemesanan Coffee - UAP 215_217

Aplikasi **Coffee Ordering App** adalah program berbasis Java untuk pemesanan minuman dan makanan di kafe. Aplikasi ini menawarkan antarmuka grafis interaktif dan fitur seperti pemilihan kategori menu, pengelolaan pesanan, dan opsi pembayaran.

---

## 📌 Fitur Utama

1. **Kategori Menu**:
  - **Coffee**: Menu kopi seperti Espresso, Americano, Cappuccino, dll.
  - **Non-Coffee**: Minuman non-kopi seperti Green Tea Latte, Milkshake, dll.
  - **Snacks**: Camilan seperti French Fries, Onion Rings, dll.

2. **Manajemen Pesanan**:
  - Tambahkan item ke daftar pesanan.
  - Hapus item tertentu dari daftar pesanan.
  - Hapus semua pesanan sekaligus.

3. **Checkout**:
  - Pilih jenis pesanan: **Dine In** atau **Take Away**.
  - Pilih metode pembayaran: **Cash**, **Credit Card**, atau **E-Wallet**.
  - Total harga termasuk pajak (12%) dihitung dan ditampilkan bersama detail pesanan.

4. **Tampilan GUI**:
  - Antarmuka pengguna sederhana dan interaktif menggunakan Java Swing.
  - Gambar produk, nama, harga, dan tombol "Pesan" untuk setiap item menu.

---

## ⚙️ Teknologi yang Digunakan

- **Java** (JDK 8 atau lebih baru)
- **Swing** untuk antarmuka pengguna grafis

---

## 📂 Struktur Proyek

```plaintext
CoffeeOrderingApp/
├── src/
│   ├── CoffeeOrderingApp.java     # File utama aplikasi
│   ├── Coffee.java                # Kelas untuk representasi item menu
│   └── assets/                    # Folder gambar produk (pastikan jalur file sudah benar)
```

---

## 🚀 Cara Menjalankan

### 1. Persiapan Lingkungan
- Pastikan **Java Development Kit (JDK)** sudah terinstal di komputer Anda.
- Gunakan IDE seperti **IntelliJ IDEA**, **Eclipse**, atau **NetBeans** untuk menjalankan proyek.

### 2. Menjalankan Program
1. Buka file `CoffeeOrderingApp.java`.
2. Pastikan semua gambar produk berada di jalur file yang disebutkan dalam kode (contoh: `D:\\JAVA MODUL\\SEMESTER 3\\UAP\\src\\Gambar\\`).
3. Jalankan program menggunakan IDE atau perintah berikut di terminal:

   ```bash
   javac CoffeeOrderingApp.java
   java CoffeeOrderingApp
   ```

---

## 🛠️ Cara Penggunaan

1. Pilih kategori menu (Coffee, Non-Coffee, atau Snacks) dari bagian atas aplikasi.
2. Klik tombol **"Pesan"** pada item yang ingin dipesan.
3. Lihat daftar pesanan Anda di panel sebelah kanan:
  - Gunakan tombol **Remove Item** untuk menghapus item tertentu.
  - Gunakan tombol **Clear All** untuk menghapus semua item.
4. Klik **Checkout** untuk menyelesaikan pesanan:
  - Pilih jenis pesanan: **Dine In** atau **Take Away**.
  - Pilih metode pembayaran: **Cash**, **Credit Card**, atau **E-Wallet**.
5. Lihat detail pesanan dan total harga yang termasuk pajak.

---

## ✅ Testing

### 1. Pengujian GUI
**Tujuan**: Memastikan antarmuka pengguna bekerja dengan baik dan elemen-elemen tampil sesuai.

**Langkah**:
1. Jalankan aplikasi.
2. Periksa apakah panel kategori (`Coffee`, `Non-Coffee`, `Snacks`) muncul di bagian atas.
3. Klik setiap kategori dan pastikan item yang sesuai ditampilkan.
4. Periksa apakah gambar, nama, harga, dan tombol "Pesan" tampil dengan benar untuk setiap item.

---

### 2. Pengujian Fungsionalitas Pesanan
**Tujuan**: Memastikan penambahan, penghapusan, dan pengaturan ulang pesanan berjalan sesuai.

**Langkah**:
1. Tambahkan beberapa item dari berbagai kategori.
2. Periksa apakah item yang ditambahkan muncul di daftar pesanan.
3. Hapus item tertentu dari daftar pesanan, dan pastikan total harga diperbarui.
4. Klik tombol "Clear All" dan pastikan semua item dihapus.

---

### 3. Pengujian Checkout
**Tujuan**: Memastikan proses checkout berfungsi dengan benar.

**Langkah**:
1. Tambahkan item ke daftar pesanan.
2. Klik "Checkout".
3. Pilih jenis pesanan (**Dine In** atau **Take Away**).
4. Pilih metode pembayaran (**Cash**, **Credit Card**, atau **E-Wallet**).
5. Periksa apakah dialog pembayaran menampilkan detail pesanan, subtotal, pajak, dan total harga dengan benar.

---

## 🔍 Code Review

### 1. Struktur Kode
- **Kelebihan**:
  - Kode memiliki struktur yang terorganisir dengan baik.
  - Metode `loadCategory` modular dan dapat diperluas.
- **Saran**:
  - Buat kelas `Coffee` lebih deskriptif dengan dokumentasi atau komentar.
  - Pisahkan logika GUI dan bisnis dalam proyek.

---

### 2. Pengelolaan Gambar
- **Kelebihan**:
  - Setiap item memiliki gambar yang memberikan pengalaman pengguna lebih baik.
- **Saran**:
  - Hindari jalur file absolut. Gunakan jalur relatif dengan folder `assets/`.

---

### 3. Validasi Input
- **Kelebihan**:
  - Program memvalidasi daftar pesanan sebelum checkout.
- **Saran**:
  - Perlu validasi tambahan untuk input non-valid, terutama harga.

---

### 4. Penggunaan Harga
- **Kelebihan**:
  - Harga diformat untuk penampilan yang lebih menarik.
- **Saran**:
  - Simpan harga sebagai tipe `double` dalam kelas `Coffee` untuk menghindari parsing string.

---

## ❗ Catatan Penting

- Pastikan jalur file gambar pada kode (`D:\\JAVA MODUL\\SEMESTER 3\\UAP\\src\\Gambar\\`) sesuai dengan lokasi gambar pada komputer Anda.
- Harga harus ditulis dalam format string seperti `"25,000"`. Program akan memprosesnya secara otomatis.
- Semua pesanan akan diatur ulang setelah selesai checkout.

---

## 🔮 Pengembangan Lebih Lanjut

Berikut adalah beberapa ide pengembangan untuk aplikasi ini:
1. Tambahkan fitur penyimpanan data transaksi menggunakan database.
2. Integrasikan metode pembayaran online.
3. Tambahkan sistem autentikasi untuk pengguna atau karyawan.

---
