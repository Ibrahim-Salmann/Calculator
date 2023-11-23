package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestEntry {

  private Entry entry;

  @Test
  // Test 9;
  void testEntryWithFloat() {
    Entry entry = new Entry(5.0f);
    assertEquals(Type.FLOAT, entry.getType(),
        "Checking that the Entry has the correct type (Type.FLOAT).");
    assertEquals(5.0f, entry.getFloatValue(),
        "Checking that the Entry contains the expected float value.");
  }

  @Test
  // Test 10; getters and setters for String as well as Symbol for use later on;
  void testEntryWithString() {
    Entry entry = new Entry("Hello");
    assertEquals(Type.STRING, entry.getType(),
        "Checking that the Entry has the correct type (Type.STRING).");
    assertEquals("Hello", entry.getStringValue(),
        "Checking that the Entry contains the expected string value.");
  }

  @Test
  // Test 11; enum for 'Symbol' created
  void testEntryWithSymbol() {
    Entry entry = new Entry(Symbol.PLUS);
    assertEquals(Type.SYMBOL, entry.getType(),
        "Checking that the Entry has the correct type (Type.SYMBOL).");
    assertEquals(Symbol.PLUS, entry.getSymbolValue(),
        "Checking that the Entry contains the expected Symbol value.");
  }

  @Test
  // Test 12; Fail=> Boolean method for Entry class created
  void testEntryEqualityFloat() {
    Entry entry1 = new Entry(5.0f);
    Entry entry2 = new Entry(5.0f);
    assertEquals(entry1, entry2, "Checking that two Entries Flots are considered equal.");
  }

  @Test
  void testEntryEqualityString() {
    Entry entry1 = new Entry("Hello");
    Entry entry2 = new Entry("Hello");
    assertEquals(entry1, entry2, "Checking that two Entries Strings are considered equal.");
  }

  /**
   * 
   */
  @Test
  void testEntryEqualitySymbol() {
    Entry entry1 = new Entry(Symbol.PLUS);
    Entry entry2 = new Entry(Symbol.PLUS);
    assertEquals(entry1, entry2, "Checking that two Entries Symbols are considered Equal.");
  }

  @Test
  // Test 13; works
  void testEntryHashCodeFloat() {
    Entry entry = new Entry(5.0f);
    assertEquals(entry.hashCode(), entry.hashCode(),
        "Checking that hashCode() returns the same value for the same Entry object for a float.");
  }

  /**
   * 
   */
  @Test
  void testEntryHashCodeString() {
    Entry entry = new Entry("Hello");
    assertEquals(entry.hashCode(), entry.hashCode(),
        "Checking that the hashCode() method returns the same value for a string.");
  }

  @Test
  void testEntryHashCodeSymbol() {
    Entry entry = new Entry(Symbol.PLUS);
    assertEquals(entry.hashCode(), entry.hashCode(),
        "Checking that the hashCode() method returns the same value for a symbol.");
  }

  @Test
  // Test 14; works
  // Test 33; Removed NullPointerException foe 100% coverage
  void testEntryHashCode() {
    Entry entry = new Entry(5.0f); // Create a valid Entry
    assertNotNull(entry.hashCode(),
        "Checking that the hashCode() method does not throw a NullPointerException.");
  }

  // Test 15; Works after writing hashCode() method in Entry Class

  @Test
  // Test 34; getting 100% coverage
  void testGetFloatValueForFloat() {
    Entry entry = new Entry(5.0f);
    assertEquals(5.0f, entry.getFloatValue(), "Checking the float value for a FLOAT type entry.");
  }

  @Test
  // Test 16; added constructor to class 'Entry' that throws IllegalArgumentException
  // Test 28; Changed from IllegalArgumentException to BadTypeException.
  void testGetFloatValueForNonFloat() {
    Entry entry = new Entry("Hello");
    assertThrows(BadTypeException.class, () -> entry.getFloatValue(),
        "Checking that getting a float value for a non-FLOAT type entry throws a BadTypeException.");
  }

  @Test
  // Test 35; 100% coverage
  void testGetStringValueForString() {
    Entry entry = new Entry("Hello");
    assertEquals("Hello", entry.getStringValue(),
        "Checking the string value for a STRING type entry.");
  }

  @Test
  // Test 19
  // Test 29;same as test 28
  void testGetStringValueForNonString() {
    Entry entry = new Entry(5.0f);
    assertThrows(BadTypeException.class, () -> entry.getStringValue(),
        "Checking that getting a string value for a non-STRING type entry throws a BadTypeException.");
  }

  @Test
  // test 36; 100% coverage
  void testGetSymbolValueForSymbol() {
    Entry entry = new Entry(Symbol.PLUS);
    assertEquals(Symbol.PLUS, entry.getSymbolValue(),
        "Checking the symbol value for a SYMBOL type entry.");
  }

  @Test
  // Test 21
  // Test 30; same as test 28 and 29
  void testGetSymbolValueForNonSymbol() {
    Entry entry = new Entry("Hello");
    assertThrows(BadTypeException.class, () -> entry.getSymbolValue(),
        "Checking that getting a symbol value for a non-SYMBOL type entry throws a BadTypeException.");
  }


  @Test
  // Test 22
  void testEqualsForSameObject() {
    Entry entry = new Entry(5.0f);
    assertTrue(entry.equals(entry), "An object should be equal to itself.");
  }

  @Test
  // Test 23
  void testEqualsForNullObject() {
    Entry entry = new Entry(5.0f);
    assertFalse(entry.equals(null), "An object should not be equal to null.");
  }

  @Test
  // Test 24
  void testEqualsForDifferentClass() {
    Entry entry = new Entry(5.0f);
    assertFalse(entry.equals("Hello"),
        "An object should not be equal to an object of a different class.");
  }

  @Test
  // Test 25
  void testEqualsForEqualEntries() {
    Entry entry1 = new Entry(5.0f);
    Entry entry2 = new Entry(5.0f);
    assertTrue(entry1.equals(entry2), "Two equal entries should be considered equal.");
  }

  @Test
  // Test 26
  void testEqualsForDifferentType() {
    Entry entry1 = new Entry(5.0f);
    Entry entry2 = new Entry("Hello");
    assertFalse(entry1.equals(entry2),
        "Entries with different types should not be considered equal.");
  }

  @Test
  // test 27
  void testEqualsForDifferentValue() {
    Entry entry1 = new Entry(5.0f);
    Entry entry2 = new Entry(3.0f);
    assertFalse(entry1.equals(entry2),
        "Entries with different values should not be considered equal.");
  }

  @Test
  // Test 31
  void testToString() {
    String plusToString = Symbol.PLUS.toString();
    String minusToString = Symbol.MINUS.toString();
    String timeToString = Symbol.TIME.toString();
    String divideToString = Symbol.DIVIDE.toString();
    String leftbracketToString = Symbol.LEFT_BRACKET.toString();
    String rightbracketToString = Symbol.RIGHT_BRACKET.toString();
    String invalidToString = Symbol.INVALID.toString();

    assertEquals("+", plusToString, "Checking the toString method for PLUS symbol.");
    assertEquals("-", minusToString, "Checking the toString method for MINUS symbol.");
    assertEquals("*", timeToString, "Checking the toString method for TIME symbol");
    assertEquals("/", divideToString, "Checking the toString method for DIVIDE symbol");
    assertEquals("(", leftbracketToString, "Checking the toString for method LEFT_BRACKET symbol");
    assertEquals(")", rightbracketToString,
        "Checking the tostring for method RIGHT_BRACKET symbol");
    assertEquals("Invalid", invalidToString, "Checking the toString for method INVALID symbol");
  }


  @Test
  // Test 32, Syntax mistakes
  void testToStringForFloat() {
    String floatToString = Type.FLOAT.toString();
    assertEquals("Float", floatToString, "Checking the toString method for Type.FLOAT");
  }

  @Test
  void testToStringForString() {
    String stringToString = Type.STRING.toString();
    assertEquals("String", stringToString, "Checking the toString method for Type.STRING");
  }

  @Test
  void testToStringForSymbol() {
    String symbolToString = Type.SYMBOL.toString();
    assertEquals("Symbol", symbolToString, "Checking the toString method for Type.SYMBOL");
  }

  @Test
  // Test 37;
  void testValidType() {
    Entry entryFloat = new Entry(Type.FLOAT, 5.0f);
    Entry entryString = new Entry(Type.STRING, "Hello");
    Entry entrySymbol = new Entry(Type.SYMBOL, Symbol.PLUS);

    assertEquals(Type.FLOAT, entryFloat.getType(), "Checking type for FLOAT");
    assertEquals(Type.STRING, entryString.getType(), "Checking type for STRING");
    assertEquals(Type.SYMBOL, entrySymbol.getType(), "Checking type for SYMBOL");
  }

  @Test
  // Test 38
  void testValidTypeFloat() {
    Entry entry = new Entry(Type.FLOAT, 5.0f);
    assertEquals(Type.FLOAT, entry.getType(), "Checking type for FLOAT");
    assertEquals(5.0f, entry.getFloatValue(), "Checking the float value for a FLOAT type entry.");
  }

  @Test
  // Test 39
  void testValidTypeString() {
    Entry entry = new Entry(Type.STRING, "Hello");
    assertEquals(Type.STRING, entry.getType(), "Checking type for STRING");
    assertEquals("Hello", entry.getStringValue(),
        "Checking the string value for a STRING type entry.");
  }

  @Test
  // Test 40
  void testValidTypeSymbol() {
    Entry entry = new Entry(Type.SYMBOL, Symbol.PLUS);
    assertEquals(Type.SYMBOL, entry.getType(), "Checking type for SYMBOL");
    assertEquals(Symbol.PLUS, entry.getSymbolValue(),
        "Checking the symbol value for a SYMBOL type entry.");
  }



}
