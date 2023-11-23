package uk.ac.rhul.cs2800;

import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * @author Momammad Ibrahim Salman (WLIS107) Represents a simple stack data structure This class
 *         provides basic stack operations such as push, pop, top, and size.
 * 
 */
public class Stack {
  private Deque<Entry> stack = new LinkedList<>();

  /**
   * Returns the number of elements in the stack.
   * 
   * @return the size of the stack.
   * 
   */
  public int size() {
    return stack.size();
  }

  /**
   * Pushes an Entry onto the stack.
   * 
   * @param entry The Entry to be added to the top of the stack.
   * 
   */
  public void push(Entry entry) {
    stack.push(entry);
  }

  /**
   * Removes and returns the top Entry from the stack.
   * 
   * @return The top Entry in the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public Entry pop() {
    if (stack.isEmpty()) {
      throw new EmptyStackException();
    }
    return stack.pop();
  }

  /**
   * Returns the top Entry from the stack without removing it.
   * 
   * @return The top Entry in the stack.
   * 
   * @throws EmptyStackException if the stack is empty.
   */
  public Entry top() {
    if (stack.isEmpty()) {
      throw new EmptyStackException();
    }
    return stack.peek();
  }



}
