
package tb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // konfigurasi database
        String jdbcUrl = "jdbc:mysql://localhost:3306/db_vier";
        String username = "root";
        String password = "root";
        // static String url = "jdbc:mysql://localhost:3306/db_vier";
        // static Connection con;
        // static Scanner input = new Scanner(System.in);

        // exception
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Koneksi ke database berhasil!");

            // collection framework hashmap
            HashMap<String, String> admin = new HashMap<String, String>();
            admin.put("ali", "123");
            admin.put("rezky", "456");
            admin.put("babak", "789");

            Scanner i = new Scanner(System.in);
            LocalDateTime myDateObj = LocalDateTime.now();// method date now

            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            boolean lanjut = true;
            penjualan j = new penjualan();
            String iadm;
            System.out.println("Driver Ready");
            System.out.print("Admin     : ");
            // method string lowercase
            iadm = i.nextLine().toLowerCase();
            // decision atau percabangan
            if (admin.get(iadm) != null) {
                // looping atau perulangan
                do {
                    clean.clearScreen();
                    System.out.println("|              MENU               |");
                    System.out.println("1. Lihat Riwayat Data Penjualan");
                    System.out.println("2. Tambah Data Penjualan");
                    System.out.println("3. Edit Data Penjualan");
                    System.out.println("4. Hapus Data Penjualan");
                    System.out.println("5. Cari Data Penjualan");
                    System.out.print("no : ");
                    int menu = Integer.parseInt(i.nextLine());
                    if (menu == 1) {
                        clean.clearScreen();
                        j.riwayatPenjualan(iadm);
                    } else if (menu == 2) {
                        clean.clearScreen();
                        j.tambahPenjualan(iadm);
                    } else if (menu == 3) {
                        clean.clearScreen();
                        j.editPenjualan(iadm);
                    } else if (menu == 4) {
                        clean.clearScreen();
                        j.hapusPenjualan(iadm);
                    } else if (menu == 5) {
                        clean.clearScreen();
                        j.cariPenjualan(iadm);
                    } else {
                        clean.clearScreen();
                        System.out.println("Menu tidak tersedia");
                    }
                    System.out.print("\n\nKembali? (y/n) : ");
                    String y = i.nextLine();
                    lanjut = y.equalsIgnoreCase("y");
                } while (lanjut);
            }

            else {
                System.out.println("Akun tidak tersedia. Program hanya dapat diakses oleh admin yang terdaftar");
            }
            System.out.println(
                    "\nTerima kasih telah menggunakan program ini!" + formattedDate);
            i.close();
        } catch (SQLException e) {
            System.err.println("Koneksi tidak berhasil");
        }
    }

}