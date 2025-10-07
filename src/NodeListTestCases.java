import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// covers 100% of Node and NodeList classes
public class NodeListTestCases {

    @Test
    public void nodeGetters(){
        Node test = new Node(1, null);
        assertEquals(test.getNext(), null);
        assertEquals(test.getValue(), 1);
    }


    @Test
    public void testGetNext() {
        NodeList list = new NodeList();
        list.append(7); // next
        list.append(1); // cur
        assertEquals(7, list.getNext().getValue());
    }

    @Test
    public void testAppend(){
        NodeList test = new NodeList();
        test.append(1);
        test.append(2);
        test.append(3);
        assertEquals(test.toString(), "123");
        assertEquals(test.getLength(), 3);
    }


    @Test
    public void testGetLength() {
        NodeList list = new NodeList();
        list.append(4);
        list.append(8);
        list.append(12);
        assertEquals(3, list.getLength());
    }

    @Test
    public void testRemove() {
        NodeList list = new NodeList();
        list.append(4);
        list.append(8);
        list.append(1);
        list.remove();
        assertEquals(list.toString(), "48");
    }

    @Test
    public void testReverse() {
        NodeList nodeList = new NodeList();
        assertEquals(nodeList.getVal(), null);
        nodeList.append(5);
        nodeList.append(3);
        NodeList reversed = nodeList.reverse();
        assertEquals(reversed.toString(), "35");
        nodeList.resetCur();
        assertEquals(nodeList.getVal(), 3);
        assertEquals(nodeList.getCur().getValue(), 3);
        nodeList.incrementCur();
        assertEquals(nodeList.getCur().getValue(), 5);
        nodeList.resetCur();
        assertEquals(nodeList.getCur().getValue(), 3);
        nodeList.incrementCur();
        nodeList.incrementCur();
        assertEquals(nodeList.getCur(), null);
        assertEquals(nodeList.incrementCur(), null);

    }
}
