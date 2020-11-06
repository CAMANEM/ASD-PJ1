package Code.List.DoubleLinked;

public class DoubleList {
    private NodeDouble first;
    private NodeDouble last;

    public DoubleList() {
        first = null;
        last = null;
    }

    /**
     * It determines if the list is empty or not
     * @return boolean  value
     */
    public boolean verification(){

        return first == null;
    }

    /**
     * It inserts to the list every node, it is
     * being added at the end of the list
     * @param data data that is going to be added
     */
    public void insert(String data){
        if(!verification()){
            last = new NodeDouble(data, null, last);
            last.prev.next = last;

        }else{
            first = last = new NodeDouble(data);

        }
    }

    /**
     * It inserts to the list every node, it is
     * being added at the beginning of the list
     * @param data data that is going to be added
     */
    public void insertP(String data){
        if(!verification()){
            first = new NodeDouble(data, first, null);
            first.next.prev = first;

        }else{
            first = last = new NodeDouble(data);

        }
    }

    /**
     * It show us the nodes, and the information
     * inside of them
     */
    public void showDouble (){
        if(!verification()){
            NodeDouble aux = first;
            while (aux!=null){
                System.out.println(aux.data);
                aux = aux.next;
            }
        }
    }

}
