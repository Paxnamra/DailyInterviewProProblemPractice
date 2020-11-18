package java_lang.Problem20201117;

import java.util.ArrayList;

public class Node {
    /*
    Nov 17 2020
    A k-ary tree is a tree with k-children, and a tree is symmetrical if the data of the left side of the tree is the same as the right side of the tree.
    */

    private int value;
    private Node[] node = null;

    public Node(int value) {
        this.value = value;
    }
    
    public Node(int value, Node[] node) {
        this.value = value;
        this.node = node;
    }

    public Node[] getChildren() {
        return this.node;
    }

    public int getValue() {
        return this.value;
    }

    public void addChildren(int v) {
        Node n = new Node(v);
        if (this.node == null) {
            Node[] newNodeArray = {n};
            this.node = newNodeArray;
        } else {
            Node[] newNodeArray = new Node[this.node.length + 1];
            int size = this.node.length;
            for (int i = 0; i < size; i++) {
                newNodeArray[i] = this.node[i];
            } // end for
            newNodeArray[size] = n;
            this.node = newNodeArray;
        }
    }

    public void printTree() {
        printTreeHelper(this);
    }

    private void printTreeHelper(Node t) {
        System.out.print(t.getValue());
        if (t.getChildren() == null)
            return;
        else {
            Node[] tmp = t.getChildren();
            int size = tmp.length;
            for (int i = 0; i < size; i++) {
                t.printTreeHelper(tmp[i]);
            }
        }
    }

    public void is_symmetric() {
        ArrayList<Integer> left = extractDataLeft(this.getChildren()[0]);
        ArrayList<Integer> right = extractDataRight(this.getChildren()[1]);
        System.out.println(left.toString());
        System.out.println(right.toString());
    }

    private ArrayList<Integer> extractDataLeft(Node t) {
        ArrayList<Integer> arl = new ArrayList<Integer>();
        if (t.getChildren() == null) {
            arl.add(t.getValue());
            return arl;
        } else {
            arl.add(t.getValue());
            Node[] tmp = t.getChildren();
            int size = tmp.length;
            for (int i = 0; i < size; i++) {
                arl.addAll(extractDataLeft(tmp[i]));
            }
            return arl;
        }
    }

    private ArrayList<Integer> extractDataRight(Node t) {
        ArrayList<Integer> arl = new ArrayList<Integer>();
        if (t.getChildren() == null) {
            arl.add(t.getValue());
            return arl;
        } else {
            arl.add(t.getValue());
            Node[] tmp = t.getChildren();
            int size = tmp.length;
            for (int i = size - 1; i > -1; i--) {
                arl.addAll(extractDataRight(tmp[i]));
            }
            return arl;
        }
    }


    public static void main(String[] args) {        
        Node tree = new Node(4);
        tree.addChildren(3);
        tree.addChildren(3);
        tree.getChildren()[0].addChildren(9);
        tree.getChildren()[0].addChildren(4);
        tree.getChildren()[0].addChildren(1);
        tree.getChildren()[1].addChildren(1);
        tree.getChildren()[1].addChildren(4);
        tree.getChildren()[1].addChildren(9);

        // tree.printTree();
        tree.is_symmetric();
        

        
    }
}