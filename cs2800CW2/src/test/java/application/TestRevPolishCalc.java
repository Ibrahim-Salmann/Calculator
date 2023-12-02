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
  // Test 3; Success
  void testSubtraction() throws BadTypeException, InvalidExpressionException {
    assertEquals(RPC.evaluate("9 9 -"), 0f);
    assertEquals(RPC.evaluate("28 15 -"), 13f);
    assertEquals(RPC.evaluate("26 12 - 5 - 2 - 1"), 7f);
    assertEquals(RPC.evaluate("200 70 - 22 - 5 - 6 - 45 -"), 52f);
  }

  @Test
  // Test 4; Success
  void testMultiplication() throws BadTypeException, InvalidExpressionException {
    assertEquals(RPC.evaluate("9 9 *"), 81f);
    assertEquals(RPC.evaluate("12 10 *"), 120f);
    assertEquals(RPC.evaluate("3 3 * 3 * 3 *"), 81f);
    assertEquals(RPC.evaluate("3578 6345 *"), 22702410f);
  }

  @Test
  // Test 5; Success
  void testDivision() throws BadTypeException, InvalidExpressionException {
    assertEquals(RPC.evaluate("9 9 /"), 1f);
    assertEquals(RPC.evaluate("160 2 /"), 80f);
    assertEquals(RPC.evaluate("300 3 / 5 / 2 /"), 10f);
    assertEquals(RPC.evaluate("1200000 120 /"), 10000f);
  }

  @Test
  // Test 6; Success
  void testDecimal() throws BadTypeException, InvalidExpressionException {
    assertEquals(RPC.evaluate("12.5 13.6 +"), 26.1f);
    assertEquals(RPC.evaluate("66.66 3.45 -"), 63.210003f);
    assertEquals(RPC.evaluate("37.8 4.2 /"), 9f);
    assertEquals(RPC.evaluate("5.5 2.0 *"), 11f);
  }

  @Test
  // Test 7; Success
  void testNegative() throws BadTypeException, InvalidExpressionException {
    assertEquals(RPC.evaluate("-12 89 +"), 77f);
    assertEquals(RPC.evaluate("-66 -345 +"), -411f);
    assertEquals(RPC.evaluate("-2 -2 *"), 4f);
    assertEquals(RPC.evaluate("-9999 3 /"), -3333.0f);
  }

  @Test
  // Test 8; Success
  void testComplex() throws BadTypeException, InvalidExpressionException {
    assertEquals(RPC.evaluate("9 7 + 13 * 7 1 - /"), 34.666668f);
    assertEquals(RPC.evaluate("13.9 77.5 - 70 7 / *"), -636.0f);
    assertEquals(RPC.evaluate("1 6 * 9 / 12 16 * *"), 128.0f);

  }



}
