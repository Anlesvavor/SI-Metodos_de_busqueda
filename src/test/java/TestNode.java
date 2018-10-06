import arboleos.Node;
import arboleos.SearchRoute;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNode {

    @Test
    public void agregarNodo() {
        Node<Integer> arbol = new Node<Integer>(new Integer("5"));
        arbol.addChild(new Node<Integer>(2));
        arbol.addChild(new Node<Integer>(6));
        arbol.addChild(new Node<Integer>(27).addChild(new Node<Integer>(new Integer(909))));
        arbol.addChild(new Node<Integer>(1));
        arbol.addChild(new Node<Integer>(5));

        System.out.println(arbol.toStringNice());
    }

    @Test
    public void agregarNod2() {
        Node<Integer> arbol = new Node<Integer>(3).addChild(new Node<Integer>(2));
        System.out.println(arbol.toString());
    }

    @Test
    public void agregarNod3() {
        Node<Integer> raiz = new Node<>(3);
        raiz.addChild(new Node<>(2));
        raiz.addChild(new Node<>(5));
        System.out.println(raiz.getNChild(0).toString());
        raiz.getNChild(1).addChild(new Node<>(6)).addChild(new Node<>(9));
        System.out.println(raiz.toString());
    }

    @Test
    public void busquedaEnProfundidad() {
        Node<Integer> raiz = new Node<>(5);
        SearchRoute<Integer> ruta = new SearchRoute<>();
        raiz.addChild(new Node<>(4));
        raiz.addChild(new Node<>(6));
        raiz.getNChild(0).addChild(new Node<>(1));
        raiz.getNChild(0).addChild(new Node<>(2));
        raiz.getNChild(1).addChild(new Node<>(9));
        raiz.getNChild(1).addChild(new Node<>(70));

        Assertions.assertEquals(raiz.getNChild(0).getNChild(0), raiz.depthSearch(1).getNode());
        Assertions.assertEquals(raiz.getChildren().get(0).getChildren().get(1), raiz.depthSearch(2).getNode());
        Assertions.assertEquals(raiz.getNChild(1).getNChild(0), raiz.depthSearch(9).getNode());
        Assertions.assertEquals(raiz.getNChild(1).getNChild(1), raiz.depthSearch(70).getNode());
        Assertions.assertEquals(raiz.getNChild(0), raiz.depthSearch(4).getNode());
        Assertions.assertEquals(raiz.getNChild(1), raiz.depthSearch(6).getNode());
        ruta = raiz.depthSearch(5);
        Assertions.assertEquals(raiz.getData(), ruta.getNode().getData());
        ruta.getRoute().forEach(integerNode -> {
            System.out.println(integerNode.getData());
        });
        raiz.depthSearch(70).getRoute().forEach(integerNode -> System.out.println(integerNode.getData()));
    }

    @Test
    public void busquedaEnAnchura() {
        Node<Integer> raiz = new Node<>(10);
        raiz.addChild(new Node<>(5));
        raiz.addChild(new Node<>(15));
        raiz.getNChild(0).addChild(new Node<>(2));
        raiz.getNChild(0).addChild(new Node<>(3));
        raiz.getNChild(1).addChild(new Node<>(16));
        raiz.getNChild(1).addChild(new Node<>(17));

        Assertions.assertEquals(raiz.getNChild(1).getNChild(1), raiz.depthSearch(17).getNode());

        raiz.broadSearch(17).getRoute().forEach(System.out::println);
    }


}
