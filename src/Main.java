import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecordManager manager = new RecordManager();
        int input = -1;

        while (input != 5) {
            System.out.println("Enter 1 to add a book, 2 to display books, 3 to save a record, 4 to load a record, or 5 to quit:");
            String line = scanner.nextLine();

            try {
                input = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number 1–5.");
                continue;
            }

            switch (input) {
                case 1:
                    addBook(scanner, manager);
                    break;
                case 2:
                    manager.displayAllRecords();
                    break;
                case 3:
                    saveRecords(scanner, manager);
                    break;
                case 4:
                    loadRecords(scanner, manager);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Command not recognised");
                    break;
            }
        }

        scanner.close();


    }


    public static void addBook(Scanner scanner, RecordManager manager) {
        try {
            System.out.println("Enter title:");
            String title = scanner.nextLine();
            System.out.println("Enter author:");
            String author = scanner.nextLine();
            System.out.println("Enter year:");
            int year = Integer.parseInt(scanner.nextLine());
            BookRecord book = new BookRecord(title, author, year);
            manager.addRecord(book);
            System.out.println("Record with ID " + book.getId() + " added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    public static void saveRecords(Scanner scanner, RecordManager manager) {
        System.out.println("Enter filename:");
        String fileName = scanner.nextLine();

        FileHandler file = new FileHandler(fileName);
        file.saveRecords(manager.getAllRecords());
        System.out.println("Records saved successfully to " + fileName);
    }

    public static void loadRecords(Scanner scanner, RecordManager manager) {
        System.out.println("Enter filename:");
        String fileName = scanner.nextLine();

        FileHandler file = new FileHandler(fileName);
        ArrayList<DisplayableRecord> load = file.loadRecords();

        if (load == null){
            System.out.println("Error loading records from: " + fileName);
        }
        else{
            manager.setRecords(load);
            System.out.println("Records loaded successfully.");
        }

    }
}