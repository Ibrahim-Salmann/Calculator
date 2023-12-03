package application;

import java.util.Arrays;

/**
 * The RevPolishCalc class represents a calculator that evaluates mathematical expressions in
 * Reverse Polish Notation (RPN).
 *
 * Reverse Polish Notation is a mathematical notation in which every operator follows all of its
 * operands. It is also known as postfix notation.
 *
 * The calculator supports basic arithmetic operations such as addition, subtraction,
 * multiplication, and division. It utilizes a NumStack to store numerical values during the
 * evaluation process.
 * 
 * @author Ibraheem
 */
public class RevPolishCalc {

  /**
   * The NumStack used to store numerical values during the evaluation.
   */
  private NumStack rpc;
  /**
   * The result of the evaluation.
   */
  private float answere;

  /**
   * Constructs a new RevPolishCalc object with an initialized NumStack.
   */
  public RevPolishCalc() {
    rpc = new NumStack();
  }

  /**
   * Evaluates a mathematical expression in Reverse Polish Notation (RPN).
   *
   * @param str The RPN expression as a space-separated string.
   * @return The result of the evaluation.
   * @throws BadTypeException If an unsupported data type is encountered during evaluation.
   * @throws InvalidExpressionException If the expression is empty, has invalid format, or is too
   *         short to evaluate.
   */
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
        float right = rpc.pop();
        float left = rpc.pop();

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
        rpc.push(answere);
      } else {
        try {
          rpc.push(Float.parseFloat(element));
        } catch (NumberFormatException e) {
          throw new InvalidExpressionException("Not a number!");
        }
      }
    }
    return answere;
  }
}
