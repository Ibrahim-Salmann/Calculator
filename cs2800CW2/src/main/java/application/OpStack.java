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
}


