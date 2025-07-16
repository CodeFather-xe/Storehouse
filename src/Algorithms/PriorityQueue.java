import LogicalClasses.Order;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    private List<Order> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    // إضافة طلب جديد مع أولوية
    public void addOrder(Order order) {
        heap.add(order);
        heapifyUp(heap.size() - 1);
    }

    // جلب الطلب ذو الأولوية العالية
    public Order removeHighestPriorityOrder() {
        if (heap.isEmpty()) {
            return null;
        }
        Order highestPriorityOrder = heap.get(0);
        Order lastOrder = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastOrder);
            heapifyDown(0);
        }
        return highestPriorityOrder;
    }

    // تحديث أولوية طلب
    public void updateOrderPriority(String orderID, int newPriority) {
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i).getOrderID().equals(orderID)) {
                heap.get(i).setPriority(newPriority);
                heapifyUp(i);
                heapifyDown(i);
                break;
            }
        }
    }

    // حساب تكلفة الطلبات
    public double calculateTotalCost() {
        double totalCost = 0;
        for (Order order : heap) {
            totalCost += order.getCost();
        }
        return totalCost;
    }

    // إنشاء تقارير تحليلية
    public void generateReport() {
        System.out.println("Total Cost of Orders: " + calculateTotalCost());
        System.out.println("High Cost Orders:");
        for (Order order : heap) {
            if (order.getCost() > 1000) { // مثال على تحديد الطلبات عالية التكلفة
                System.out.println(order);
            }
        }
    }

    // دالة لترتيب الهيب لأعلى
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).getPriority() < heap.get(parentIndex).getPriority()) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // دالة لترتيب الهيب لأسفل
    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).getPriority() < heap.get(smallestIndex).getPriority()) {
            smallestIndex = leftChildIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).getPriority() < heap.get(smallestIndex).getPriority()) {
            smallestIndex = rightChildIndex;
        }
        if (smallestIndex != index) {
            swap(index, smallestIndex);
            heapifyDown(smallestIndex);
        }
    }

    // دالة لتبديل العناصر في الهيب
    private void swap(int index1, int index2) {
        Order temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
