Program: UnboundedDeque

This program implements the InstructuresDeque interface:

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

This program implements using using a linked list of nodes.


    Your deque implementation must throw an IllegalStateException whenever removeTop or removeBottom are called on an empty deque.
    This is a pure data-structure implementation: You methods must not output to System.out (nor System.err). The only user-interaction code you may write will be for testing your program, which you will write for your own use and not turn in.
    Implement your UnboundedDeque using a doubly-linked list. Instead of having to check for null, represent the head and tail pointers as a single sentinel node.


