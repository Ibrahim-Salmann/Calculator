package uk.ac.rhul.cs2800;

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
  INVALID("Invalid");//Invalid Type

  private String symbolName;

  /**
   * Constructs a Symbol with its associated string representation.
   * 
   * @param symbolName The string representation of the symbol.
   */
  Symbol(String symbolName) {
    this.symbolName = symbolName;
  }

  /**
   * @return The string representation of the symbol
   */
  public String toString() {
    return symbolName;
  }
}
