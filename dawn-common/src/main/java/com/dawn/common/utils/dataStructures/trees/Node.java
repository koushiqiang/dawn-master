package com.dawn.common.utils.dataStructures.trees;

/**
 * @Description:泛型Node
 * @Date 2021-7-15 , 0015 22:34
 * @Author kousq
 */
public class Node<E > {

    public E data;
    /**
     * Value to put in the node
     * @param value
     */
    public Node(E value){
        this.data = value;
    }


    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}

