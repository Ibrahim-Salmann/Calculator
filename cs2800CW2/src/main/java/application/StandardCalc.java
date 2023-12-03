package application;

import java.util.Arrays;

/**
 * The StandardCalc class represents a standard calculator that evaluates mathematical expressions.
 * It uses a Reverse Polish Calculator (RPC) for computation and an Operator Stack (OpStack) for
 * managing operators during the evaluation process.
 * 
 * @author Ibraheem
 */
public class StandardCalc {

  private OpStack ops;
  private RevPolishCalc rpc;

  /**
   * Constructs a StandardCalc with initialized Operator Stack (OpStack) and Reverse Polish
   * Calculator (RPC).
   */
  public StandardCalc() {
    ops = new OpStack();
    rpc = new RevPolishCalc();
  }

  String[] operators = {"/", "*", "+", "-", "(", ")"};
  Symbol[] symbols = {Symbol.DIVIDE, Symbol.TIME, Symbol.MINUS, Symbol.PLUS, Symbol.LEFT_BRACKET,
      Symbol.RIGHT_BRACKET};


  /**
   * Evaluates a mathematical expression in infix notation and returns the result.
   * 
   * @param str The infix mathematical expression to be evaluated.
   * @return The result of the evaluation.
   * @throws BadTypeException If an unexpected data type is encountered during evaluation.
   * @throws InvalidExpressionException If the expression is invalid or contains unsupported
   *         symbols.
   */
  public float evaluate(String str) throws BadTypeException, InvalidExpressionException {

    String[] elements = str.split(" ");
    String postfix = "";

    for (String element : elements) {
      try {
        postfix += (Float.parseFloat(element)) + " ";
      } catch (NumberFormatException e) {
        if (Arrays.asList(operators).contains(element)) {
          Symbol symbol = toSymbol(element);
          if (ops.stackisEmpty()) {
            ops.push(symbol);
          } else if (symbol == Symbol.LEFT_BRACKET) {
            ops.push(symbol);
          } else if (symbol == Symbol.RIGHT_BRACKET) {
            while (ops.top().getPrecedence() > 0) {
              postfix += ops.pop() + " ";
            }
            ops.pop();
          } else if (!ops.stackisEmpty() && symbol.getPrecedence() <= ops.top().getPrecedence()) {
            while (!ops.stackisEmpty() && symbol.getPrecedence() <= ops.top().getPrecedence()) {
              postfix += ops.pop() + " ";
            }
            ops.push(symbol);
          } else {
            ops.push(symbol);
          }
        } else {
          throw new InvalidExpressionException("Expression contains invalid symbol.");
        }

      }

    }
    if (!ops.stackisEmpty()) {
      while (ops.size() > 1) {
        postfix += ops.pop() + " ";
      }
      postfix += ops.pop();
    }
    return rpc.evaluate(postfix);
  }


  /**
   * Converts a string representation of an operator to the corresponding Symbol enum.
   * 
   * @param operant The string representation of the operator.
   * @return The Symbol enum corresponding to the operator.
   */
  private Symbol toSymbol(String operant) {
    switch (operant) {
      case "/":
        return Symbol.DIVIDE;
      case "*":
        return Symbol.TIME;
      case "-":
        return Symbol.MINUS;
      case "+":
        return Symbol.PLUS;
      case "(":
        return Symbol.LEFT_BRACKET;
      case ")":
        return Symbol.RIGHT_BRACKET;
      default:
        return Symbol.INVALID;
    }

  }

}
