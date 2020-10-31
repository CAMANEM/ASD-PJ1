package Code.List.CircularLinked;

public class Circular {
    int size = 0;
    NodeCircular first;
    NodeCircular last;

    public boolean verification(){
        return size == 0;
    }

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

    public int size (){

        return size;
    }

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
