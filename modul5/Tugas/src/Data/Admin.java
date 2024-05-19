package src.Data;

import src.com.main.Main;
import src.Books.*;
import src.exception.custom.IllegalAdminAccess;
import java.util.Scanner;
import src.util.iMenu;
import java.util.ArrayList;

public class Admin extends User implements iMenu {
    private boolean isAdmin;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public Admin(String name, String nim, String faculty, String program, boolean isAdmin) {
        super(name, nim, faculty, program);
        this.isAdmin = isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void loginAdmin(Scanner scanner) throws IllegalAdminAccess {
        System.out.print("Enter your username (admin): ");
        String username = scanner.nextLine();
        System.out.print("Enter your password (admin123): ");
        String password = scanner.nextLine();

        if (!isAdmin(username, password)) {
            throw new IllegalAdminAccess("Invalid credentials");
        } else {
            System.out.println("Login successful.");
            menu();
        }
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Book");
            System.out.println("3. Display Registered Students");
            System.out.println("4. Display Available Books");
            System.out.println("5. Display Borrowed Books");
            System.out.println("6. Logout");
            System.out.print("Choose option (1-6): ");

            try {
                if (!isAdmin) {
                    throw new IllegalAdminAccess("Access denied. You are not an admin.");
                }

                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        addStudent(scanner);
                        break;
                    case "2":
                        addBook(scanner);
                        break;
                    case "3":
                        displayRegisteredStudents();
                        break;
                    case "4":
                        displayBooks();
                        break;
                    case "5":
                        displayBorrowedBooks();
                        break;
                    case "6":
                        System.out.println("Logging out from admin account.");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (IllegalAdminAccess e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    public void addStudent(Scanner scanner) {
        System.out.println("Enter student details:");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        String nim;
        do {
            System.out.print("Enter student NIM: ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("Student NIM must be 15 digits long.");
            }
        } while (nim.length() != 15);
        System.out.print("Enter student faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter student program: ");
        String program = scanner.nextLine();

        addStudent(name, nim, faculty, program);
    }

    public void addStudent(String name, String nim, String faculty, String program) {
        Main.userList.add(new Student(name, nim, faculty, program));
        System.out.println("Student successfully registered.");
    }

    public void addBook(Scanner scanner) {
        System.out.println("Select book category:");
        System.out.println("1. Story Book");
        System.out.println("2. History Book");
        System.out.println("3. Text Book");
        System.out.print("Choose category (1-3): ");
        int categoryOption = scanner.nextInt();
        scanner.nextLine();
        String category = "";
        switch (categoryOption) {
            case 1:
                category = "Story";
                break;
            case 2:
                category = "History";
                break;
            case 3:
                category = "Text";
                break;
            default:
                System.out.println("Invalid category.");
                return;
        }
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String bookId = generateId();
        switch (categoryOption) {
            case 1:
                Main.bookList.add(new StoryBook(bookId, title, author, category, stock, 0));
                break;
            case 2:
                Main.bookList.add(new HistoryBook(bookId, title, author, category, stock, 0));
                break;
            case 3:
                System.out.print("Enter duration: ");
                int duration = scanner.nextInt();
                scanner.nextLine();
                Main.bookList.add(new TextBook(bookId, title, author, category, stock, duration, 1)); // Misalnya edisi 1
                break;
        }
        System.out.println("Book successfully added to the library.");
    }

    public void displayRegisteredStudents() {
        System.out.println("List of Registered Students:");
        for (User user : Main.userList) {
            if (user instanceof Student) {
                Student student = (Student) user;
                System.out.println("Name: " + student.name);
                System.out.println("Faculty: " + student.faculty);
                System.out.println("NIM: " + student.nim);
                System.out.println("Program: " + student.program);
                System.out.println();
            }
        }
    }

    public void displayBooks() {
        System.out.println("List of Available Books:");
        for (Book book : Main.bookList) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Category: " + book.getCategory());
            System.out.println("Stock: " + book.getStock());
            System.out.println();
        }
    }

    public void displayBorrowedBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student NIM to display borrowed books: ");
        String nim = scanner.nextLine();
        Student student = findStudentByNIM(nim);
        if (student != null) {
            ArrayList<Book> borrowedBooks = student.getBorrowedBooks();
            System.out.println("List of Borrowed Books for " + student.getName() + ":");
            for (Book book : borrowedBooks) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Category: " + book.getCategory());
                System.out.println("Duration: " + book.getDuration() + " days");
                System.out.println();
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    public boolean isAdmin(String username, String password) throws IllegalAdminAccess {
        if (!username.equals(USERNAME) || !password.equals(PASSWORD)) {
            throw new IllegalAdminAccess("Anda Bukan Admin kami");
        }
        return true;
    }

    public String generateId() {
        String uuid = java.util.UUID.randomUUID().toString();
        return uuid.substring(0, 14);
    }

    private Student findStudentByNIM(String nim) {
        for (User user : Main.userList) {
            if (user instanceof Student && user.getNim().equals(nim)) {
                return (Student) user;
            }
        }
        return null;
    }
}
