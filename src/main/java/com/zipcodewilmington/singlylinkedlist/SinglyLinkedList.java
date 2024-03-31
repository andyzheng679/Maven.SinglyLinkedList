package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    private Node head;  //entry point, first node
    private int size;   //num of elements in linked list

    private class Node {
        int data;   //stores int data for node
        Node next;  //points to next node


        //node constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // If the list is empty, make the new node as the head
            head = newNode;
        } else {
            // If the list is not empty, traverse to the end and add the new node
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;  // Increase the size of the list
    }

    public void remove(int index) {
        // Check for index out of bounds
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // Remove head node
        if (index == 0) {
            head = head.next;
        } else {
            // Remove node other than head
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;  // Decrease the size of the list after removal
    }

    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true; // Found the element
            }
            current = current.next; // Move to the next node
        }
        return false; // Element not found after traversing the list
    }
    public int find(int data) {
        Node current = head;
        int index = 0; // Initialize index to track the position of current node
        while (current != null) {
            if (current.data == data) {
                return index; // Element found, return its index
            }
            current = current.next; // Move to the next node
            index++; // Increment index as we move through the list
        }
        return -1; // Element not found after traversing the list
    }

    public int size() {
        return size; // Return the size of the list
    }

    public int get(int index) {
        // Check if the index is out of bounds
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // Move to the next node
        }
        return current.data; // Return the data of the node at the specified index
    }

    public SinglyLinkedList copy() {
        SinglyLinkedList newList = new SinglyLinkedList(); // Create a new empty list
        Node current = this.head; // Start with the head of the current list

        while (current != null) {
            newList.add(current.data); // Use the add method to ensure proper linking
            current = current.next; // Move to the next node
        }

        return newList; // Return the new list
    }

}
