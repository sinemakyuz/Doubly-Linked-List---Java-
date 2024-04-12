/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05190000073final;

/**
 *
 * @author sinem
 */
public class DoublyLinkedList {

    public class Node {  //node class is written as inner class

        private CustomerInfo info;
        private Node prev; //previous node
        private Node next;  //next node

        Node(CustomerInfo val) {  
            info = val;
            prev = next = null;
        }
        Node(Node prev, Node next, CustomerInfo val ) {
            this.prev = prev;
            this.next = next;
            info = val;
        }

        public Object getInfo() {
            return info;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }

        public void setInfo(CustomerInfo info) {
            this.info = info;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    private Node head;  //holds the first node of the list
    private Node tail;  // holds the last node of the list

    public DoublyLinkedList() {
        tail = head = null;
    }

    public boolean isEmpty() {  //returns true if list is empty
        return head == null;
    }

    public void insertSorted(CustomerInfo customer) {  //adds the customer info given 
        if (isEmpty()) {
            head = tail = new Node(null, null, customer);
        
        } else if (head.info.getSurname().compareToIgnoreCase(customer.getSurname()) > 0) {
            head = head.prev = new Node(null, head, customer);
        
        } else if (tail.info.getSurname().compareToIgnoreCase(customer.getSurname()) <= 0) {
            tail = tail.next = new Node(tail, null, customer);
        
        } else {
            Node currentNode = head.next;
            Node prevNode = head;

            while (currentNode != null
                    && currentNode.info.getSurname().compareToIgnoreCase(customer.getSurname()) <= 0) {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            currentNode.prev = prevNode.next
                    = new Node(prevNode, currentNode, customer);
        }

    } //insertSorted bitisi

    public boolean displayMatch(String name) {  //searches if there is a match with the data which entered from the keyboard.
        boolean flag = false;
        Node current = head;  //current is defined for searching the list node by node 
        Node match = null;  //holds the node that is matched
        name = name.toLowerCase();
        name = name.trim();  //deletes whitespaces
        System.out.println(name);
        if (isEmpty()) {   //if the list is empty there would be no match
            System.out.println("THE LIST IS EMPTY. NO MATCHES FOUND.");
        }

        while (current != null) {
            String compareName = current.info.getName().toLowerCase();
            compareName = compareName.trim();
            String nameSurname = compareName;
            if (name.equals(nameSurname)) {  //if the input and the name from the list are equal
                flag = true;
                match = current;
                break;
            }          
            current = current.next;
        }
        if (flag == true) {  //if flag is true, the info of customer will be printed.
            System.out.println("MATCH FOUND: " + match.info.toString());   } 
        else {
            System.out.println("NO CUSTOMER FOUND MATCHING THE NAME YOU HAVE ENTERED.");  }
        
        return flag;
    }

    public void deleteMatch(String name) {  //removes the data entered from the keyboard only if it exists.
        boolean flag = false;
        Node current = head;
        Node match = null;

        if (isEmpty()) {
            System.out.println("THE LIST IS EMPTY. CAN'T DELETE THE NAME THAT DOES NOT EXİST.");
        }

        while (current != null) {  //this part is very similar with displayMatch()
            String nameSurname = head.info.getName();
            String nameSurname2 = nameSurname.trim();
            String name2 = name.trim();
            if (nameSurname2.equalsIgnoreCase(name2)) {
                flag = true;
                match = current;
                break;
            }
            current = current.next;
        }

        if (flag) {  //if the input is correct the customer will be deleted
            System.out.println("<" + name + ">" + " IS BEING DELETED FROM THE LIST ...");

            if (head == match) {
                head = match.next;
            }
            if (match.next != null) {
                match.next.prev = match.prev;
            }
            if (match.prev != null) {
                match.prev.next = match.next;
            }

            match = null;
        } else {
            System.out.println("THE NAME YOU HAVE ENTERED İS NOT FOUND.");
        }
    }

    public void displayAllSorted() {  //displays the customers list in alphabetical order.
        Node iterator = head;
        while (iterator != null) {
            System.out.println(iterator.info.toString());
            iterator = iterator.next;
        }
    }

    public void displayAllReverse() {  //displays the customers list in reverse alphabetical order.
        Node iterator = tail;
        while (iterator != null) {  //while head node's prev is not null
            System.out.println(iterator.info.toString());
            iterator = iterator.prev;
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
