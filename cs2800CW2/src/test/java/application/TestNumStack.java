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
  void StackisEmpty() {
    assertEquals(numStack.StackisEmpty(), true, "tests wheather the initial stack created is empty.");
  }
}
