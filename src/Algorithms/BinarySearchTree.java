public class BinarySearchTree {
   

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // إضافة منتج جديد
    public void insert(Product product) {
        root = insertRec(root, product);
    }

    private Node insertRec(Node root, Product product) {
        if (root == null) {
            root = new Node(product);
            return root;
        }

        if (product.getProductID() < root.product.getProductID()) {
            root.left = insertRec(root.left, product);
        } else if (product.getProductID() >  root.product.getProductID()) {
            root.right = insertRec(root.right, product);
        }

        return root;
    }

    // البحث عن منتج باستخدام المعرف
    public Product search(int id) {
        return searchRec(root, id);
    }

    private Product searchRec(Node root, int id) {
        if (root == null || root.product.getProductID() == id) {
            return root != null ? root.product : null;
        }

        if (id < root.product.getProductID()) {
            return searchRec(root.left, id);
        }

        return searchRec(root.right, id);
    }

    // تحديث الكمية أو السعر
    public boolean updateProduct(int id, double newPrice, int newQuantity) {
        Product product = search(id);
        if (product != null && newPrice >= 0 && newQuantity <= 1000) {
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            return true;
        }
        return false;
    }

    // حذف منتج
    public boolean deleteProduct(int id) {
        root = deleteRec(root, id);
        return root != null;
    }

    private Node deleteRec(Node root, int id) {
        if (root == null) {
            return root;
        }

        if (id < root.product.getProductID()) {
            root.left = deleteRec(root.left, id);
        } else if (id > root.product.getProductID()) {
            root.right = deleteRec(root.right, id);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.product = minValue(root.right);
            root.right = deleteRec(root.right, root.product.getProductID());
        }

        return root;
    }

    private Product minValue(Node root) {
        Product minProduct = root.product;
        while (root.left != null) {
            minProduct = root.left.product;
            root = root.left;
        }
        return minProduct;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.product);
            inorderRec(root.right);
        }
    }
}
