/*
 * =============================================
 *  Zentra: Simple Marketplace App
 *  ---------------------------------------------
 *  Aplikasi jual beli sederhana berbasis Java OOP.
 *  Fitur: Tambah produk fisik/digital, lihat daftar,
 *  lihat detail, beli produk (stok berkurang otomatis).
 * =============================================
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// ===== Kelas Produk (Parent) =====
class Product {
    private String name;
    private String seller;
    private int year;
    private double price;
    private int stock;

    public Product(String name, String seller, int year, double price, int stock) {
        this.name = name;
        this.seller = seller;
        this.year = year;
        this.price = price;
        this.stock = stock;
    }

    // Getter & Setter (Encapsulation)
    public String getName() { return name; }
    public String getSeller() { return seller; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void setName(String name) { this.name = name; }
    public void setSeller(String seller) { this.seller = seller; }
    public void setYear(int year) { this.year = year; }
    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }

    // Polymorphism: Bisa dioverride di subclass
    public void displayInfo() {
        System.out.println("Nama Produk : " + name);
        System.out.println("Penjual     : " + seller);
        System.out.println("Tahun       : " + year);
        System.out.println("Harga       : Rp" + price);
        System.out.println("Stok        : " + stock);
    }
}

// ===== Kelas Produk Digital (Child) =====
class DigitalProduct extends Product {
    private String fileType;

    public DigitalProduct(String name, String seller, int year, double price, int stock, String fileType) {
        super(name, seller, year, price, stock);
        this.fileType = fileType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tipe File   : " + fileType);
    }
}

// ===== Kelas Marketplace =====
class Marketplace {
    private ArrayList<Product> products;

    public Marketplace() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void showProducts() {
        if (products.isEmpty()) {
            System.out.println("Belum ada produk di marketplace.");
        } else {
            System.out.println("\n===== Daftar Produk di Zentra =====");
            for (int i = 0; i < products.size(); i++) {
                System.out.println("[" + (i+1) + "] " + products.get(i).getName()
                        + " | Rp" + products.get(i).getPrice()
                        + " | Stok: " + products.get(i).getStock()
                        + " (" + products.get(i).getSeller() + ")");
            }
        }
    }

    public void showProductByIndex(int index) {
        try {
            if (index < 0 || index >= products.size()) {
                throw new Exception("Nomor produk tidak valid!");
            }
            System.out.println("\n===== Detail Produk =====");
            products.get(index).displayInfo();
        } catch (Exception e) {
            System.out.println("Terjadi error: " + e.getMessage());
        }
    }

    // Fitur beli produk
    public void buyProduct(int index, int qty) {
        try {
            if (index < 0 || index >= products.size()) {
                throw new Exception("Nomor produk tidak valid!");
            }
            Product p = products.get(index);
            if (qty <= 0) {
                throw new Exception("Jumlah pembelian minimal 1.");
            }
            if (p.getStock() < qty) {
                throw new Exception("Stok tidak cukup! Stok saat ini: " + p.getStock());
            }
            p.setStock(p.getStock() - qty);
            System.out.println("Berhasil membeli " + qty + " " + p.getName() + ". Total harga: Rp" + (p.getPrice() * qty));
        } catch (Exception e) {
            System.out.println("Gagal membeli produk: " + e.getMessage());
        }
    }
}

// ===== Main Program =====
public class Main {
    public static void main(String[] args) {
        Marketplace zentra = new Marketplace();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Zentra Marketplace =====");
            System.out.println("1. Tambah Produk Fisik");
            System.out.println("2. Tambah Produk Digital");
            System.out.println("3. Lihat Daftar Produk");
            System.out.println("4. Lihat Detail Produk");
            System.out.println("5. Beli Produk");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu [1-6]: ");

            int pilihan = 0;
            try {
                pilihan = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                sc.nextLine();
                continue;
            }

            if (pilihan == 1) {
                // Tambah Produk Fisik
                System.out.print("Nama Produk   : ");
                String nama = sc.nextLine();
                System.out.print("Penjual       : ");
                String penjual = sc.nextLine();
                System.out.print("Tahun         : ");
                int tahun = 0;
                double harga = 0;
                int stok = 0;
                try {
                    tahun = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Harga         : Rp");
                    harga = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Stok          : ");
                    stok = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Tahun, harga, dan stok harus berupa angka!");
                    sc.nextLine();
                    continue;
                }
                Product produk = new Product(nama, penjual, tahun, harga, stok);
                zentra.addProduct(produk);
                System.out.println("Produk fisik berhasil ditambahkan!");

            } else if (pilihan == 2) {
                // Tambah Produk Digital
                System.out.print("Nama Produk Digital : ");
                String nama = sc.nextLine();
                System.out.print("Penjual            : ");
                String penjual = sc.nextLine();
                System.out.print("Tahun              : ");
                int tahun = 0;
                double harga = 0;
                int stok = 0;
                try {
                    tahun = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Harga              : Rp");
                    harga = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Stok               : ");
                    stok = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Tahun, harga, dan stok harus berupa angka!");
                    sc.nextLine();
                    continue;
                }
                System.out.print("Tipe File          : ");
                String tipe = sc.nextLine();

                DigitalProduct dProduk = new DigitalProduct(nama, penjual, tahun, harga, stok, tipe);
                zentra.addProduct(dProduk);
                System.out.println("Produk digital berhasil ditambahkan!");

            } else if (pilihan == 3) {
                zentra.showProducts();

            } else if (pilihan == 4) {
                System.out.print("Masukkan nomor produk: ");
                int idx = 0;
                try {
                    idx = sc.nextInt();
                    sc.nextLine();
                    zentra.showProductByIndex(idx-1);
                } catch (InputMismatchException e) {
                    System.out.println("Input harus berupa angka!");
                    sc.nextLine();
                }

            } else if (pilihan == 5) {
                System.out.print("Masukkan nomor produk yang ingin dibeli: ");
                int idx = 0;
                int qty = 0;
                try {
                    idx = sc.nextInt();
                    System.out.print("Jumlah yang dibeli: ");
                    qty = sc.nextInt();
                    sc.nextLine();
                    zentra.buyProduct(idx-1, qty);
                } catch (InputMismatchException e) {
                    System.out.println("Input harus berupa angka!");
                    sc.nextLine();
                }

            } else if (pilihan == 6) {
                System.out.println("Terima kasih telah menggunakan Zentra Marketplace!");
                break;

            } else {
                System.out.println("Menu tidak valid. Silakan pilih [1-6].");
            }
        }
        sc.close();
    }
}
