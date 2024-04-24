class Swalayan {

    String pembeli;
    private int harga;

    public Swalayan(String pembeli, int harga) {
        this.pembeli = pembeli;
        this.h arga = harga;
    }

    public int getHarga() {
        return harga;
    }
}

class Grosir extends Swalayan {

    private int jumlah;

    public Grosir(String pembeli, int harga, int jumlah) {
        super(pembeli, harga);
        this.jumlah = jumlah;
    }

    
    public int getJumlahPembelian() {
        return jumlah * getHarga();
    }

    public void cetak() {
        System.out.println("Nama Pembeli: " + pembeli);
        System.out.println("Harga Barang: " + getHarga());
        System.out.println("Jumlah Barang: " + jumlah);
        System.out.println("Total Pembelian: " + getJumlahPembelian());
    }
}
public class main {
    public static void main(String[] args) {
        Grosir grosir = new Grosir("Budi", 10000, 5);
        grosir.cetak();
    }
    

    /**
     * @param harga the harga to set
     */
//    public void setHarga(int harga) {
//        this.harga = harga;
//    }

    /**
     * @param jumlah the jumlah to set
     */
//    public void setJumlah(int jumlah) {
//        this.jumlah = jumlah;
//    }

}