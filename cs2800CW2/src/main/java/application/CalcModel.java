package application;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 * 
 * <p>
 * The CalcModel class provides a versatile expression evaluation capability, supporting both
 * Standard (infix) and Reverse Polish notations.
 * </p>
 * 
 * <p>
 * This class implements the Calculator interface and encapsulates instances of StandardCalc and
 * RevPolishCalc to enable evaluation of mathematical expressions based on the user's chosen
 * notation.
 * </p>
 * 
 * <p>
 * Usage example:
 * </p>
 * 
 * <pre>
 * CalcModel calcModel = new CalcModel();
 * float result = calcModel.evaluate("(2 + 3) * 4", true); // Standard notation
 * float resultRPN = calcModel.evaluate("2 3 + 4 *", false); // Reverse Polish notation
 * </pre>
 * 
 * 
 * @author Ibraheem
 */
public class CalcModel implements Calculator {



  private boolean infixCalculation;



  private CalculatorFactory calculatorFactory;


  /**
   * Constructs a new CalcModel instance with a specified CalculatorFactory.
   *
   * @param calculatorFactory The factory to create instances of the Calculator.
   */
  public CalcModel(CalculatorFactory calculatorFactory) {
    this.calculatorFactory = calculatorFactory;
  }


  /**
   * Set the calculation type (infix or reverse polish).
   * 
   * @param infix Determines whether the expression should be evaluated in Standard (infix)
   *        notation.
   */
  public void setInfixCalculation(boolean infix) {
    infixCalculation = infix;
  }



  /**
   * Evaluates a mathematical expression based on the specified notation.
   * 
   * @param expression The mathematical expression to be evaluated.
   * @param infix Determines whether the expression is in Standard (infix) notation.
   * @return The result of the evaluation.
   * @throws InvalidExpressionException If the expression is invalid or cannot be evaluated.
   */
  @Override
  public float evaluate(String expression, Boolean infix) throws InvalidExpressionException {
    // Validate infix parameter consistency with the actual calculation type
    if (infix != infixCalculation) {
      throw new InvalidExpressionException(
          "Mismatch between expression format and calculation type");
    }
    // Use the factory to create a calculator
    Calculator calculator = calculatorFactory.createCalculator();
    return calculator.evaluate(expression, infix);
  }
}
