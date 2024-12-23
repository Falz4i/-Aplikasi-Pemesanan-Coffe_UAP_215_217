# -Aplikasi-Pemesanan-Coffe_UAP_215_217

# Coffee Ordering App

Aplikasi **Coffee Ordering App** adalah program berbasis Java untuk pemesanan minuman dan makanan di kafe. Aplikasi ini menawarkan antarmuka grafis interaktif dan fitur seperti pemilihan kategori menu, pengelolaan pesanan, dan opsi pembayaran.

## Fitur Utama

- **Kategori Menu**:
    - **Coffee**: Menu kopi seperti Espresso, Americano, Cappuccino, dll.
    - **Non-Coffee**: Minuman non-kopi seperti Green Tea Latte, Milkshake, dll.
    - **Snacks**: Camilan seperti French Fries, Onion Rings, dll.

- **Manajemen Pesanan**:
    - Tambahkan item ke daftar pesanan.
    - Hapus item tertentu dari daftar pesanan.
    - Hapus semua pesanan sekaligus.

- **Checkout**:
    - Pilih jenis pesanan: **Dine In** atau **Take Away**.
    - Pilih metode pembayaran: **Cash**, **Credit Card**, atau **E-Wallet**.
    - Total harga termasuk pajak (12%) dihitung dan ditampilkan bersama detail pesanan.

- **Tampilan GUI**:
    - Antarmuka pengguna sederhana dan interaktif menggunakan Java Swing.
    - Gambar produk, nama, harga, dan tombol "Pesan" untuk setiap item menu.

## Teknologi yang Digunakan

- **Java** (JDK 8 atau lebih baru)
- **Swing** untuk antarmuka pengguna grafis.

## Struktur Proyek

```plaintext
CoffeeOrderingApp/
├── src/
│   ├── CoffeeOrderingApp.java     # File utama aplikasi
│   ├── Coffee.java                # Kelas untuk representasi item menu
│   └── assets/                    # Folder gambar produk (pastikan jalur file sudah benar)


Cara Menjalankan
1. Persiapan Lingkungan
Pastikan Java Development Kit (JDK) sudah terinstal di komputer Anda.
Gunakan IDE seperti IntelliJ IDEA, Eclipse, atau NetBeans untuk menjalankan proyek.
2. Menjalankan Program
Buka file CoffeeOrderingApp.java.
Pastikan semua gambar produk berada di jalur file yang disebutkan dalam kode (contoh: D:\\JAVA MODUL\\SEMESTER 3\\UAP\\src\\Gambar\\).
Jalankan program menggunakan IDE atau perintah berikut di terminal:
javac CoffeeOrderingApp.java
java CoffeeOrderingApp

Cara Penggunaan
Pilih kategori menu (Coffee, Non-Coffee, atau Snacks) dari bagian atas aplikasi.
Klik tombol "Pesan" pada item yang ingin dipesan.
Lihat daftar pesanan Anda di panel sebelah kanan.
Gunakan tombol Remove Item untuk menghapus item tertentu.
Gunakan tombol Clear All untuk menghapus semua item.
Klik Checkout untuk menyelesaikan pesanan.
Pilih jenis pesanan: Dine In atau Take Away.
Pilih metode pembayaran: Cash, Credit Card, atau E-Wallet.
Lihat detail pesanan dan total harga yang termasuk pajak.
Catatan Penting
Pastikan jalur file gambar pada kode (D:\\JAVA MODUL\\SEMESTER 3\\UAP\\src\\Gambar\\) sesuai dengan lokasi gambar pada komputer Anda.
Harga harus ditulis dalam format string seperti "25,000". Program akan memprosesnya secara otomatis.
Semua pesanan akan diatur ulang setelah selesai checkout.
Pengembangan Lebih Lanjut
Berikut adalah beberapa ide pengembangan:
Tambahkan fitur penyimpanan data transaksi menggunakan database.
Integrasikan metode pembayaran online.
Tambahkan sistem autentikasi untuk pengguna atau karyawan.