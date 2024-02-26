// Принцип открытости/закрытости
public class Product {
    private int id;
    private String name;
    private String category;
    private String brand;
    private double price;
    private int stock;
    private String description;

    public Product() {}

    public Product(
            int id,
            String name,
            String category,
            String brand,
            double price,
            int stock,
            String description
    ) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return this.name + ", цена: " + this.price + "$";
    }



}
