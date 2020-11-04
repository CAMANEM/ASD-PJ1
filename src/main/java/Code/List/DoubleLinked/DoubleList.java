package Code.List.DoubleLinked;

public class DoubleList {
    private NodeDouble first;
    private NodeDouble last;

    public DoubleList() {
        first = null;
        last = null;
    }

    public boolean verification(){

        return first == null;
    }

    public void insert(String data){
        if(!verification()){
            last = new NodeDouble(data, null, last);
            last.prev.next = last;

        }else{
            first = last = new NodeDouble(data);

        }
    }

    public void insertP(String data){
        if(!verification()){
            first = new NodeDouble(data, first, null);
            first.next.prev = first;

        }else{
            first = last = new NodeDouble(data);

        }
    }

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
