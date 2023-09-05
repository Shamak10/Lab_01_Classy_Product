public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;

    public Product(String ID, String name, String description, double cost) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getID() {
        return ID;
    }

    public double getCost() {
        return cost;
    }

    public String toCSVDataRecord() {
        return ID + "," + name + "," + description + "," + cost;
    }
}
