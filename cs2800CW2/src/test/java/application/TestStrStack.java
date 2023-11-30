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
  //Test 1;
  public void testIsEmpty() {
    assertEquals(strStack.isEmpty(), true, "Checks if the initial stack created is empty");
  }

}
