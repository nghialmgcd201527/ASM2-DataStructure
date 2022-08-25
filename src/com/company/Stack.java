package com.company;

public class Stack<E> {
    private Node<E> top;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> previous;

        public Node(E element){
            this.element = element;
        }
    }

    public String toString(){
        String st = "";

        Node<E> i = top;
        while(i != null) {
            st = st + i.element.toString() + " ";
            i = i.previous;
        }

        return st;
    }

    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.previous = top;
        top = newNode;
        this.size++;
    }

    public E pop() {
        ensureNoEmpty();
        E element = this.top.element;
        Node<E> cache = this.top.previous;
        this.top.previous = null;
        this.top = cache;
        this.size--;
        return element;
    }

    public E peek() {
        ensureNoEmpty();
        return this.top.element;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    private void ensureNoEmpty() {
        if (this.size <= 0)
            throw new IllegalStateException();
    }

    public void printAllElements() {
        if (this.isEmpty()){
            System.out.println("There is no element!");
        }
        Node<E> current = top;
        while (true) {
            System.out.print(current.element + " ");
            current = current.previous;
            if (current == null)
                break;
        }
        System.out.println();
    }
}
