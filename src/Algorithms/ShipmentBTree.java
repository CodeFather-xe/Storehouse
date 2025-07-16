import LogicalClasses.Order;

public class ShipmentBTree {
    private ShipmentNode root;

    public ShipmentBTree() {
        root = null;
    }

    // إضافة شحنة جديدة
    public void addShipment(Shipment shipment) {
        root = addShipmentRec(root, shipment);
    }

    private ShipmentNode addShipmentRec(ShipmentNode node, Shipment shipment) {
        if (node == null) {
            return new ShipmentNode(shipment);
        }

        if (shipment.getShipmentId() < node.shipment.getShipmentId()) {
            node.left = addShipmentRec(node.left, shipment);
        } else if (shipment.getShipmentId() > node.shipment.getShipmentId()) {
            node.right = addShipmentRec(node.right, shipment);
        }

        return node;
    }

    // البحث عن شحنة باستخدام المعرف
    public Shipment searchShipment(int shipmentId) {
        return searchShipmentRec(root, shipmentId);
    }

    private Shipment searchShipmentRec(ShipmentNode node, int shipmentId) {
        if (node == null || node.shipment.getShipmentId() == shipmentId) {
            return node != null ? node.shipment : null;
        }

        if (shipmentId < node.shipment.getShipmentId()) {
            return searchShipmentRec(node.left, shipmentId);
        }

        return searchShipmentRec(node.right, shipmentId);
    }

    // تحديث تاريخ التسليم
    public boolean updateDeliveryDate(int shipmentId, String newDeliveryDate) {
        Shipment shipment = searchShipment(shipmentId);
        if (shipment != null) {
            shipment.setDeliveryDate(newDeliveryDate);
            return true;
        }
        return false;
    }

    // إضافة طلب إلى شحنة
    public boolean addOrderToShipment(int shipmentId, Order order) {
        Shipment shipment = searchShipment(shipmentId);
        if (shipment != null) {
            shipment.addOrder(order);
            return true;
        }
        return false;
    }

    // عرض جميع الشحنات (لأغراض الاختبار)
    public void displayShipments() {
        displayShipmentsRec(root);
    }

    private void displayShipmentsRec(ShipmentNode node) {
        if (node != null) {
            displayShipmentsRec(node.left);
            System.out.println(node.shipment);
            displayShipmentsRec(node.right);
        }
    }
}
