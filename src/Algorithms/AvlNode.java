public class AvlNode {
    Product product; 
    AvlNode left, right; 
    int height;       
    public AvlNode(Product product) {
        this.product = product;
        this.left = this.right = null;
        this.height = 1;
    }
}
