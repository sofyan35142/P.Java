package Modul1;

import java.util.Scanner;

public class tugas1 {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private static final String[][] STUDENT_CREDENTIALS = {
            {"202310370311135", "student123"},
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Library System ====\n");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    loginStudent(scanner);
                    break;
                case 2:
                    loginAdmin(scanner);
                    break;
                case 3:
                    System.out.println("adios");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void loginStudent(Scanner scanner) {
        System.out.print("Enter your NIM: ");
        String nim = scanner.nextLine();

        if (isValidNIM(nim)) {
            boolean found = false;
            for (String[] credentials : STUDENT_CREDENTIALS) {
                if (credentials[0].equals(nim)) {
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();

                    if (credentials[1].equals(password)) {
                        System.out.println("Successful Login as Student");
                        found = true;
                        break;
                    } else {
                        System.out.println("Incorrect password.");
                    }
                }
            }

            if (!found) {
                System.out.println("User Not Found");
            }
        } else {
            System.out.println("Invalid NIM format. Please enter a valid NIM.");
        }
    }

    private static void loginAdmin(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        if (username.equals(ADMIN_USERNAME)) {
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (password.equals(ADMIN_PASSWORD)) {
                System.out.println("Successful Login as Admin");
            } else {
                System.out.println("Incorrect password.");
            }
        } else {
            System.out.println("Admin User Not Found!!");
        }
    }

    private static boolean isValidNIM(String nim) {
        return nim.matches("\\d{15}");
    }
}
