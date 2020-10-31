package Code.List.CircularLinked;

public class NodeCircular {
    String data;
    NodeCircular nextNode;
    NodeCircular prevNode;

    public NodeCircular(String data) {
        this.data = data;
        nextNode = null;
        prevNode = null;
    }
}
