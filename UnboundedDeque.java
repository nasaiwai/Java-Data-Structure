/*
 * Assignment 3
 * @author Nasa Iwai
 * @version July 20th
 *
 * This program implements the InstructuresDeque interface using "double-ended queue"
 * abstract data type. Elements can be added to and removed from the
 * head and the tail of the deque. Elements can be any Object.
 *
 */


/* Citation:
 * http://java2novice.com/data-structures-in-java/linked-list/doubly-linked-list/
 * retrieved date: July 22, 2015
 */

import java.util.*;
 
public class UnboundedDeque implements InstructuresDeque {
	private LinkedNode head;
	private LinkedNode tail;
	private int size;
     
	public UnboundedDeque() {
		this.size = 0;
	}
    	
	private class LinkedNode {
		Object item;
		LinkedNode next;
		LinkedNode prev;
 
        	public LinkedNode(LinkedNode prev, Object item, LinkedNode next) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}


	public int size() {
		return size;
	}

     
	public boolean isEmpty() {
		return size == 0;
	}

     
	public void addTop(Object item) {
	        LinkedNode addNode = new LinkedNode(null, item, head);	
		if(head == null || size <= 0) {
			head = addNode;	//there is only 1 element
			tail = addNode;	//head and tail shoule be the same 
		}
		if(head != null ) {
			head.prev = addNode;
			head = addNode;	//move head to a new Node
		}
		size++;
	}

     
	public void addBottom(Object item) {
		LinkedNode addNode = new LinkedNode(tail, item, null);
		if(tail == null || size <=0) {
			tail = addNode;	//there is only 1 element
			head = addNode;	//head and tail should be the same
		}
		if(tail != null) {
			tail.next = addNode;
			tail = addNode;	//move tail to a new Node
		}
		size++;
	}


	public Object removeTop() throws IllegalStateException {
		if (head == null || size <= 0) throw new IllegalStateException();
		else if (head.next == null) {	
			LinkedNode rmvNode = head;
			size--;
			head = null;	//delete head
			return rmvNode.item;
		}
		else {
			LinkedNode rmvNode = head;
			head = head.next;	//move head to the next Node
			head.prev = null;	//delete a top Node
			size--;
			return rmvNode.item;
		}
	}
     
	public Object removeBottom() throws IllegalStateException {
		if (tail == null || size <= 0) throw new IllegalStateException();
		else if (tail.prev == null) {	
			LinkedNode rmvNode = tail;	
			tail = null;	//delete tail
			size--;
			return rmvNode.item;
		}
		else {
			LinkedNode rmvNode = tail;
			tail = tail.prev;	//move tail to the previous Node
			tail.next = null;	//delete a bottom Node
			size--;
			return rmvNode.item;
		}
	}

	public Object top() {
		if(head == null || size <= 0) return null;
		else {
        		LinkedNode top = head;
			return top.item;
		}
	}


	public Object bottom() {
		if(tail == null || size <= 0) return null;
		else {
			LinkedNode bottom = tail;
			return bottom.item;
		}
	}

	public static void main(String[] args) {
	}

}
