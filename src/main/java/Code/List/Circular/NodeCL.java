package Code.List.Circular;

import javax.swing.*;

public class NodeCL {
    JButton data;
    NodeCL next;

    public NodeCL(JButton button){
        this.data = button;
        this.next = this;
    }
}
