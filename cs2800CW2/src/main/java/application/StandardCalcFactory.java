package application;

/**
 * A factory class for creating instances of the StandardCalc class. Implements the
 * CalculatorFactory interface to provide a method for creating StandardCalc instances.
 * 
 * @author Ibraheem
 */
public class StandardCalcFactory implements CalculatorFactory {
  /**
   * Creates a new instance of the StandardCalc class.
   *
   * @return A new instance of StandardCalc.
   */
  @Override
  public Calculator createCalculator() {
    return (Calculator) new StandardCalc();
  }
}
