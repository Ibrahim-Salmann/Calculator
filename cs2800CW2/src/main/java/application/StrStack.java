package application;

import java.util.EmptyStackException;

/**
 * The StrStack class represents a stack of strings and provides basic stack operations.
 * 
 * @author Ibraheem
 */
public class StrStack {
  private Stack strStack;

  /**
   * Constructs an empty StrStack.
   */
  public StrStack() {
    strStack = new Stack();
  }

  /**
   * Checks if the stack is empty.
   * 
   * @return true if the stack is empty, false otherwise.
   */
  public boolean isEmpty() {
    return strStack.size() == 0;
  }

  /**
   * Pushes a string onto the stack.
   * 
   * @param string The string to be pushed onto the stack.
   */
  public void push(String string) {
    strStack.push(new Entry(string));

  }

  /**
   * Pops the top string from the stack.
   * 
   * @return The popped string.
   * @throws EmptyStackException if the stack is empty.
   * @throws BadTypeException if the type of the top element is not a string.
   */
  public String pop(String string) throws BadTypeException {
    if (strStack.size() == 0) {
      throw new EmptyStackException();
    }
    return strStack.pop().getStringValue();
  }

  /**
   * Retrieves the top string from the stack without removing it.
   * 
   * @return The top string.
   * @throws EmptyStackException if the stack is empty.
   * @throws BadTypeException if the type of the top element is not a string.
   */
  public String top() throws BadTypeException {
    if (strStack.size() == 0) {
      throw new EmptyStackException();
    }
    return strStack.top().getStringValue();
  }

  /**
   * Returns the size of the stack.
   * 
   * @return The size of the stack.
   */
  public Integer size() {
    return strStack.size();
  }

}


