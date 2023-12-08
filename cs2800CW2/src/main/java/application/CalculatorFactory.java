package application;

/**
 * The interface representing a factory for creating instances of the Calculator. Implementing
 * classes should provide a way to create different types of calculators
 * 
 * @author Ibraheem
 */
public interface CalculatorFactory {
  /**
   * Creates a new instance of the Calculator.
   *
   * @return A new instance of the Calculator.
   */
  Calculator createCalculator();
}
