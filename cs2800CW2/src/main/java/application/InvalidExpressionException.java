package application;

/**
 * An expression was passed to a method that could not be evaluated.
 */

public class InvalidExpressionException extends Exception {



  /**
   * Constructs a new InvalidExpression with the specified detail message.
   *
   * @param message A descriptive message that provides information about the cause of the
   *        exception.
   */
  public InvalidExpressionException(String message) {
    super(message);
  }

}
