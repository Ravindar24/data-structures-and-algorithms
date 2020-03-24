package LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {

        /*
             We are assuming we want to store int.
             But we can store anything from String to complex class objects.
        */
        private int value;
        public Node next;

        // Constructor to initiliaze the node with data
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    LinkedList() {
        this.head = this.tail = null;
    }

    // To check whether Link List is empty.
    private boolean isEmpty() {
        return  head == null;
    }

    // To find the previous node or Link for a given Node.
    private Node getPrevious(Node node) {
        var current = head;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    /*
        To return the size of Link List. Time complexity for this method is O(1).
        Rather than interating each and every time over the list we can maintain
        a variable to hold the size which results in faster performance.
    */
    public int size() {
        return size;
    }

    // Add the Node at the beginning of Link List
    public void addFirst(int value) {
        var node = new Node(value);

        if(isEmpty())
            head = tail = node;
        else {
            node.next = head;
            head = node;
        }
        size++;
    }

    // Add the Node at the beginning of Link List
    public void addLast(int value) {
        var node = new Node(value);

        if(isEmpty())
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    // Delete the First Node from Link List
    public void deleteFirst() {
        if(isEmpty())
            throw new NoSuchElementException();

        if(head == tail)
            head = tail = null;
        else {
            var second = head.next;
            head.next = null;
            head = second;
        }

        size--;
    }

    // Delete the Last Node from Link List
    public void deleteLast() {
        if(isEmpty())
            throw new NoSuchElementException();

        if(head == tail)
            head = tail = null;
        else {
            var previous = getPrevious(tail);
            tail = previous;
            previous.next = null;
        }

        size--;
    }

    // To find out whether a List contains a element or not.
    public boolean contains(int value) {
        return  indexOf(value) != -1;
    }

    // Returns -1 if element does not exist in Link List else return it's 0 based index
    public int indexOf(int value) {
        var current = head;
        int index = 0;

        while(current != null) {
            if(current.value == value) return  index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int[] toArray() {
        int[] array = new int[size];
        int index = 0;
        var current = head;

        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return  array;
    }

    public void reverse() {
        var current = head;
        Node previous = null;

        while(current != null) {
            var temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        tail = head;
        tail.next = null;
        head = previous;
    }

    public int kthElementFromEnd(int k) {

        if (isEmpty())
            throw  new IllegalStateException();

        var slow = head;
        var current = head;

        int index = 1;
        while (index < k){
            current = current.next;

            if (current == null)
                throw new NoSuchElementException();
            index++;
        }

        while (current != tail) {
            current = current.next;
            slow = slow.next;
        }

        return slow.value;

    }

}
