# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi **marketplace jual-beli produk** menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input produk fisik dan digital (nama, penjual, tahun, harga, stok, tipe file untuk produk digital), lalu menyimpan, menampilkan, dan memungkinkan transaksi pembelian dengan stok yang berkurang otomatis.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overriding, Seleksi, Perulangan, IO Sederhana, ArrayList, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class**\
   Kode ini terdiri dari beberapa class: `Product`, `DigitalProduct`, `Marketplace`, dan `Main`.

   ```java
   class Product { ... }
   class DigitalProduct extends Product { ... }
   class Marketplace { ... }
   public class Main { ... }
   ```

2. **Object**\
   Objek dibuat menggunakan `new Product(...)`, `new DigitalProduct(...)`, dan `new Marketplace()`.

   ```java
   Product produk = new Product(...);
   DigitalProduct dProduk = new DigitalProduct(...);
   Marketplace zentra = new Marketplace();
   ```

3. **Atribut**\
   Contoh atribut di class `Product`: `name`, `seller`, `year`, `price`, `stock`.\
   Di class `DigitalProduct` terdapat tambahan atribut `fileType`.

   ```java
   private String name;
   private String seller;
   private int year;
   private double price;
   private int stock;
   ```

4. **Constructor**\
   Constructor di setiap class untuk inisialisasi objek.

   ```java
   public Product(String name, String seller, int year, double price, int stock) { ... }
   public DigitalProduct(String name, String seller, int year, double price, int stock, String fileType) { ... }
   ```

5. **Mutator**\
   Method setter untuk mengubah nilai atribut.

   ```java
   public void setName(String name) { this.name = name; }
   public void setStock(int stock) { this.stock = stock; }
   ```

6. **Accessor**\
   Method getter untuk mengambil nilai atribut.

   ```java
   public String getName() { return name; }
   public int getStock() { return stock; }
   ```

7. **Encapsulation**\
   Semua atribut dibuat private, hanya bisa diakses melalui getter/setter.

   ```java
   private String name;
   private int stock;
   // dst.
   ```

8. **Inheritance**\
   `DigitalProduct` mewarisi `Product` menggunakan `extends`.

   ```java
   class DigitalProduct extends Product { ... }
   ```

9. **Polymorphism (Overriding)**\
   Method `displayInfo()` di `DigitalProduct` menimpa method di parent class `Product`.

   ```java
   @Override
   public void displayInfo() { ... }
   ```

10. **Seleksi**\
    Digunakan pada pemilihan menu dan validasi.

```java
if (pilihan == 1) { ... } else if (pilihan == 2) { ... }
```

11. **Perulangan**\
    Loop `while (true)` untuk menu utama aplikasi, dan perulangan arraylist produk.

```java
while (true) { ... }
for (int i = 0; i < products.size(); i++) { ... }
```

12. **Input Output Sederhana**\
    Menggunakan `Scanner` untuk input user dan `System.out.println` untuk output.

```java
Scanner sc = new Scanner(System.in);
System.out.println("Pilih menu [1-6]: ");
```

13. **ArrayList**\
    Menyimpan daftar produk menggunakan `ArrayList<Product>` di dalam class `Marketplace`.

```java
private ArrayList<Product> products;
```

14. **Error Handling**\
    Menggunakan blok `try-catch` untuk menangani input atau aksi yang salah.

```java
try {
    // input & logika
} catch (InputMismatchException e) {
    System.out.println("Input harus berupa angka!");
}
```

## Usulan nilai

| No | Materi         | Nilai   |
| -- | -------------- | ------- |
| 1  | Class          | 5       |
| 2  | Object         | 5       |
| 3  | Atribut        | 5       |
| 4  | Constructor    | 5       |
| 5  | Mutator        | 5       |
| 6  | Accessor       | 5       |
| 7  | Encapsulation  | 5       |
| 8  | Inheritance    | 5       |
| 9  | Polymorphism   | 10      |
| 10 | Seleksi        | 5       |
| 11 | Perulangan     | 5       |
| 12 | IO Sederhana   | 10      |
| 13 | ArrayList      | 15      |
| 14 | Error Handling | 15      |
|    | **TOTAL**      | **100** |

## Contoh Output

```
===== Zentra Marketplace =====
1. Tambah Produk Fisik
2. Tambah Produk Digital
3. Lihat Daftar Produk
4. Lihat Detail Produk
5. Beli Produk
6. Keluar
Pilih menu [1-6]: 3

===== Daftar Produk di Zentra =====
[1] Buku Algoritma | Rp50000.0 | Stok: 10 (Budi)
```

## Pembuat

Nama: [Ahmad Agie Munawar]\
NIM: [2310010659]\
Prodi: [Teknik Informatika]

