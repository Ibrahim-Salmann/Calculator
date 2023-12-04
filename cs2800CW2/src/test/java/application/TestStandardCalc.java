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
  // Test 1; Created the StandardCalc class with evaluate method
  void testInvalidException() {
    assertThrows(InvalidExpressionException.class, () -> stc.evaluate(""));
    assertThrows(InvalidExpressionException.class, () -> stc.evaluate("(1 + 1) / 4"));
    assertThrows(InvalidExpressionException.class, () -> stc.evaluate("5 0 /"));
    assertThrows(InvalidExpressionException.class, () -> stc.evaluate("9 *"));
    assertThrows(InvalidExpressionException.class, () -> stc.evaluate("6 6 x"));
  }

  @Test
  // Test 2; error; removed a space in String postfix 
  void testAddition() throws BadTypeException, InvalidExpressionException {
    assertEquals(stc.evaluate("2 + 2"), 4f, 0.001f);
    assertEquals(stc.evaluate("15 + 15"), 30f, 0.001f);
    assertEquals(stc.evaluate("2 + 2 + 2 + 2 + 2"), 10f, 0.001f);
  }

  @Test
  // Test 3; Success
  void testSubraction() throws BadTypeException, InvalidExpressionException {
    assertEquals(stc.evaluate("2 - 2"), 0f);
    assertEquals(stc.evaluate("100 - 40"), 60f);
    assertEquals(stc.evaluate("42 - 49"), -7f);
  }

  @Test
  // Test 4; Success
  void testMultiplication() throws BadTypeException, InvalidExpressionException {
    assertEquals(stc.evaluate("12 * 2"), 24f);
    assertEquals(stc.evaluate("-8 * -8"), 64f);
    assertEquals(stc.evaluate("2 * 2 * 2 * 2"), 16f);
  }

  @Test
  // Test 5; Success
  void testDivision() throws BadTypeException, InvalidExpressionException {
    assertEquals(stc.evaluate("2 / 2"), 1f);
    assertEquals(stc.evaluate("100 / 20"), 5f);
    assertEquals(stc.evaluate("49 / 7"), 7f);
  }

  @Test
  // Test 6; Success
  void testDecimal() throws BadTypeException, InvalidExpressionException {
    assertEquals(stc.evaluate("1.3 + 1.7"), 3f);
    assertEquals(stc.evaluate("8.9 * 6.9"), 61.41f);
  }

  @Test
  // Test 7; fail&errors; changed the entire algorithm 
  void testComplex() throws BadTypeException, InvalidExpressionException {
    assertEquals(stc.evaluate("3 + ( 4 * 5 ) / 2"), 11.5f);
    assertEquals(stc.evaluate("( 30 - 70 ) * ( 20 * 20 )"), -16000.0f);
    assertEquals(stc.evaluate("( 4 + 7 ) * ( 4 + 3 )"), 77f);
    assertEquals(stc.evaluate("8 - ( 144 / 12 ) * ( 80 / 8 )"), -40.0f);
  }



}
