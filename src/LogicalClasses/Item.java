package LogicalClasses;

public class Item {
    private String name;
    private final int id;
    private String imagePath;
    private double price;
    private int quantity;

    public Item(String name, int id, double price, int quantity, String imagePath) {
        this.name = name;
        this.id = id;
        this.imagePath = imagePath;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
