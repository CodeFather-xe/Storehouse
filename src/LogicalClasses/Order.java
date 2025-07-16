package LogicalClasses;

import java.util.ArrayList;

public class Order {
    private String owner;
    private int orderID;
    private double cost;
    private int priority;
    ArrayList<Products> products;

    public Order(int orderID) {
        this.orderID = orderID;
        this.products = new ArrayList<>();
        this.cost = 0;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    // إضافة منتج إلى الطلب
    public void addProduct(Products item) {
        products.add(item);
    }

    public Products searchProduct(int itemID) {
        for (Products item : products) {
            if (item.getId() == itemID) {
                return item;
            }
        }
        return null;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    public boolean updateProductQuantity(int productID, int newQuantity) {
        Products product = searchProduct(productID);
        if (product != null) {
            product.setCurrentQuantity(newQuantity);
            return true;
        }
        return false;
    }

    public boolean removeProduct(int productID) {
        Products product = searchProduct(productID);
        if (product != null) {
            products.remove(product);
            return true;
        }
        return false;
    }

//    public void showOrderDetails() {
//        System.out.println("LogicalClasses.Order ID: " + orderID);
//        for (Products product : products) {
//            cost = +product.getPrice();
//            System.out.println(product);
//        }
//        System.out.println("The priority is:" + priority + "\n" + "The cost is:" + cost);
//    }

}

