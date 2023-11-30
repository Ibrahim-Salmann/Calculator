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

}
