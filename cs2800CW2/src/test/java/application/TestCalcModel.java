package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {

  private CalcModel cmStandard;
  private CalcModel cmReversePolish;


  @BeforeEach
  void setup() {
    // Use StandardCalcFactory for infix notation
    cmStandard = new CalcModel(new StandardCalcFactory());
    // Use RevPolishCalcFactory for reverse polish notation
    cmReversePolish = new CalcModel(new RevPolishCalcFactory());
  }


  @Test
  // Test 1; fail; Completed the CalcModel.java code
  void testEvaluateStandard() throws InvalidExpressionException {

    cmStandard.setInfixCalculation(true); // Set infix calculation explicitly

    float answere = cmStandard.evaluate("7 + 7", Boolean.TRUE);
    assertEquals(14f, answere, 0.001f);

    answere = cmStandard.evaluate("6.8 * 1.2", Boolean.TRUE);
    assertEquals(8.16f, answere, 0.001f);

    answere = cmStandard.evaluate("( 4 + 3 ) * ( 5 - 2 )", Boolean.TRUE);
    assertEquals(21f, answere, 0.001f);

    answere = cmStandard.evaluate("( 12 * 2 ) - ( 144 / 12 )", Boolean.TRUE);
    assertEquals(12f, answere, 0.001f);

    answere = cmStandard.evaluate(" ( 3 * 5 ) - 2", Boolean.TRUE);
    assertEquals(13f, answere, 0.001f);
  }

  @Test
  // Test 2;
  void testEvaluateReversePolish() throws InvalidExpressionException {

    cmReversePolish.setInfixCalculation(false); // Set reverse polish calculation explicitly

    float answere = cmReversePolish.evaluate("7 7 +", Boolean.FALSE);
    assertEquals(14f, answere, 0.001f);

    answere = cmReversePolish.evaluate("6.8 1.2 *", Boolean.FALSE);
    assertEquals(8.16f, answere, 0.001f);

    answere = cmReversePolish.evaluate("4 3 + 5 2 - *", Boolean.FALSE);
    assertEquals(21f, answere, 0.001f);

    answere = cmReversePolish.evaluate("12 2 * 144 12 / -", Boolean.FALSE);
    assertEquals(12f, answere, 0.001f);

    answere = cmReversePolish.evaluate("3 5 * 2 -", Boolean.FALSE);
    assertEquals(13f, answere, 0.001f);
  }


  @Test
  void testMismatchedExpressionFormat() {
    assertThrows(InvalidExpressionException.class,
        () -> cmStandard.evaluate("2 3 + 4 *", Boolean.TRUE));
    assertThrows(InvalidExpressionException.class,
        () -> cmReversePolish.evaluate("(2 + 3) * 4", Boolean.FALSE));
  }

}
