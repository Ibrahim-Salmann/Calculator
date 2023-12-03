package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {

  private StandardCalc stc;
  
  @BeforeEach
  void setup() {
    stc = new StandardCalc();
  }
  
  @Test
  //Test 1; Created the StandardCalc class with evaluate method
  void testInvalidException() {
    assertThrows(InvalidExpressionException.class, () -> stc.evaluate(""));
    assertThrows(InvalidExpressionException.class, () -> stc.evaluate("(1 + 1) / 4"));
    assertThrows(InvalidExpressionException.class, () -> stc.evaluate("5 0 /"));
    assertThrows(InvalidExpressionException.class, () -> stc.evaluate("9 *"));
    assertThrows(InvalidExpressionException.class, () -> stc.evaluate("6 6 x"));
  }
  
  @Test
  //Test 2; error; removed a space in String postfix line 43 in StandardCalc.java
  void testAddition() throws BadTypeException, InvalidExpressionException {
    assertEquals(stc.evaluate("2 + 2"), 4f);
    assertEquals(stc.evaluate("15 + 15"), 30f);
    assertEquals(stc.evaluate("2 + 2 + 2 + 2 + 2"), 10f);
  }
  
  @Test
  //Test 3; Success
  void testSubraction() throws BadTypeException, InvalidExpressionException {
    assertEquals(stc.evaluate("2 - 2"), 0f);
    assertEquals(stc.evaluate("100 - 40"), 60f);
    assertEquals(stc.evaluate("42 - 49"), -7f);
  }
  
  
  

}
