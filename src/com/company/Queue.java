package com.company;

public class Queue<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element){
            this.element = element;
        }
    }

    public String toString(){
        String st = "";

        Node<E> i = head;
        while(i != null) {
            st = st + i.element.toString() + " ";
            i = i.next;
        }

        return st;
    }

    public void offer(E element) {
        Node<E> newNode = new Node<E>(element);
        if(this.head == null) {
            this.head = newNode;
        }else {
            Node<E> current = this.head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    public E poll() {
        ensureNoEmpty();
        E element = this.head.element;
        if(this.size == 1){
            this.head = null;
        } else{
            Node<E> next = this.head.next;
            this.head.next = null;
            this.head = next;
        }
        this.size--;
        return element;
    }

    public E peek() {
        if (this.head.element == null)
            throw new IllegalStateException();
        return this.head.element;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size==0;
    }

    private void ensureNoEmpty() {
        if (this.size <= 0)
            throw new IllegalStateException();
    }
    public void printAllElements() {
        if (this.isEmpty()){
            System.out.println("There is no element!");
        }
        Node<E> current = head;
        while (true) {
            System.out.print(current.element + " ");
            current = current.next;
            if (current == null)
                break;
        }
        System.out.println();
    }
}
