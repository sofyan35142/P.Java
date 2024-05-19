package oop;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mahasiswa mahasiswa = new Mahasiswa();
        Scanner scanner = new Scanner(System.in);

        int namaKe = 1; // Untuk menyimpan nomor urut nama yang dimasukkan

        while (true) {
            System.out.print("Masukkan nama ke-" + namaKe + ": ");
            String inputNama = scanner.nextLine();

            if (inputNama.equalsIgnoreCase("selesai")) {
                break;
            }

            try {
                mahasiswa.tambahNama(inputNama);
                System.out.println("Nama " + inputNama + " ditambahkan ke dalam list.");
                namaKe++; // Naikkan nomor urut nama setelah nama berhasil ditambahkan
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        mahasiswa.tampilkanDaftarNama();
    }
}