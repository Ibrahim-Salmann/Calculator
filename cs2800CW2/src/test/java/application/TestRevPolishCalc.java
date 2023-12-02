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
  // Test 2;
  void testAddiction() throws BadTypeException, InvalidExpressionException {
    assertEquals(RPC.evaluate("9 9 +"), 18f);
    assertEquals(RPC.evaluate("15 28 +"), 43f);
    assertEquals(RPC.evaluate("12 16 + 5 + 14 + 1"), 47f);
    assertEquals(RPC.evaluate("70 100 + 66 + 10 + 12 + 55 +"), 313f);
  }

}
