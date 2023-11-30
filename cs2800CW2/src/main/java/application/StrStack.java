package application;

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



}
