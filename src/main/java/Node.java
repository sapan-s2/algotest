/*package whatever //do not write package name here */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {

    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right;

    }

}

class BinaryTree {

    Node root;
    private boolean runPrevflag;

    public static void main(String[] args) {
        System.out.println("GfG!");

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(0);
        tree.root.left = new Node(1);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
//        tree.root.left.right = new Node(4);
//        tree.root.right.left = new Node(5);
//        tree.root.right.right = new Node(6);
//        tree.root.right.right.left = new Node(7);
//        tree.root.right.left.right = new Node(8);
//        tree.root.right.left.right.right = new Node(9);

//        tree.printTree(tree.root);
//        tree.printLevelOrder();
        System.out.println("----");
        System.out.println( "height of the tree " +  tree.getHeight(tree.root));

    }

   int getHeight(Node node){
//        int nleft = 0;
  int nodeHt = 0;
//        int nright = 0;
        if( node == null )
            return 0;

                 int   nleft = getHeight(node.left);
            int nright = getHeight(node.right);

            if(nleft > nright){

                return nleft + 1;

            }
            else
                return nright + 1 ;
//return nodeHt;
    }


    void printLevelOrder()
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty())
        {

            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    void printTree(Node n) {

        System.out.println(n.data);
        outputData(n);
        Node nl = null;
        Node rl = null;


        while (n != null) {
//                System.out.println(n.data);


            if (rl != null) {
                outputData(rl);
                rl = null;
                n = nl;
            }

//                if( nl != null){
//                    outputData(nl);
//                    nl = null;
//                }

            if (n.left != null) {
                outputData(n.left);
                nl = n.left;
//                  n = n.left;
            }


            if (n.right != null) {
                outputData(n.right);
                rl = n.right;
            }

            if (n.left == null && n.right == null) {
                n = null;
            }


        }
//            outputData( n.right.right);


    }

    private void outputData(Node n) {

//		System.out.println(n.data);

        if (n.left != null) {
            System.out.println(n.left.data);
        }

        if (n.right != null) {
            System.out.println(n.right.data);
        }
    }


}