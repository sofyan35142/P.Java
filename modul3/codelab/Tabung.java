import java.util.Scanner;

public class Tabung extends BangunRuang {
    private double tinggi;
    private double jari_jari;
    //ditambahi dengan private double jari_jari; untuk menginputkan jari-jarinya
    Scanner scanner = new Scanner(System.in);

    Tabung(String name) {
        super(name);
    }

    @Override
    public void inputNilai() {
        super.inputNilai();
        //super.luasPermukaan(); diganti dengan super.inputNilai();
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble();
        //menambahi scanner sebelum .nextDouble()
        System.out.print("Input jari-jari: ");
        jari_jari = scanner.nextDouble();
    }

    @Override
    public void luasPermukaan() {
        double hasil = 2 * Math.PI * jari_jari * (jari_jari);
        super.luasPermukaan();
        //ditambahin () setelah super.luaspermukaan
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume() {
        double hasil = Math.PI * Math.pow(jari_jari, 2) * tinggi;
        super.volume();
        System.out.println("Hasil volume: " + hasil);
        //sebelum hasil harus ditambahi dengan +
    }

}
