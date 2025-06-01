import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {
    private static final String FILE_PATH = "example.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File Handling Utility");
        System.out.println("1. Write to file\n2. Read from file\n3. Append to file");
        System.out.print("Choose an option (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter text to write: ");
                    String contentToWrite = scanner.nextLine();
                    writeFile(contentToWrite);
                    break;
                case 2:
                    readFile();
                    break;
                case 3:
                    System.out.print("Enter text to append: ");
                    String contentToAppend = scanner.nextLine();
                    appendToFile(contentToAppend);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } catch (IOException e) {
            System.out.println("File operation error: " + e.getMessage());
        }
    }

    public static void writeFile(String content) throws IOException {
        FileWriter writer = new FileWriter(FILE_PATH);
        writer.write(content);
        writer.close();
        System.out.println("Successfully written to file.");
    }

    public static void readFile() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        System.out.println("File contents:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void appendToFile(String content) throws IOException {
        FileWriter writer = new FileWriter(FILE_PATH, true); // true = append mode
        writer.write("\n" + content);
        writer.close();
        System.out.println("Successfully appended to file.");
    }
}
