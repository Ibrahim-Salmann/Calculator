package application;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 * 
 * @author Ibraheem
 */
public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;

  /**
   * Handles the calculation process triggered by the user.
   */
  private void handleCalculation() {
    try {
      // Retrieve the expression from the view
      String expression = myView.getExpression();

      // Ensure that the expression is not empty before attempting evaluation
      if (expression.isEmpty()) {
        throw new InvalidExpressionException("Expression is empty");
      }

      // Evaluate the expression using the model
      float result = myModel.evaluate(expression, true); // Assuming infix notation

      // Display the result in the view
      myView.setAnswer(Float.toString(result));
    } catch (InvalidExpressionException e) {
      // Handle invalid expression exception, e.g., display an error message in the view
      myView.setAnswer("Error: " + e.getMessage());
    }
  }

  /**
   * Handles the change in calculation type (infix or reverse polish).
   * 
   * @param type The calculation type to set in the model.
   */
  private void handleTypeChange(OpType type) {
    // Assuming OpType has a method to get the boolean value
    boolean isInfix = type.getOpType();

    // Set the calculation type in the model
    myModel.setInfixCalculation(isInfix);
  }

  /**
   * Constructs a new CalcController with the specified model and view.
   * 
   * @param model The calculator model.
   * @param view The user interface view.
   */
  CalcController(CalcModel model, ViewInterface view) {


    this.myModel = model;
    this.myView = view;

    // Add observers to the view
    myView.addCalculateObserver(this::handleCalculation);
    myView.addTypeObserver(this::handleTypeChange);

    // Start the user interface
    myView.startView();
  }
}
