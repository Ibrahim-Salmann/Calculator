package application;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 */
public class CalcModel implements Calculator {


  private StandardCalc stc;
  private RevPolishCalc rpc;


  public CalcModel() {
    stc = new StandardCalc();
    rpc = new RevPolishCalc();
  }



  @Override
  public float evaluate(String expression, Boolean infix) throws InvalidExpressionException {
    if (infix) {
      // Evaluate using standard (infix) notation
      return stc.evaluate(expression);
    } else {
      // Evaluate using reverse polish notation
      return rpc.evaluate(expression);
    }
  }
}
