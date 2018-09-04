package com.daily;

/**
 * Created by json on 2018/8/16.
 * Describe:  二叉树结构  双链表 节点
 */
public class Node {

    //节点数据
    private int data;

    //左节点
    private Node left;

    //右节点
    private Node right;


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node() {
    }

    //判断 该节点 是否是空
    public boolean isEmpty() {
        if (this==null){
            return true;
        }else if (this.getData() == 0) {
            return true;
        } else {
            return false;
        }

    }

    //判断该节点 是否是满节点
    public boolean isFullNode(Node node) {
        return node.getRight().isEmpty();
    }

    //递归处
    public void InitNode( int[] datas,int i) {
        i++;
         if (i<datas.length){
             if (this.isEmpty()) {   //父节点
                 this.setData(datas[i]);
                 this.InitNode( datas,i);
             } else if (this.getLeft()==null||this.getLeft().isEmpty()) { //左子节点
                 Node left = new Node(datas[i]);
                 this.setLeft(left);
                 this.InitNode( datas,i);
             } else if (this.getRight()==null||this.getRight().isEmpty()) {//右子节点
                 Node right = new Node(datas[i]);
                 this.setRight(right);
                 Node node = this.left;
                 node.InitNode(datas,i);
             }
         }


    }

    public static void main(String[] args) {

        int[] datas = {7, 3, 5, 2, 4, 6};
        Node node = new Node();
        int i=-1;
        node.InitNode(datas,i);
        System.out.println(node);
    }
}
