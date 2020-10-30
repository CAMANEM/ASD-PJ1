package Code.List.Stack;

public class Stack {
    private Node last;
    int size;
    String list = "";

    public Stack() {
        last =  null;
        size = 0;
    }

    /*public boolean empty(){
        return last == null;
    }*/// This is going to be here just if we need to check if the stack is empty

    /**
     * This what give us is the possibility of
     * inset a new node to the list
     * @param node
     */
    public void insertNode(int node){
        System.out.println(node);

        Node newNode = new Node(node);
        newNode.next = last;
        last = newNode;
        size++;
    }

    /**
     * This give us the chance to obtain at first
     * the last element added to the stack
     * @return
     */
    public int delete(){
        int aux  = last.num;
        last = last.next;
        size --;
        return aux;
    }

    /**
     * It gives us the size of the hold stack
     * @return
     */
    public int stackSize(){
        return size;
    }
}
