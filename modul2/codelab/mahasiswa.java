package Modul1;

import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    static String universitas = "Universitas Muhammadiyah Malang";
    String nama, jurusan;
    long nim;

    Mahasiswa(String nama, long nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    static String tampilUniversitas() {
        return universitas;
    }

    String tampilDataMahasiswa() {
        return "Nama: " + nama + ", NIM: " + nim + ", Jurusan: " + jurusan;
    }
}

public class mahasiswa {
    static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        tambahDataMahasiswa();
    }

    static void tambahDataMahasiswa() {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Data Mahasiswa");
        System.out.println("2. Tampilkan Data Mahasiswa");
        System.out.println("3. Keluar");
        System.out.print("Pilihan Anda: ");
        String pilihan = scanner.nextLine();

        if (pilihan.equals("1")) {
            System.out.print("Masukkan nama mahasiswa: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM mahasiswa: ");
            long nim = scanner.nextLong();

            while (String.valueOf(nim).length() != 15) {
                System.out.println("NIM Harus 15 Digit!!!");
                System.out.print("Masukkan NIM mahasiswa: ");
                nim = scanner.nextInt();
            }

            // Consume the newline character left in the buffer
            scanner.nextLine();

            System.out.print("Masukkan jurusan mahasiswa: ");
            String jurusan = scanner.nextLine();

            Mahasiswa mahasiswaBaru = new Mahasiswa(nama, nim, jurusan);
            dataMahasiswa.add(mahasiswaBaru);
            System.out.println("Data mahasiswa berhasil ditambahkan.");
            tambahDataMahasiswa();
        } else if (pilihan.equals("2")) {
            tampilkanDataMahasiswa();
            tambahDataMahasiswa();
        } else if (pilihan.equals("3")) {
            System.out.println("Adios");
        }
    }

    static void tampilkanDataMahasiswa() {
        System.out.println("\nData Mahasiswa:");
        System.out.println(Mahasiswa.tampilUniversitas());
        for (Mahasiswa mahasiswa : dataMahasiswa) {
            System.out.println(mahasiswa.tampilDataMahasiswa());
        }
    }
}

