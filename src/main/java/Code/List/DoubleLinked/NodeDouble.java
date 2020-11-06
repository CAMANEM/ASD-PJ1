package Code.List.DoubleLinked;

public class NodeDouble {
    public String data;
    NodeDouble next;
    NodeDouble prev;

    /**
     * It creates a new node
     * @param data the info of the node
     */
    public NodeDouble(String data){

        this(data, null, null);
    }

    /**
     * It creates a new node
     * @param data the info of the node
     * @param next the next node
     * @param prev the prev node
     */
    public NodeDouble(String data, NodeDouble next, NodeDouble prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }


}
