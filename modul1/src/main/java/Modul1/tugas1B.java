package Modul1;
import java.util.Scanner;
public class tugas1B {


//    public class LibrarySystem {
        static String[] mahasiswa = {"202210370311203", "200111223344555", "201234567890123"};
        static String adminUsername = "admin";
        static String adminPassword = "admin";

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int option;

            do {
                System.out.println("===== Library System =====");
                System.out.println("1. Login as Student");
                System.out.println("2. Login as Admin");
                System.out.println("3. Exit");
                System.out.print("Choose option (1-3): ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        loginAsStudent(scanner);
                        break;
                    case 2:
                        loginAsAdmin(scanner);
                        break;
                    case 3:
                        System.out.println("adios");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            } while (option != 3);
        }

        private static void loginAsStudent(Scanner scanner) {
            System.out.print("Enter your NIM: ");
            String nim = scanner.next();

            boolean found = false;
            for (String student : mahasiswa) {
                if (student.equals(nim)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("Successful Login as Student");
            } else {
                System.out.println("User Not Found");
            }
        }

        private static void loginAsAdmin(Scanner scanner) {
            System.out.print("Enter your username (admin): ");
            String username = scanner.next();
            System.out.print("Enter your password (admin): ");
            String password = scanner.next();

            if (username.equals(adminUsername) && password.equals(adminPassword)) {
                System.out.println("Successful Login as Admin");
            } else {
                System.out.println("Admin User Not Found!!");
            }
        }
    }

//}
