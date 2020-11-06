package Code.List.CircularLinked;

public class Circular {
    int size = 0;
    NodeCircular first;
    NodeCircular last;

    /**
     * It determine if the circular list is empty
     * or not
     * @return boolean value
     */
    public boolean verification(){
        return size == 0;
    }

    /**
     * It insets a new node to the circular list
     * @param data String
     */
    public void insert(String data){
        NodeCircular newNode  =  new NodeCircular(data);

        if(verification()){
            first = newNode;
            last = newNode;

            first.nextNode = last;
            last.nextNode = first;
            first.prevNode = last;
            last.prevNode = first;

            size ++;

        }else{
            NodeCircular aux = last;
            aux.nextNode = newNode;
            newNode.prevNode = aux;

            last = newNode;

            size ++;
        }
    }


    /**
     * It give us the size of the circular list
     * in a determine moment.
     * @return Int
     */
    public int size (){

        return size;
    }

    /**
     * Show us in console the contend in the
     * circular list
     */
    public void showCircular (){
        if(!verification()){
            NodeCircular aux = first;

            for(int i = 0; i < size; i++){
                System.out.print(aux.data + "  ");
                aux = aux.nextNode;
            }

        }else {
            System.out.println("Esta pelada");
        }
    }

    /**
     * It give us the contend of an specific node
     * @param pos int, poss in the list
     * @return the contend of that node
     */
    public String getID (int pos){
        NodeCircular aux = first;
        for (int i = 0; i < size; i++){
            if (pos == i){
                break;
            }else{
                aux = aux.nextNode;
            }
        }
        return aux.data;
    }

    /**
     * It modify the contend that is inside
     * of some node
     * @param pos the poss that is going to be modify
     * @param data the info that is going to be added
     */
    public void modify (int pos, String data){

        if (verification()){
            System.out.println("Circular list empty");
        }else{
            if(pos == 0){
                first.data = data;
            }else{
                if (pos > 0 && pos < size){
                    NodeCircular aux = first;
                    for (int i = 0; i < size-1; i++){
                        if(i == pos -1){
                            NodeCircular mod = aux.nextNode;
                            mod.data = data;

                            aux.nextNode = mod;

                        }else{
                            aux = aux.nextNode;
                        }
                    }
                }else{
                    System.out.println("Poa out of range");
                }

            }
        }

    }
}
