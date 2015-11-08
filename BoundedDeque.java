/*
 * Program 4
 * @author Nasa Iwai
 * @version July 23rd, 2015
 *
 * This program implements the InstructuresDeque interface using an array.
 * An array has a fixed capacity, and use circular buffer.
 *
 */

import java.util.*;

public class BoundedDeque implements InstructuresDeque {
	private Object[] buff;
	private int capacity, size;
	private int head, tail;

	public BoundedDeque(int capacity) {
		if (capacity <= 0) throw new IllegalArgumentException("capacity must be positive"); 
		else {
			buff = new Object[capacity];
			this.capacity = capacity;	
			this.size = 0;
			this.head = capacity/2; //Start head index in the middle of an array
			this.tail = head;	//Start tail index at the same position as head
		}
	}


	public int size() {
		return size;
	}


	public boolean isEmpty() {
		return size == 0;
	}


	public void addTop(Object element) throws IllegalStateException  {
		if(size == capacity) throw new IllegalStateException();
		else if(size == 0) {
			buff[head] = element;	//there is only one element
			buff[tail] = element;	//head and tail should have the same element
		}
		else if(size > 0) {
			if(head == 0) {
				head = capacity -1;	//Once head hit the first index of an array
				buff[head]= element;	//move to the last index of the array
			}
			else buff[--head] = element;
		}
		size++;
	}


	public void addBottom(Object element) throws IllegalStateException {
		if(size == capacity) throw new IllegalStateException();
		else if (size == 0) {
			buff[head] = element;	//there is only one element
			buff[tail] = element;	//head and tail should have the same element
		}
		else {
			if(tail == capacity-1) {
				tail = 0;		//Once tail hit the last index of an array
				buff[tail] = element;	//move to the first index of the array
			}
			else buff[++tail] = element;
		}
		size++;	
	}


	public Object removeTop() throws IllegalStateException {
		if(size == 0) throw new IllegalStateException();
		else {
			if(head == capacity -1) {
				Object temp = buff[head];
				buff[head] = null;
				size--;
				if(size != 0) head = 0;	//if size = 0, head index stays the same
				return temp;
			}
			else {
				Object temp = buff[head];
				buff[head] = null;
				size--;
				if(size != 0) head++;	//if size = 0, head index stays the same
				return temp;
			}
		}
	}

	
	public Object removeBottom() throws IllegalStateException {
		if(size == 0) throw new IllegalStateException();
		else {
			if(tail == 0) {
				Object temp = buff[tail];
				buff[tail] = null;
				size--;
				if(size != 0) tail = capacity - 1; //if size = 0, tail index stays the same
				return temp;
			}
			else {
				Object temp = buff[tail];
				buff[tail] = null;
				size--;
				if(size !=0) tail--;	//if size = 0, tail index stays the same 
				return temp;
			}
		}
	}

	
	public Object top() {
		if(size > 0) return buff[head];
		else return null;
	}


	public Object bottom() {
		if(size > 0) return buff[tail];
		else return null;
	}


	public static void main(String[] args) {
	}
	
}

