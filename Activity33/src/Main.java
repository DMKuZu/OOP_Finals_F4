import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

interface Handler {
    void add(String text) throws IOException;
    void update(int index, String text) throws IOException;
    void delete(String text) throws IOException;
    void display() throws FileNotFoundException;
    void exit();
}

class FileHandler implements Handler {
    private String file;
    private ArrayList<String> texts;
    private int size;

    public FileHandler(String file) throws FileNotFoundException {
        this.file = file;
        texts = new ArrayList<>();

        try (Scanner reader = new Scanner(new File(file))) {
            while (reader.hasNextLine()) {
                texts.add(reader.nextLine());
            }
            size = texts.size();
        }
    }

    @Override
    public void add(String text) throws IOException {
        try (FileWriter writer = new FileWriter(file, true)) {
            texts.add(text);
            writer.write(text + "\n");
            size++;
        }
    }

    @Override
    public void update(int index, String text) throws IOException {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }

        texts.set(index, text);

        try (FileWriter writer = new FileWriter(file, false)) {
            for (String str : texts) {
                writer.write(str + "\n");
            }
        }
    }

    @Override
    public void delete(String text) throws IOException {
        if (!texts.remove(text)) {
            System.out.println("Text not found");
            return;
        }

        try (FileWriter writer = new FileWriter(file, false)) {
            for (String str : texts) {
                writer.write(str + "\n");
            }
        }
        size--;
    }

    @Override
    public void display() {
        for (int i = 0; i < texts.size(); i++) {
            System.out.printf("%d - %s\n", i, texts.get(i));
        }
    }

    @Override
    public void exit() {
        System.out.println("Good Bye!");
        System.exit(0);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            Handler handler = new FileHandler("Activity33.txt");

            while (true) {
                int choice;
                while (true) {
                    try {
                        System.out.print("------------------------------------------------\n" +
                                "Press 1 - Add\n" +
                                "\n" +
                                "Press 2 - Update\n" +
                                "\n" +
                                "Press 3 - Delete\n" +
                                "\n" +
                                "Press 4 - Display\n" +
                                "\n" +
                                "Press 0 - Exit\n" +
                                "\n" +
                                "Enter choice : ");

                        choice = in.nextInt();
                        in.nextLine(); // Consume newline

                        if (choice >= 0 && choice <= 4) break;

                        else System.out.println("Choose from 0 to 4.");

                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again.");
                        in.nextLine(); // Clear invalid input
                    }
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter text to add: ");
                        handler.add(in.nextLine());
                        break;
                    case 2:
                        System.out.print("Enter index number to update: ");
                        int index = in.nextInt();
                        in.nextLine(); // Consume newline
                        System.out.print("Enter text to update: ");
                        handler.update(index, in.nextLine());
                        break;
                    case 3:
                        System.out.print("Enter text to delete: ");
                        handler.delete(in.nextLine());
                        break;
                    case 4:
                        System.out.println("The contents of the file: ");
                        handler.display();
                        break;
                    default:
                        handler.exit();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}