package com.data;


public class Node {
	
    private Node next;
    private Person person;
    private Address address;

    public Node(Person person) {
        this.person = person;
        this.next = null;
    }
    public Node(Address address) {
        this.address = address;
        this.next = null;
    }

	public Person getPerson() {
        return person;
    }
	public Address getAddress() {
        return address;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    public void setItem(Person item){
    	this.person = item;
    }

}
