public class ShipmentNode {
    Shipment shipment;
    ShipmentNode left, right;

    public ShipmentNode(Shipment shipment) {
        this.shipment = shipment;
        this.left = this.right = null;
    }
}
