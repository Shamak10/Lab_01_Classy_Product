import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        ArrayList<Product> products = new ArrayList<>();

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                readProductsFromFile(file, products);
                displayProducts(products);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    private static void readProductsFromFile(Path file, ArrayList<Product> products) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            int line = 0;
            String lineData;
            while ((lineData = reader.readLine()) != null) {
                String[] rec = lineData.split(", ");
                if (rec.length == 4) {
                    String code = rec[0];
                    String name = rec[1];
                    String description = rec[2];
                    double price = Double.parseDouble(rec[3]);

                    Product product = new Product(code, name, description, price);
                    products.add(product);
                    line++;
                    System.out.printf("Line %4d: %s%n", line, product);
                } else {
                    System.out.printf("Line %4d: Invalid data format: %s%n", line, lineData);
                }
            }
            System.out.println("\nData file read successfully!");
        }
    }

    private static void displayProducts(ArrayList<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("Product %d: %s%n", i + 1, products.get(i));
        }
    }
}
