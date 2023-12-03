package application;

import java.util.Arrays;

/**
 * @author Ibraheem
 */
public class StandardCalc {

  private OpStack ops;
  private RevPolishCalc rpc;

  public StandardCalc() {
    ops = new OpStack();
    rpc = new RevPolishCalc();
  }

  String[] operators = {"/", "*", "+", "-", "(", ")"};
  Symbol[] symbols = {Symbol.DIVIDE, Symbol.TIME, Symbol.MINUS, Symbol.PLUS, Symbol.LEFT_BRACKET,
      Symbol.RIGHT_BRACKET};


  /**
   * @param str
   * @return
   * @throws BadTypeException
   * @throws InvalidExpressionException
   */
  public float evaluate(String str) throws BadTypeException, InvalidExpressionException {

    String[] elements = str.split(" ");
    String postfix = " ";

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
        }else{
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
