import java.util.ArrayList;
import java.util.Scanner;

public class codelab {
    public static void main(String[] args) {
        ArrayList<String> daftarNama = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan nama mahasiswa (input 'selesai' untuk mengakhiri):");

        while (true) {
            String inputNama = scanner.nextLine();

            if (inputNama.isEmpty()) {
                try {
                    throw new IllegalArgumentException("Nama tidak boleh kosong");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (inputNama.equalsIgnoreCase("selesai")) {
                break;
            } else {
                daftarNama.add(inputNama);
                System.out.println("Nama " + inputNama + " ditambahkan ke dalam list.");
            }
        }

        System.out.println("\nDaftar nama mahasiswa:");
        for (int i = 0; i < daftarNama.size(); i++) {
            System.out.println("Nama ke-" + (i + 1) + ": " + daftarNama.get(i));
        }
    }
}

