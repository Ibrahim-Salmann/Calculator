package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {

  private CalcModel cm;


  @BeforeEach
  void setup() {
    cm = new CalcModel();
  }


  @Test
  // Test 1; fail;
  void testEvaluateStandard() throws InvalidExpressionException {
    float answere = cm.evaluate("7 + 7", true);
    assertEquals(14f, answere, 0.001f);

    answere = cm.evaluate("6.8 * 1.2", true);
    assertEquals(8.16f, answere, 0.001f);

    answere = cm.evaluate("( 4 + 3 ) * ( 5 - 2 )", true);
    assertEquals(21f, answere, 0.001f);
    
    answere = cm.evaluate("( 12 * 2 ) - ( 144 / 12 )", true);
    assertEquals(12f, answere, 0.001f);
    
    answere = cm.evaluate(" ( 3 * 5 ) - 2", true);
    assertEquals(13f, answere, 0.001f);
  }

}
