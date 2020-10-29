package Code.List;

import javax.swing.*;

public class ListCL {
    NodeCL last;

    public ListCL(){
        this.last = null;

    }
    /**
     *It shows if the actual list is empty
     */

    public boolean verification(){

        return this.last == null;
    }

    /**
     * This method inserts new nodes
     */
    public ListCL insert(JButton element){
        NodeCL newNode = new NodeCL(element);
        if(this.last != null){
            newNode.next = this.last.next;
            last.next = newNode;
        }
        last = newNode;
        return this;
    }

    /**
     * This method gives us the list
     */
    public void showList(){
        NodeCL aux = last.next;
        String chain = "";
        do{
            chain = chain + "[" + aux.data + "] ->";
            aux = aux.next;

        }while (aux != last.next);
        System.out.println(chain);
    }

}
