package oop;
import java.util.ArrayList;

class Mahasiswa {
    private ArrayList<String> daftarNama;

    public Mahasiswa() {
        daftarNama = new ArrayList<>();
    }

    public void tambahNama(String nama) {
        if (nama.isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        daftarNama.add(nama);
    }

    public void tampilkanDaftarNama() {
        System.out.println("Daftar nama mahasiswa:");
        for (int i = 0; i < daftarNama.size(); i++) {
            System.out.println("Nama ke-" + (i + 1) + ": " + daftarNama.get(i));
        }
    }
}


