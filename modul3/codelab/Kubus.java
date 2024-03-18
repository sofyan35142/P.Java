import java.util.Scanner;

public class Kubus extends BangunRuang {
    private double sisi;
    Scanner scanner = new Scanner(System.in);

    Kubus(String name) {
        super(name);
    }
    //nambahin kubus(String name) ngambil contoh di tabungw

    @Override
    public void inputNilai() {
        //menambahi nilai setelah input 
        super.inputNilai();
        System.out.print("Input sisi: ");
        //System.o diganti dengan System.out.print
        sisi = scanner.nextDouble();
        //Scanner.nextnext() diganti dengan scanner.nextDouble()
    }

    @Override
    public void luasPermukaan() {
        double hasil = 6 * sisi * sisi;
        super.luasPermukaan();
        //super.luasaan(); salah diganti dengan super.luasPermukaan();
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume() {
        double hasil = Math.pow(sisi, 3);
        //sebelum hasil harus ditambah dengan double selaku tipedata
        super.volume();
        System.out.println("Hasil volume: " + hasil);
    }
}
