public class AVLTree {
    private AvlNode root; 

    public AVLTree() {
        root = null;
    }

    // إضافة منتج جديد
    public void insert(Product product) {
        root = insertRec(root, product);
    }

    private AvlNode insertRec(AvlNode node, Product product) {
        if (node == null) {
            return new AvlNode(product);  // إذا كانت الشجرة فارغة أو وصلنا إلى عقدة فارغة
        }

        if (product.getProductID() < node.product.getProductID()) {
            node.left = insertRec(node.left, product);
        } else if (product.getProductID() > node.product.getProductID()) {
            node.right = insertRec(node.right, product);
        } else {
            return node; 
        }

        // تحديث ارتفاع العقدة
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // التحقق من التوازن
        int balance = getBalance(node);

        // التدوير حسب نوع الخلل في التوازن
        if (balance > 1 && product.getProductID() < node.left.product.getProductID()) {
            return rotateRight(node);
        }

        if (balance < -1 && product.getProductID() > node.right.product.getProductID()) {
            return rotateLeft(node);
        }

        if (balance > 1 && product.getProductID() > node.left.product.getProductID()) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && product.getProductID() < node.right.product.getProductID()) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // التدوير لليمين
    private AvlNode rotateRight(AvlNode y) {
        AvlNode x = y.left;
        AvlNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // التدوير لليسار
    private AvlNode rotateLeft(AvlNode x) {
        AvlNode y = x.right;
        AvlNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // الحصول على ارتفاع العقدة
    private int height(AvlNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(AvlNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // البحث عن منتج باستخدام المعرف
    public Product search(int id) {
        return searchRec(root, id);
    }

    private Product searchRec(AvlNode node, int id) {
        if (node == null || node.product.getProductID() == id) {
            return node != null ? node.product : null;
        }

        if (id < node.product.getProductID()) {
            return searchRec(node.left, id);
        }

        return searchRec(node.right, id);
    }

    // تحديث منتج
    public boolean updateProduct(int id, double newPrice, int newQuantity) {
        Product product = search(id);
        if (product != null && newPrice >= 0 && newQuantity <= 1000) {
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            return true;
        }
        return false;
    }

    // حذف منتج باستخدام المعرف
    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private AvlNode deleteRec(AvlNode node, int id) {
        if (node == null) {
            return null;
        }

        if (id < node.product.getProductID()) {
            node.left = deleteRec(node.left, id);
        } else if (id > node.product.getProductID()) {
            node.right = deleteRec(node.right, id);
        } else {
            // العقدة المراد حذفها
            if (node.left == null || node.right == null) {
                AvlNode temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    node = null; // عقدة بلا أبناء
                } else {
                    node = temp; // عقدة بطفل واحد
                }
            } else {
                // عقدة بطفلين
                AvlNode temp = getMinValueNode(node.right);
                node.product = temp.product;
                node.right = deleteRec(node.right, temp.product.getProductID());
            }
        }

        if (node == null) {
            return node;
        }

        // تحديث الارتفاع
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // التحقق من التوازن
        int balance = getBalance(node);

        // إعادة التوازن إذا لزم الأمر
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // إيجاد أصغر عقدة في الشجرة الفرعية
    private AvlNode getMinValueNode(AvlNode node) {
        AvlNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(AvlNode node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.println(node.product);
            inorderRec(node.right);
        }
    }
}