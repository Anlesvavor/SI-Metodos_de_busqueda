package arboleos;

public class BinaryNode<T> implements SearchMethods<T> {

    private T data = null;
    private BinaryNode<T> leftChild = null;
    private BinaryNode<T> rigthChild = null;
    private BinaryNode<T> parent = null;
    private Integer level = 0;

    public BinaryNode(T data) {
        this.data = data;
    }

    public BinaryNode(BinaryNode<T> another) {
        this.data = another.data;
        this.leftChild = another.leftChild;
        this.rigthChild = another.rigthChild;
        this.parent = another.parent;
        this.level = another.level;
    }

    public BinaryNode() {
        this.level = -1;
    }


    public BinaryNode<T> addChild(BinaryNode<T> child, BinaryNode<T> p) {
        child.setParent(p);
        p.setLeftChild(child);
        child.setLevel(p.getLevel() + 1);
        return child;
    }

    public void addData(T data) {
        if ((Double) data <= (Double) this.data) {
            if (this.leftChild == null) {
                this.setLeftChild(new BinaryNode<>(data));
            } else {
                this.leftChild.addData(data);
            }
        } else {
            if (this.rigthChild == null) {
                this.setRigthChild(new BinaryNode<>(data));
            } else {
                this.rigthChild.addData(data);
            }
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode<T> getParent() {
        return parent;
    }

    public void setParent(BinaryNode<T> parent) {
        this.parent = parent;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public BinaryNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode<T> getRigthChild() {
        return rigthChild;
    }

    public void setRigthChild(BinaryNode<T> rigthChild) {
        this.rigthChild = rigthChild;
    }

    @Override
    public SearchRoute<T> depthSearch(T data) {
        return null;
    }

    @Override
    public SearchRoute<T> breadthSearch(T data) {
        return null;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "data=" + data +
                ", level=" + level +
                ", leftChild=" + leftChild +
                ", rigthChild=" + rigthChild +
                '}';
    }
}
