package application;

import java.util.EmptyStackException;

/**
 * Represents a stack for storing symbols and performing operations on them. This class utilizes a
 * Stack data structure to manage symbols.
 *
 * @author Ibraheem
 */
public class OpStack {
  /**
   * The underlying stack to store symbols.
   */
  private Stack opStack;

  /**
   * Constructs an empty OpStack.
   */
  public OpStack() {
    opStack = new Stack();
  }

  /**
   * Checks if the OpStack is empty.
   *
   * @return true if the OpStack is empty, false otherwise.
   * 
   */
  public boolean stackisEmpty() {
    return opStack.size() == 0;
  }

  /**
   * Pushes a symbol onto the top of the OpStack.
   *
   * @param symbol The symbol to be pushed onto the stack.
   */
  public void push(Symbol symbol) {
    opStack.push(new Entry(symbol));

  }

  /**
   * Pops the top symbol from the OpStack.
   *
   * @return The symbol popped from the stack.
   * @throws BadTypeException If the popped element is not of the expected type.
   * @throws EmptyStackException If the stack is empty.
   */
  public Symbol pop(Symbol symbol) throws BadTypeException {
    if (opStack.size() == 0) {
      throw new EmptyStackException();
    }
    return opStack.pop().getSymbolValue();
  }

  /**
   * Retrieves the top symbol from the OpStack without removing it.
   *
   * @return The top symbol on the stack.
   * @throws BadTypeException If the retrieved element is not of the expected type.
   * @throws EmptyStackException If the stack is empty.
   */
  public Symbol top() throws BadTypeException {
    if (opStack.size() == 0) {
      throw new EmptyStackException();
    }
    return opStack.top().getSymbolValue();
  }

  public Integer size() {
    return opStack.size();
  }


}

