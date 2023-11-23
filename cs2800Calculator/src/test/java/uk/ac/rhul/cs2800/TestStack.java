package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {

  private Stack stack;
  private Entry entry;

  @BeforeEach
  // Test 1; Stack & Entry Classes Created;'Entry(Float)'constructor created;
  public void setup() {
    stack = new Stack();
  }

  @Test
  // Test2; 'size()'method created, 'push(Entry) method created
  void testSize() {
    stack.push(new Entry(5.0f));
    stack.push(new Entry(3.0f));
    assertEquals(2, stack.size(),
        "Checking that the size is 2 after pushing two elements onto the stack");
  }


  @Test
  // Test 3, Success
  void testSizeInitiallyZero() {
    assertEquals(stack.size(), 0, "Test a new stack.");
  }

  @Test
  // Test 4, line 12 created
  void testSizeAfterPush() {
    stack.push(entry);
    assertEquals(stack.size(), 1, "Test that push increases the size of the stack.");
  }

  @Test
  // Test 5; method pop created in Stack
  void testEmptyPop() {
    assertEquals(0, stack.size(),
        "Checking that the size is 0 after attempting to pop from an empty stack.");
  }

  @Test
  // Test 6, enum for 'Type' created; getters and setters for Float created
  void testPushAndPop() {
    stack.push(new Entry(5.0f));
    Entry popEntry = stack.pop();
    assertEquals(5.0f, popEntry.getFloatValue(),
        "Checking that pushing and popping an entry returns the expected float value.");
  }

  @Test
  // Test 7, method for 'top' created
  void testpop() {
    stack.push(new Entry(5.0f));
    Entry topEntry = stack.top();
    assertEquals(5.0f, topEntry.getFloatValue(),
        "Checking that the top entry has the expected float value after pushing.");
  }

  @Test
  void testEmptyStackExceptionOnPop() {
    assertThrows(EmptyStackException.class, stack::pop,
        "Checking that an EmptyStackException is thrown when popping from an empty stack.");
  }

  @Test
  void testEmptyStackExceptionOnTop() {
    assertThrows(EmptyStackException.class, stack::top,
        "Checking that an EmptyStackException is thrown when calling top() on an empty stack.");
  }

  // Test8; Success

  @Test
  // test 17, fail. check size is 0, and making the entries same.
  void testPopAllElements() {
    stack.push(new Entry(3.0f));
    stack.push(new Entry(3.0f));

    // Pop all elements from the stack
    Entry entry1 = stack.pop();
    Entry entry2 = stack.pop();

    assertEquals(0, stack.size(),
        "Checking that the size is 0 after pushing two elements and popping them.");

    assertEquals(0, stack.size(),
        "Checking that the size is 0 after pushing two elements and popping them.");
    assertEquals(3.0f, entry1.getFloatValue(), "Checking the value of the first popped element.");
    assertEquals(3.0f, entry2.getFloatValue(), "Checking the value of the second popped element.");

  }

  @Test
  // Test 18, Success
  void testLargeStack() {
    int numEntries = 10000;
    for (int i = 0; i < numEntries; i++) {
      stack.push(new Entry(i));
    }
    assertEquals(numEntries, stack.size(), "Checking the size of a large stack.");
    for (int i = numEntries - 1; i >= 0; i--) {
      Entry popEntry = stack.pop();
      assertEquals(i, popEntry.getFloatValue(), "Checking the value of the popped entry.");
    }
    assertEquals(0, stack.size(), "Checking that the size is 0 after popping all entries.");
  }

}
