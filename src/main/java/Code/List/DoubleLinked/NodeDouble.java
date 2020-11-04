package Code.List.DoubleLinked;

public class NodeDouble {
    public String data;
    NodeDouble next;
    NodeDouble prev;

    public NodeDouble(String data){
        this(data, null, null);
    }

    public NodeDouble(String data, NodeDouble next, NodeDouble prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }


}
