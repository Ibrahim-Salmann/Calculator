package application;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Skeleton code for a terminal based calculator that reads an expression from the user and
 * evaluates it and prints out the answer.
 */
public class AsciiView implements ViewInterface {
  // The current question that the calculator must solve: entered like ?3*(5+4)
  private String question;

  private boolean isInfix;

  private String expression;

  private String answer;

  private Observer calc, type;

  // This method will be injected so we can ask the controller to calculate
  Runnable doCalculation = null;

  // This method changes how the calculator will evaluate the question
  Consumer<OpType> setCalculatorType = null;


  private void menu() {
    Scanner s = new Scanner(System.in);
    boolean finished = false;
    help();

    while (!finished && s.hasNext()) {
      String t = s.next();
      switch (t.toUpperCase().charAt(0)) {
        case 'C': // Ask the controller to calculate
          if (calc != null) {
            calc.notify();
            System.out.println("Result: " + answer);
          }
          break;
        case '?': // Set current question
          question = t.substring(1);
          System.out.println("Question set to: " + question);
          break;
        case 'Q':
          System.out.println("Bye");
          finished = true;
          finished = true;
          break;
        case 'R': // change to a reverse polish calculator
          if (type != null) {
            isInfix = !isInfix;
            type.notify();
          }
          break;
        default:
          help();
      }
    }
    s.close();
  }

  private void help() {
    System.out.println("Use one of the following:");
    System.out.println("  ?Expression - to set expression");
    System.out.println("  C - to calculate");
    System.out.println("  S - change to a standard calculator");
    System.out.println("  R - change to a reverse polish calculator");
    System.out.println("  Q - to exit");
  }

  @Override
  public String getExpression() {
    return this.expression;
  }

  @Override
  public void setAnswer(String answer) {
    this.answer = answer;
  }

  @Override
  public void addCalculateObserver(Runnable f) {
    calc = (Observer) f;
  }

  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    type = (Observer) c;
  }

  @Override
  public void startView() {
    menu();
  }

  @Override
  public OpType retrieveOpType() {
    return isInfix ? OpType.STANDARD : OpType.REV_POLISH;
  }


}
