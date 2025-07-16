import LogicalClasses.Order;

import java.util.ArrayList;
import java.util.List;

public class Shipment {
    private int shipmentId;
    private String destination;
    private double cost;
    private String deliveryDate;
    private List<Order> orders;

    public Shipment(int shipmentId, String destination, double cost, String deliveryDate) {
        this.shipmentId = shipmentId;
        this.destination = destination;
        this.cost = cost;
        this.deliveryDate = deliveryDate;
        this.orders = new ArrayList<>();
    }

    // Getters and Setters
    public int getShipmentId() {
        return shipmentId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Methods to manage orders
    public void addOrder(Order order) {
        orders.add(order);
    }

    public boolean removeOrder(String orderId) {
        return orders.removeIf(order -> order.getOrderID().equals(orderId));
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId=" + shipmentId +
                ", destination='" + destination + '\'' +
                ", cost=" + cost +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", orders=" + orders +
                '}';
    }
}
