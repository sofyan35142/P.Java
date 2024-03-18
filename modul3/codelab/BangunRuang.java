import java.util.Scanner;

public class BangunRuang {
    Scanner scanner = new Scanner(System.in);
    private String name;

    public BangunRuang(String name) {
        //string namee dirubah menjadi name
        this.name = name;
    }

    public void inputNilai() {
        System.out.println("Input nilai");
    }

    public void luasPermukaan() {
        System.out.println("Menghitung luas permukaan bangun " + name);
        //didalam kurung selepas petik itu harus ditambahi dengan +
    }

    public void volume() {
        System.out.println("Menghitung volume bangun " + name);
        //ditambahi ; setelah ()
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getname() {
        return name;
        //return your diganti dengan return name
    }
}