package Code.List.CircularLinked;

public class NodeCircular {
    String data;
    NodeCircular nextNode;
    NodeCircular prevNode;

    /**
     * Creates a new node type in this list
     * @param data data inside the node
     */
    public NodeCircular(String data) {
        this.data = data;
        nextNode = null;
        prevNode = null;
    }
}
