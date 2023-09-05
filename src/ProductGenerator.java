import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean done = false;

        do {
            String name = SafeInput.getNonZeroLenString(scanner, "Enter the Product Name: ");
            String description = SafeInput.getNonZeroLenString(scanner, "Enter the Product Description: ");
            String ID = SafeInput.getRegExString(scanner, "Enter the Product ID (e.g., 000001):", "\\d{6}");
            double cost = SafeInput.getDouble(scanner, "Enter the Product Cost: ");

            Product product = new Product(name, description, ID, cost);
            products.add(product);

            done = SafeInput.getYNConfirm(scanner, "Are you done? ");
        } while (!done);

        String fileName = SafeInput.getNonZeroLenString(scanner, "Please enter the file name: ");

        saveToFile(products, fileName);

        System.out.println("Data file written!");
    }

    private static void saveToFile(ArrayList<Product> products, String fileName) {
        Path filePath = Paths.get(fileName + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
            for (Product product : products) {
                String dataRecord = product.toCSVDataRecord();
                System.out.println("Record: " + dataRecord);
                writer.write(dataRecord);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
