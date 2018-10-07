package arboleos;

public class BinaryTree {
    BinaryNode root;
    Integer maxLevel = 0;

    private BinaryNode addRecursive(BinaryNode current, Double value) {
        if (current == null) {
            return new BinaryNode(value);
        }

        if (value <= current.getValue()) {
            if (current.setLeft(addRecursive(current.getLeft(), value)).getLevel() > maxLevel) maxLevel++;

        } else if (value > current.getValue()) {
            if (current.setRight(addRecursive(current.getRight(), value)).getLevel() > maxLevel) maxLevel++;
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(Double value) {
        root = addRecursive(root, value);
    }

    private BinaryNode containsNodeRecursive(BinaryNode actual, Double value) {
        if (actual == null) {
            return new BinaryNode();
        }
        if (actual.getValue().equals(value)) {
            return actual;
        }
        return value < actual.getValue() ? containsNodeRecursive(actual.getLeft(), value) :
                containsNodeRecursive(actual.getRight(), value);
    }

    public BinaryNode containsNode(Double value) {
        return containsNodeRecursive(root, value);
    }

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
