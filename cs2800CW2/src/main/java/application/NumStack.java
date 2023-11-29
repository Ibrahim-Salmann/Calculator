package application;

import java.util.EmptyStackException;

/**
 * NumStack represents a stack of numerical entries, providing basic stack operations.
 * This class encapsulates a stack implementation using the Stack class, which is assumed to be
 * defined elsewhere. Numerical entries are represented as instances of the Entry class.
 *
 * @author Ibraheem
 */
public class NumStack {

  // Private member variable to store the stack
  private Stack numStack;


  /**
   * Constructs a new NumStack with an empty stack.
   */
  public NumStack() {
    numStack = new Stack();
  }

  /**
   * Checks if the stack is empty.
   *
   * @return true if the stack is empty, false otherwise.
   */
  public boolean stackisEmpty() {
    return numStack.size() == 0;
  }

  /**
   * Pushes a numerical entry onto the stack.
   *
   * @param entry The numerical value to be pushed onto the stack.
   */
  public void push(float entry) {
    numStack.push(new Entry(entry));

  }

  /**
   * * Pops the top numerical entry from the stack.
   *
   * @return The float value of the popped entry.
   * @throws BadTypeException if the stack is empty.
   */
  public float pop() throws BadTypeException {
    if (numStack.size() == 0) {
      throw new EmptyStackException();
    }
    return numStack.pop().getFloatValue();
  }

  /**
   * Retrieves the float value of the top entry without removing it from the stack.
   *
   * @return The float value of the top entry.
   * @throws BadTypeException if the stack is empty.
   */
  public float top() throws BadTypeException {
    if (numStack.size() == 0) {
      throw new EmptyStackException();
    }
    return numStack.top().getFloatValue();
  }

  /**
   * Gets the current size of the stack.
   *
   * @return The number of entries in the stack.
   */
  public int size() {
    return numStack.size();
  }

}
