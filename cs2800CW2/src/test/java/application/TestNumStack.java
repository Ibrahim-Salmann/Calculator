/**
 * 
 */
package application;

import static org.junit.jupiter.api.Assertions.*;
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
  //Test 1; Created NumStack class with variable, constructor, and method. 
  void testStackisEmpty() {
    assertEquals(numStack.StackisEmpty(), true, "tests wheather the initial stack created is empty.");
  }
  
  @Test
  //Test 2
  void testPush() {
    numStack.push(10.0f);
    assertEquals(numStack.StackisEmpty(),false, "returns false as an entry has been pushed inro the stack.");
  }
}
