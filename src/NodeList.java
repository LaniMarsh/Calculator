public class NodeList {
    private Node head;
    private Node cur;

    public NodeList(){
        this.head = null;
        this.cur = this.head;
    }

    public String toString(){
        Node cur = head;
        String s = "";
        while(cur != null){
            s = cur.getValue() +s;
            cur = cur.getNext();
        }
        // Find the index of the first non-zero digit
        int firstNonZeroIndex = 0;
        while (firstNonZeroIndex < s.length() && s.charAt(firstNonZeroIndex) == '0') {
            firstNonZeroIndex++;
        }

        String result = s.substring(firstNonZeroIndex);
        if (result == ""){
            return "0";
        }
        //System.out.println(result);
        return result;
    }

    public void append(int val){
        Node next = new Node(val, head);
        if (head == null){
            head = next;
            return;
        }
        head = next;
    }

    public int getLength() {
        int length = 0;
        Node cur = head;
        while (cur != null) {
            length++;
            cur = cur.getNext();
        }
        return length;
    }

    public Node getNext() { return head.getNext();}

    public Integer getVal() {
        if (head == null){
            return null;
        }
        return head.getValue();
    }

    public void remove(){
        if (head != null){
            head = head.getNext();
        }
    }
    public Node incrementCur() {
        if (this.cur == null){
            return null;
        }
        this.cur = this.cur.getNext();
        return this.cur;
    }

    public Node getCur(){
        return this.cur;
    }

    public void resetCur(){
        this.cur = this.head;
    }

    public NodeList reverse(){
        this.cur = this.head;
        NodeList rev = new NodeList();
        while(this.cur != null) {
            rev.append(this.cur.getValue());
            incrementCur();
        }
        return rev;
    }

}
