package application;

/**
 * Represents enumeration of mathematical symbols. Each symbol is associated with a string
 * representation.
 */
public enum Symbol {
  PLUS("+"), // Addition Symbol
  MINUS("-"), // Subtraction Symbol
  TIME("*"), // Multiplication Symbol
  DIVIDE("/"), // Division Symbol
  LEFT_BRACKET("("), // Left Bracket Symbol
  RIGHT_BRACKET(")"), // Right Bracket Symbol
  INVALID("Invalid");// Invalid Type

  private String symbolName;
  private int precedence;

  /**
   * Constructs a Symbol with its associated string representation.
   * 
   * @param symbolName The string representation of the symbol.
   */
  Symbol(String symbolName) {
    this.symbolName = symbolName;
  }

  Symbol(String symbolName, int precedence) {
    this.symbolName = symbolName;
    this.precedence = precedence;
  }

  public int getPrecedence() {
    return this.precedence;
  }



  /**
   * @return The string representation of the symbol
   */
  public String toString() {
    return symbolName;
  }
}
