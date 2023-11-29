package application;

import java.util.EmptyStackException;

/**
 * @author Ibraheem
 */
public class NumStack {

  private Stack numStack;


  public NumStack() {
    numStack = new Stack();
  }

  public boolean StackisEmpty() {
    return numStack.size() == 0;
  }

  public void push(float entry) {
    numStack.push(new Entry(entry));

  }

  /**
   * @return float value pushed
   * @throws BadTypeException
   */
  public float pop() throws BadTypeException {
    if (numStack.size() == 0) {
      throw new EmptyStackException();
    }
    return numStack.pop().getFloatValue();
  }

}
