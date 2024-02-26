package Modul1;

public class subcpmk1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Array: ");

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();


        System.out.println("Angka Ganjil atau Genap:");
        for (int num : arr) {
            if (num % 2 != 0) {
                System.out.println(num + " adalah ganjil");
            } else {
                System.out.println(num + " adalah genap");
            }
 }
}
}
