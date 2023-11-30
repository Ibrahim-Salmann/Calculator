package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {

  private OpStack opStack;

  @BeforeEach
  public void setup() {
    opStack = new OpStack();
  }

  @Test
  // Test 1; Created OpStack class created, added stackisEmpty method.
  public void testStackisEmpty() {
    assertEquals(opStack.stackisEmpty(), true, "Checks if the initial stack created is empty");
  }

  @Test
  // Test 2; Created push() method
  public void testPush() {
    opStack.push(Symbol.PLUS);
    assertEquals(opStack.stackisEmpty(), false, "Checks if the Stack is empty, which its not.");
  }

  @Test
  //Test 3; Created the pop() method
  public void testPop() {
    opStack.push(Symbol.MINUS);
    opStack.pop(Symbol.MINUS);
    assertEquals(opStack.stackisEmpty(), true, "test that entry pushed into the stack has been poped out of the stack.");    
  }
  
  
}
