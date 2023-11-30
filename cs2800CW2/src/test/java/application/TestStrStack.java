package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {

  private StrStack strStack;

  @BeforeEach
  public void setup() {
    strStack = new StrStack();
  }

  @Test
  // Test 1; Created the StrStack file, that
  public void testIsEmpty() {
    assertEquals(strStack.isEmpty(), true, "Checks if the initial stack created is empty");
  }

  @Test
  // Test 2; Created push() method
  public void testPush() {
    strStack.push("equlas");
    assertEquals(strStack.isEmpty(), false, "Checks if the Stack is empty, which its not.");
  }

  @Test
  // Test 3; Created the pop() method
  public void testPop() {
    strStack.push("addition");
    strStack.pop("addiction");
    assertEquals(strStack.isEmpty(), true,
        "test that entry pushed into the stack has been poped out of the stack.");
  }

  @Test
  // Test 4; Created the top() method
  public void testTop() {
    strStack.push("multiplication");
    strStack.push("division");
    assertEquals(strStack.top(), "division", "Returns the most recent  entry of the stack.");
  }

}
