/**
 * 
 */
package application;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class TestNumStack {

  private NumStack numStack;

  @BeforeEach
  void setup() {
    numStack = new NumStack();
  }

  @Test
  // Test 1; Created NumStack class with variable, constructor, and method.
  void testStackisEmpty() {
    assertEquals(numStack.StackisEmpty(), true,
        "tests wheather the initial stack created is empty.");
  }

  @Test
  // Test 2; Created the push method.
  void testPush() {
    numStack.push(10.0f);
    assertEquals(numStack.StackisEmpty(), false,
        "returns false as an entry has been pushed inro the stack.");
  }

  @Test
  //Test 3; Created the pop method.
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> numStack.pop(),
        "it is not possible to pop from an empty stack.");
  }
  
  @Test
  //Test 4; Created the top method
  void testTopOnEmptyStack() {
    assertThrows(EmptyStackException.class, () -> numStack.top(), "it is not possible to get the top value from an empty stack.");
  }
  
  @Test 
  //Test 5; Success 
  void testTopStack() {
    numStack.push(22.2f);
    assertEquals(numStack.top(), 22.2f,  "top should return the last pushed value on the stack.");
  }
}
