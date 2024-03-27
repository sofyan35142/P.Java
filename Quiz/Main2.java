class Kendaraan {
    int kecepatan;

    Kendaraan(int kecepatan) {
        this.kecepatan = kecepatan;
    }

    int getKecepatan() {
        return kecepatan;
    }
}

class Mobil extends Kendaraan {
    String merk_mobil;

    Mobil(String merk_mobil, int kecepatan) {
        super(kecepatan);
        this.merk_mobil = merk_mobil;
    }

    void cekKecepatan() {
        if (kecepatan > 100) {
            System.out.println("Mobil " + merk_mobil + " kena tilang!");
        } else {
            System.out.println("Mobil " + merk_mobil + " tidak kena tilang.");
        }
    }

    void cetak() {
        System.out.println("Merk Mobil: " + merk_mobil);
        System.out.println("Kecepatan: " + kecepatan + " km/jam");
    }
}

public class Main2 {
    public static void main(String[] args) {
        Mobil mobil1 = new Mobil("Toyota Avanza", 120);
        mobil1.cetak();
        mobil1.cekKecepatan();
        
        Mobil mobil2 = new Mobil("Honda Civic", 80);
        mobil2.cetak();
        mobil2.cekKecepatan();
    }
}
