package application;

public class OpStack {
  private Stack opStack;
  
  public OpStack() {
    opStack = new Stack(); 
  }
  
  public boolean stackisEmpty() {
    return opStack.size()==0;
  }
}
