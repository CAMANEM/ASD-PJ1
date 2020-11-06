package Code.List.Stack;

public class Stack {
    private NodeStack last;
    int size;
    String list = "";

    public Stack() {
        last =  null;
        size = 0;
    }

    /**
     * This what give us is the possibility of
     * inset a new node to the list
     * @param node
     */
    public void insertNode(int node){
        System.out.println(node);

        NodeStack newNode = new NodeStack(node);
        newNode.next = last;
        last = newNode;
        size++;
    }

    /**
     * This give us the chance to obtain at first
     * the last element added to the stack
     * @return aux
     */
    public int delete(){
        int aux  = last.num;
        last = last.next;
        size --;
        return aux;
    }

    /**
     * It gives us the size of the hold stack
     * @return size
     */
    public int stackSize(){
        return size;
    }
}
