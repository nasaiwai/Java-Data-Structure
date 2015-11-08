Program: BoundedDeque

This program implements a variant of the deque structure by giving it a fixed capacity, or bound.

Write a class in Java, named BoundedDeque, that implements the InstructuresDeque interface: 

public interface InstructuresDeque {
  int size();
  boolean isEmpty();
  void addTop(Object element);
  void addBottom(Object element);
  Object removeTop();
  Object removeBottom();
  Object top();
  Object bottom();
}

BoundedDeque will be implemented using an array, and will have a fixed capacity.


 A fixed-capacity deque is the basis for writing structures related to fixed resources. There are three different policies for what to do when the capacity is exceeded:

    Throw an exception to indicate the structure is full.
    Overwrite the oldest values.
    Make the caller wait until another caller (in a different thread of execution) removes an element from the deque. We have seen such "blocking" before with the BlockingDeque.

