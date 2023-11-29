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
  // Test 3; Created the pop method.
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> numStack.pop(),
        "it is not possible to pop from an empty stack.");
  }

  @Test
  // Test 4; Created the top method
  void testTopOnEmptyStack() {
    assertThrows(EmptyStackException.class, () -> numStack.top(),
        "it is not possible to get the top value from an empty stack.");
  }

  @Test
  // Test 5; Success
  void testTopStack() {
    numStack.push(22.2f);
    assertEquals(numStack.top(), 22.2f, "top should return the last pushed value on the stack.");
  }

  @Test
  // Test 6; created the size method
  void testSize() {
    numStack.push(1960.0f);
    numStack.push(1977.0f);
    numStack.push(1985.0f);
    numStack.push(1995.6f);
    assertEquals(numStack.size(), 4, "returns 4 after pushing 4 entries into the stack");
  }

  @Test
  // Test 7; Success
  void testPushThenPop() {
    numStack.push(1960.0f);
    numStack.push(1977.0f);
    numStack.push(1985.0f);
    numStack.push(1995.6f);
    assertEquals(numStack.StackisEmpty(), false, "checks if the stack is empty");
    assertEquals(numStack.pop(), 1995.6f, "returns the recent entry push into the stack");
    assertEquals(numStack.StackisEmpty(), false,
        "it will return false as only one entry has been poped");
    assertEquals(numStack.pop(), 1985.0f, "returns the recent entry push into the stack");
    assertEquals(numStack.StackisEmpty(), false,
        "still returns false as only two entry has been poped");
    assertEquals(numStack.pop(), 1977.0f, "returns the recent entry push into the stack");
    assertEquals(numStack.StackisEmpty(), false, "again false as only three entry has been poped");
    assertEquals(numStack.pop(), 1960.0f, "returns the recent entry push into the stack");
    assertEquals(numStack.StackisEmpty(), true,
        "finally returns true as all entries have been poped");


  }
}
