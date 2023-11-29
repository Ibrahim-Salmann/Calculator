package application;

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

}
