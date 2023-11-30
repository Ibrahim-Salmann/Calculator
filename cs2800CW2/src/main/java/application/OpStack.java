package application;

import java.util.EmptyStackException;

public class OpStack {
  private Stack opStack;

  public OpStack() {
    opStack = new Stack();
  }

  public boolean stackisEmpty() {
    return opStack.size() == 0;
  }

  public void push(Symbol symbol) {
    opStack.push(new Entry(symbol));

  }

  public Symbol pop(Symbol symbol) throws BadTypeException {
    if (opStack.size() == 0) {
      throw new EmptyStackException();
    }
    return opStack.pop().getSymbolValue();
  }

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

