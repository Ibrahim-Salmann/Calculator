package application;

import java.util.Arrays;

public class RevPolishCalc {

  private NumStack RPC;
  private float answere;

  public RevPolishCalc() {
    RPC = new NumStack();
  }

  public float evaluate(String str) throws BadTypeException, InvalidExpressionException {

    String[] elements = str.split(" ");
    String[] operants = {"/", "*", "+", "-"};

    if (str.isEmpty()) {
      throw new InvalidExpressionException("Unable to evaluate an empty string");
    } else if (str.contains("(") || str.contains(")")) {
      throw new InvalidExpressionException("Invalid format");
    } else if (elements.length < 3) {
      throw new InvalidExpressionException("The expression is too short to evaluate.");
    }

    for (String element : elements) {
      if (Arrays.asList(operants).contains(element)) {
        float right = RPC.pop();
        float left = RPC.pop();

        switch (element) {
          case "/":
            if (right == 0f) {
              throw new InvalidExpressionException("Cannot divide with zero");
            }
            answere = left / right;
            break;
          case "*":
            answere = left * right;
            break;
          case "+":
            answere = left + right;
            break;
          case "-":
            answere = left - right;
            break;
          default:
        }
        RPC.push(answere);
      } else {
        try {
          RPC.push(Float.parseFloat(element));
        } catch (NumberFormatException e) {
          throw new InvalidExpressionException("Not a number!");
        }
      }
    }
    return answere;
  }
}
