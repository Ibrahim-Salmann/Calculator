package application;

public class NumStack {
  
  private Stack numStack;
  
  
  public NumStack() {
    numStack = new Stack();
  }
  
  public boolean StackisEmpty() {
    return numStack.size() == 0;
  }

}
