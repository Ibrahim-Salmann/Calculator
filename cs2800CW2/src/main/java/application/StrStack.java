package application;

import java.util.EmptyStackException;

public class StrStack {
  private Stack strStack;

  public StrStack() {
    strStack = new Stack();
  }

  public boolean isEmpty() {
    return strStack.size() == 0;
  }

  public void push(String string) {
    strStack.push(new Entry(string));

  }

  public String pop(String string) throws BadTypeException {
    if (strStack.size() == 0) {
      throw new EmptyStackException();
    }
    return strStack.pop().getStringValue();
  }

  public String top() throws BadTypeException {
    if (strStack.size() == 0) {
      throw new EmptyStackException();
    }
    return strStack.top().getStringValue();
  }

}


