import java.util.List;

public class Node {
    private int value;
    private Node next;

    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

}
