package application;


/**
 * 
 * Represents an enumeration of data types. Each data type is associated with a string representation
 * 
 */
public enum Type {
  FLOAT("Float"), // Float data type
  STRING("String"), // String data type
  SYMBOL("Symbol"),// Symbol data type
  INVALID("Invalid");//Invalid Type

  private String typeName;

  /**
   * Constructs a Type with its associated string representation.
   * 
   * @param typeName The string representation of the data type.
   */
  Type(String typeName) {
    this.typeName = typeName;
  }

  /**
   * @return The string representation of the data type.
   */
  public String toString() {
    return typeName;
  }
}
