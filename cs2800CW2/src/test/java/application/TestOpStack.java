package application;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
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
  // Test 3; Created the pop() method
  public void testPop() {
    opStack.push(Symbol.MINUS);
    opStack.pop(Symbol.MINUS);
    assertEquals(opStack.stackisEmpty(), true,
        "test that entry pushed into the stack has been poped out of the stack.");
  }

  @Test
  // Test 4; Created the top() method
  public void testTop() {
    opStack.push(Symbol.LEFT_BRACKET);
    opStack.push(Symbol.RIGHT_BRACKET);
    assertEquals(opStack.top(), Symbol.RIGHT_BRACKET,
        "Returns the most recent  entry of the stack.");
  }

  @Test
  // Test 5;
  public void testSize() {
    opStack.push(Symbol.DIVIDE);
    opStack.push(Symbol.TIME);
    assertEquals(opStack.size(), 2, "Returns the size 2 after pushing two entries");
  }

  @Test
  // Test 6; Success
  public void testNotEmpty() {
    opStack.push(Symbol.PLUS);
    assertEquals(opStack.stackisEmpty(), false,
        "Tests the stack to see if it is empty. Should now return false.");
  }

  @Test
  // Test 7; Success
  public void pushThenPop() throws BadTypeException {
    opStack.push(Symbol.DIVIDE);
    assertEquals(opStack.pop(Symbol.DIVIDE), Symbol.DIVIDE,
        "Should return the last entry in stack.");
  }

  @Test
  // Test 8; Success
  public void testEmptyStackException() {
    assertThrows(EmptyStackException.class, () -> opStack.pop(null),
        "Popping an empty stack should throw an exception.");
  }



}
