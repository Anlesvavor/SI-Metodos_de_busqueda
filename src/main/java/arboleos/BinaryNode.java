package arboleos;


public class BinaryNode<T> {
    /*
        public class BinaryTree {
            BinaryNode root;
        }
    */
    private Double value;
    private BinaryNode left;
    private BinaryNode right;
    private Integer level = 0;
    private BinaryNode parent;

    BinaryNode(Double value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }

    BinaryNode(Double value, BinaryNode parent) {
        this.value = value;
        this.right = null;
        this.left = null;
        this.parent = parent;
    }

    BinaryNode() {
        this.value = null;
        this.right = null;
        this.left = null;
        this.level = -1;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public BinaryNode setLeft(BinaryNode left) {
        this.left = left;
        this.left.parent = this;
        this.left.level = this.level + 1;
        return this.left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public BinaryNode setRight(BinaryNode right) {
        this.right = right;
        this.right.parent = this;
        this.right.level = this.level + 1;
        return this.right;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public BinaryNode getParent() {
        return parent;
    }

    public void setParent(BinaryNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        String p = parent == null ? "null" : String.valueOf(parent.getValue());
        return "{" +
                "value=" + value +
                ", parent=" + p +
                ", level=" + level +
                ", left=" + left +
                ", right=" + right +
                "}";
    }

    public String showTree() {
        return String.format("{%s, %s %s}", value.toString(), left == null ? "null" : left.showTree()
                , right == null ? "null" : right.showTree());
    }

    public String niceShowTree() {
        return String.format("{%s, %s %s}", value.toString(), left == null ? "" : left.niceShowTree()
                , right == null ? "" : right.niceShowTree());
    }

    public String nicerShowTree() {
        return String.format("%s %s %s", left == null ? "" : left.nicerShowTree()
                , value.toString(), right == null ? "" : right.nicerShowTree());
    }

}
