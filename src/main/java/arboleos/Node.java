package arboleos;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private T data = null;
    private List<Node<T>> children = new ArrayList<>();
    private Node<T> parent = null;
    private Integer level = 0;

    public Node(T data) {
        this.data = data;
    }

    public Node(Node<T> another) {
        this.data = another.data;
        this.children = another.children;
        this.parent = another.parent;
        this.level = another.level;
    }

    public Node() {
        this.level = -1;
    }

    public Node<T> addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
        child.setLevel(child.parent.level + 1);
        return child;
    }

    public void addChildren(List<Node<T>> children) {
        children.forEach(each -> each.setParent(this));
        this.children.addAll(children);
    }

    public Node<T> getNChild(Integer n) {
        return this.getChildren().get(n);
    }

    //Metodos de búsqueda
    //Busca desde el nodo usado como raiz
    /*
    public Node<T> depthSearch(T data){

        if(this.getData().equals(data)){
            return this;
        }else{
            if (!this.getChildren().isEmpty()) {
                for (Node<T> c : this.children) {
                    if (c.getData().equals(data)) {
                        return c;
                    } else {
                        c.depthSearch(data);
                    }
                }
            }
        }
        return this;
    }
    */
    public SearchRoute<T> depthSearch(T data) {
        Node<T> copy = new Node<>(this);
        //ArrayList<Node<T>> l = new ArrayList<>(copy.getChildren());
        ArrayList<Node<T>> l = new ArrayList<>();
        ArrayList<Node<T>> v = new ArrayList<>();
        l.add(0, copy);
        Node<T> n;
        do {
            if (l.isEmpty()) {
                v.add(l.get(0));
                if (l.equals(data)) return new SearchRoute<>(l.get(0), v);
            } else {
                n = l.remove(0);
                v.add(n);
                if (n.getData().equals(data)) {
                    return new SearchRoute<>(n, v);
                } else {
                    if (!n.getChildren().isEmpty()) l.addAll(0, n.getChildren());
                }
            }
        } while (!l.isEmpty());
        return new SearchRoute<>(new Node<>(), new ArrayList<>());
    }


    public SearchRoute<T> broadSearch(T data) {
        Node<T> copy = new Node<>(this);
        ArrayList<Node<T>> l = new ArrayList<>();
        ArrayList<Node<T>> v = new ArrayList<>();
        l.add(0, copy);
        Node<T> n;
        do {
            if (l.isEmpty()) {
                v.add(l.get(0));
                if (l.equals(data)) return new SearchRoute<T>(l.get(0), v);
            } else {
                n = l.remove(0);
                v.add(n);
                if (n.getData().equals(data)) {
                    return new SearchRoute<>(n, v);
                } else {
                    if (!n.getChildren().isEmpty()) l.addAll(l.size(), n.getChildren());
                }
            }
        } while (!l.isEmpty());
        return new SearchRoute<>(new Node<>(), new ArrayList<>());
    }


    //

    public List<Node<T>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getParent() {
        return parent;
    }

    private void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Integer getLevel() {
        return level;
    }

    private void setLevel(Integer level) {
        this.level = level;
    }

    //@Override
    public String toStringNice() {
        return "Node{" +
                "\n\tlevel=" + level +
                "\n\tdata=" + data +
                "\n\tchildren=\n\t" + children +
                '}';

    }

    @Override
    public String toString() {
        return "Node{" +
                "level=" + level +
                ", data=" + data +
                ", children=" + children +
                '}';
    }
}
