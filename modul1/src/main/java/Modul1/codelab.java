package Modul1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class codelab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Jenis Kelamin (P/L): ");
        char jenisKelamin = scanner.next().charAt(0);
        String jeniskelasminoption = (jenisKelamin == 'P' || jenisKelamin == 'p') ? "Perempuan" : "Laki-laki";

        System.out.print("Masukkan Tanggal Lahir (yyyy-mm-dd): ");
        String tanggalLahirStr = scanner.next();
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirStr);

        // Menghitung umur
        LocalDate tanggalSekarang = LocalDate.now();
        Period period = Period.between(tanggalLahir, tanggalSekarang);
        int umur = period.getYears();
        int bulan = period.getMonths();
        int hari = period.getDays();


        System.out.println("\n===== Data Diri Anda =====");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jeniskelasminoption);
        System.out.println("Tanggal Lahir: " + tanggalLahir);
        System.out.println("Umur: " + umur + " tahun, " + bulan + " bulan, " + hari + " hari");
    }
}
