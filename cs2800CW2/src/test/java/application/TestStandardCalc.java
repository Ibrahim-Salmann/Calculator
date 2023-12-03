package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {

  private StandardCalc stC;
  
  @BeforeEach
  void setup() {
    stC = new StandardCalc();
  }
  
  @Test
  //Test 1;
  void testInvalidException() {
    assertThrows(InvalidExpressionException.class, () -> stC.evaluate(""));
    assertThrows(InvalidExpressionException.class, () -> stC.evaluate("(1 + 1) / 4"));
    assertThrows(InvalidExpressionException.class, () -> stC.evaluate("5 0 /"));
    assertThrows(InvalidExpressionException.class, () -> stC.evaluate("9 *"));
    assertThrows(InvalidExpressionException.class, () -> stC.evaluate("6 6 x"));
    assertThrows(InvalidExpressionException.class, () -> stC.evaluate("3 9 +"));
    assertThrows(InvalidExpressionException.class, () -> stC.evaluate("2 4 -"));
  }
  

}
