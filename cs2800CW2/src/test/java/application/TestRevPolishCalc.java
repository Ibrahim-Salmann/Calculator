package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {

  private RevPolishCalc RPC;

  @BeforeEach
  void setup() {
    RPC = new RevPolishCalc();
  }

  @Test
  // Test 1; created RevPolishCalc.java file, and wrote the method evaluate; fail; I added the if
  // conditional at the start so that it would expect an InvalidExpressionException.
  void testInvalidException() {
    assertThrows(InvalidExpressionException.class, () -> RPC.evaluate(""));
    assertThrows(InvalidExpressionException.class, () -> RPC.evaluate("(1 + 1) / 4"));
    assertThrows(InvalidExpressionException.class, () -> RPC.evaluate("5 0 /"));
    assertThrows(InvalidExpressionException.class, () -> RPC.evaluate("9 *"));
    assertThrows(InvalidExpressionException.class, () -> RPC.evaluate("6 6 x"));
  }

  @Test
  // Test 2; Success
  void testAddiction() throws BadTypeException, InvalidExpressionException {
    assertEquals(RPC.evaluate("9 9 +"), 18f);
    assertEquals(RPC.evaluate("15 28 +"), 43f);
    assertEquals(RPC.evaluate("12 16 + 5 + 14 + 1"), 47f);
    assertEquals(RPC.evaluate("70 100 + 66 + 10 + 12 + 55 +"), 313f);
  }
  
  @Test
  //Test 3; Success
  void testSubtraction() throws BadTypeException, InvalidExpressionException{
    assertEquals(RPC.evaluate("9 9 -"), 0f);
    assertEquals(RPC.evaluate("28 15 -"), 13f);
    assertEquals(RPC.evaluate("26 12 - 5 - 2 - 1"), 7f);
    assertEquals(RPC.evaluate("200 70 - 22 - 5 - 6 - 45 -"), 52f);
  }
  
  @Test
  //Test 4;
  void testMultiplication()throws BadTypeException, InvalidExpressionException{
    assertEquals(RPC.evaluate("9 9 *"), 81f);
    assertEquals(RPC.evaluate("12 10 *"), 120f);
    assertEquals(RPC.evaluate("3 3 * 3 * 3 *"), 81f);
    assertEquals(RPC.evaluate("3578 6345 *"), 22702410f);
  }

}
