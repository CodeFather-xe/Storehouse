package LogicalClasses;

public class Products {
    private String name;
    private final int id;
    private String imagePath;
    private double price;
    private int CurrentQuantity;

    public Products(String name, int id, double price, int CurrentQuantity, String imagePath) {
        this.name = name;
        this.id = id;
        this.imagePath = imagePath;
        this.price = price;
        this.CurrentQuantity = CurrentQuantity;
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

    public int getCurrentQuantity() {
        return CurrentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.CurrentQuantity = currentQuantity;
    }
}
