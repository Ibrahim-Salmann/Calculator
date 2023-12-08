package application;

/**
 * A factory class for creating instances of the RevPolishCalc class. Implements the
 * CalculatorFactory interface to provide a method for creating RevPolishCalc instances.
 * 
 * @author Ibraheem
 */
public class RevPolishCalcFactory implements CalculatorFactory {
  /**
   * Creates a new instance of the RevPolishCalc class.
   *
   * @return A new instance of RevPolishCalc.
   */
  @Override
  public Calculator createCalculator() {
    return (Calculator) new RevPolishCalc();
  }
}
