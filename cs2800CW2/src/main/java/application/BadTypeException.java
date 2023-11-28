package application;

/**
 * A custom exception class representing an exceptional situation when an incorrect or unsupported
 * data type is encountered. It extends the RuntimeException class and can be thrown to indicate a
 * bad data type.
 */
public class BadTypeException extends RuntimeException {

  /**
   * Constructs a new BadTypeException with the specified detail message.
   *
   * @param message A descriptive message that provides information about the cause of the
   *        exception.
   */
  public BadTypeException(String message) {
    super(message);
  }

}
