package uk.ac.rhul.cs2800;

import java.util.Objects;


/**
 * Represents an entry in a stack, which can have different types of values (float, string, symbol).
 * 
 * 
 * @author Momammad Ibrahim Salman (WLIS107)
 *
 */
public class Entry {

  private Type type; // The type of value is stored in this entry.
  private Object value; // The actual value is stored in this entry.

  /**
   * Creates new entry with float value.
   * 
   * @param floatValue The float value to be stored in this entry.
   * 
   */
  public Entry(float floatValue) {
    this.type = Type.FLOAT;
    this.value = floatValue;
  }

  /**
   * Creates new entry with float value.
   * 
   * @param stringValue The string value to be stored in this entry.
   * 
   */
  public Entry(String stringValue) {
    this.type = Type.STRING;
    this.value = stringValue;
  }

  /**
   * Creates new entry with symbol value.
   * 
   * @param symbolValue The symbol value to be stored in this entry
   * 
   */
  public Entry(Symbol symbolValue) {
    this.type = Type.SYMBOL;
    this.value = symbolValue;
  }

  /**
   * Gets the type of value stored in this entry.
   * 
   * @return The type of the value (Type.FLOAT, Type.STRING, or Type.SYMBOL).
   * 
   */
  public Type getType() {
    return type;
  }

  /**
   * Gets the float value stored in this entry.
   * 
   * @return The float value if the type is Type.FLOAT.
   * 
   * @throws BadTypeException if the type is not Type.FLOAT.
   */
  public Float getFloatValue() {
    if (type == Type.FLOAT) {
      return (float) value;
    } else {
      throw new BadTypeException("Not a float value");
    }
  }

  /**
   * Gets the string value stored in this entry.
   * 
   * @return The string value if the type is Type.STRING.
   * 
   * @throws BadTypeException if the type is not Type.STRING.
   */
  public String getStringValue() {
    if (type == Type.STRING) {
      return (String) value;
    } else {
      throw new BadTypeException("Not a string value");
    }
  }

  /**
   * Gets the symbol stored in this entry.
   * 
   * @return The symbol value if the type is Type.SYMBOL.
   * 
   * @throws BadTypeException if the type is not Type.SYMBOL.
   */
  public Symbol getSymbolValue() {
    if (type == Type.SYMBOL) {
      return (Symbol) value;
    } else {
      throw new BadTypeException("Not a symbol value");
    }
  }

  /**
   * Compares this Entry to another object for equality. Entries are equal if they have the same
   * type and value.
   * 
   * @param oj The Object to compare to.
   * 
   * @return True if the objects are equal, false otherwise.
   * 
   */
  @Override
  public boolean equals(Object oj) {
    if (this == oj) {
      return true;
    } else if (oj == null || getClass() != oj.getClass()) {
      return false;
    }
    Entry entry = (Entry) oj;
    return type == entry.type && value.equals(entry.value);
  }

  /**
   * Indicates that this method is intended to override a method from a superclass or interface.
   */
  @Override
  public int hashCode() {
    return Objects.hash(type, value);
  }


  /**
   * Represents an entry with a specified data type and value.
   * This constructor creates an Entry object with the given type and value.
   * 
   * @param getType The data type of the entry, which should be one of the Type enum values (Type.FLOAT, Type.STRING, or Type.SYMBOL).
   * @param getValue The value associated with the entry. The data type of this value should match the specified type.
   * 
   */
  public Entry(Type getType, Object getValue) {
    if (getType == Type.FLOAT) {
      this.type = Type.FLOAT;
      this.value = getValue;
    } else if (getType == Type.STRING) {
      this.type = Type.STRING;
      this.value = getValue;
    } else if (getType == Type.SYMBOL) {
      this.type = Type.SYMBOL;
      this.value = getValue;
    }
  }


}
