package com.dawn.common.utils.dataStructures.trees;

/**
 * @Description:
 * @Date 2021-4-13 , 0013 22:34
 * @Author kousq
 */

public class BinaryTree<E extends MataData> {

    private Node node;

    private BinaryTree<E> root;

    private BinaryTree<E> left;

    private BinaryTree<E> right;


    public BinaryTree() {
        this.root = new BinaryTree();
        this.left = null;
        this.right = null;
    }

    public BinaryTree(BinaryTree<E> left ,BinaryTree<E> right,Node node) {
        this.root = new BinaryTree();
        this.root.node = node;
        this.root.left = left;
        this.root.right = right;
    }

    public int Height(BinaryTree root) {
        if (null == root) {
            return 0;
        } else {
            int i = Height(root.left);
            int j = Height(root.right);
            return (i < j)?j+1:i+1;
        }
    }

    public int Size(BinaryTree root){
        if(null == root){
            return 0;
        }else{
            return 1+Size(root.left)+Size(root.right);
        }
    }

    public void PreOrder(BinaryTree root){
        if(null != root){
            visit(root);
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    public void InOrder(BinaryTree root){
        if(null != root){
            InOrder(root.left);
            visit(root);
            InOrder(root.right);
        }
    }

    public void PostOrder(BinaryTree root){
        if(null != root){
            PostOrder(root.left);
            PostOrder(root.right);
            visit(root);
        }
    }

    public void insertNode(BinaryTree root, Node node){
        if(node == null){
            return;
               }
        if(root == null){
            BinaryTree bt = new BinaryTree( null,null,node);
            root = bt;
        }else {
            if(Height(root.left) > Height(root.right)){
                insertNode(root.right,node);
            }
            else {
                insertNode(root.left,node);
            }
        }
    }

    public BinaryTree copy(BinaryTree root){
        if(root != null){
            BinaryTree p = new BinaryTree();
            p.node = root.node;
            p.left = copy(root.left);
            p.right = copy(root.right);
            return p;
        }
        return null;
    }

    public void No_recursive_PreOrder(){

    }

    public void visit(BinaryTree root){
        if(root != null){
            System.out.println(root.node.getData());
        }
    }

    public void destory(BinaryTree root){
        if(null != root){
//            destory(root.left);
//            destory(root.right);
            root = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree a = new BinaryTree();
        Node e =new Node( 10);
        a.insertNode(null,e);
        a.visit(a);
    }
}
