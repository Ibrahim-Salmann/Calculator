package application;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The {@code StandardCalc} class represents a standard calculator that evaluates mathematical
 * expressions. It uses a Reverse Polish Calculator (RPC) for computation and an Operator Stack
 * (OpStack) for managing operators during the evaluation process.
 * 
 * @author Ibraheem
 */
public class StandardCalc {

  private OpStack ops;
  private RevPolishCalc rpc;

  /**
   * Evaluates a mathematical expression and returns the result.
   * 
   * @param str The input mathematical expression.
   * @return The result of the evaluation.
   * @throws BadTypeException If an invalid data type is encountered.
   * @throws InvalidExpressionException If the expression is invalid.
   * @throws EmptyStackException If an attempt is made to pop from an empty stack.
   */
  public float evaluate(String str)
      throws BadTypeException, InvalidExpressionException, EmptyStackException {

    this.rpc = new RevPolishCalc();

    List<Entry> entries = new ArrayList<Entry>();

    this.ops = new OpStack();

    // HashMaps for operator precedence and symbols
    HashMap<String, Integer> stringMap = new HashMap<String, Integer>();
    HashMap<Symbol, String> symbolMap = new HashMap<Symbol, String>();
    HashMap<String, Symbol> maps = new HashMap<String, Symbol>();


    stringMap.put("/", 0);
    stringMap.put("*", 0);
    stringMap.put("+", 1);
    stringMap.put("-", 1);
    stringMap.put("(", -1);

    symbolMap.put(Symbol.DIVIDE, "/");
    symbolMap.put(Symbol.TIME, "*");
    symbolMap.put(Symbol.PLUS, "+");
    symbolMap.put(Symbol.MINUS, "-");
    symbolMap.put(Symbol.LEFT_BRACKET, "(");

    maps.put("/", Symbol.DIVIDE);
    maps.put("*", Symbol.TIME);
    maps.put("+", Symbol.PLUS);
    maps.put("-", Symbol.MINUS);
    maps.put("(", Symbol.LEFT_BRACKET);

    String[] operants = {"/", "*", "+", "-"};


    String postfix = "";
    String[] elements = str.split(" ");



    for (int i = 0; i < elements.length; i++) {
      String element = elements[i];

      try {
        // Attempt to parse the element as a float (numeric value)
        Float.parseFloat(element);
        postfix += element;
        postfix += " ";

      } catch (NumberFormatException e) {

        if (Arrays.asList(operants).contains(element)) {
          // Process operators
          while (!ops.stackisEmpty()
              && stringMap.get(symbolMap.get(ops.top())) > stringMap.get(element)) {


            postfix += symbolMap.get(ops.pop());
            postfix += " ";
          }


          ops.push(maps.get(element));

        } else if (element.equals("(")) {
          // Process open parenthesis
          ops.push(maps.get(element));
          // Process close parenthesis
        } else if (element.equals(")")) {

          while (!ops.stackisEmpty() && !symbolMap.get(ops.top()).equals("(")) {

            postfix += symbolMap.get(ops.pop());
            postfix += " ";
          }
          if (!ops.stackisEmpty()) {
            ops.pop(); // Pop the "(" from the stack
          } else {
            throw new InvalidExpressionException("Mismatched parentheses");
          }

          // ops.pop();
        } else if (i > 0 && isNumeric(elements[i - 1])) {
          // Check for consecutive numeric values
          throw new InvalidExpressionException("Consecutive numeric values");
        } else if (i > 0 && Arrays.asList(operants).contains(elements[i - 1])) {
          // Check for consecutive operators without operands
          throw new InvalidExpressionException("Consecutive operators without operands");
        }
      }
    }

    // Process remaining operators on the stack
    while (!ops.stackisEmpty()) {

      postfix += symbolMap.get(ops.pop());
      postfix += " ";
    }

    postfix = postfix.trim(); // Remove trailing space

    float answere = rpc.evaluate(postfix);


    return answere;

  }

  /**
   * Checks if a given string represents a numeric value.
   * 
   * @param str The string to check.
   * @return {@code true} if the string is numeric, {@code false} otherwise
   */
  private boolean isNumeric(String str) {
    try {
      Float.parseFloat(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }



}
