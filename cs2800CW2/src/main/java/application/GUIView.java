package application;


import java.io.IOException;
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class GUIView implements ViewInterface {


  @FXML
  private TextField expressionField;

  @FXML
  private Button calculateButton;

  @FXML
  private RadioButton infixRadioButton;

  @FXML
  private RadioButton reversePolishRadioButton;

  @FXML
  private Label answerLabel;

  private Consumer<OpType> typeObserver;
  private Runnable calculateObserver;

  private OpType opType;

  @FXML
  public void initialize() {
    ToggleGroup toggleGroup = new ToggleGroup();
    infixRadioButton.setToggleGroup(toggleGroup);
    reversePolishRadioButton.setToggleGroup(toggleGroup);

    // Set default OpType
    opType = OpType.STANDARD; // Assuming infix notation by default

    // Add listeners for radio button changes
    infixRadioButton.setOnAction(event -> setOpType(OpType.STANDARD));
    reversePolishRadioButton.setOnAction(event -> setOpType(OpType.REV_POLISH));

    // Add listener for calculate button click
    calculateButton.setOnAction(event -> calculate());
  }

  private void setOpType(OpType type) {
    opType = type;
    if (typeObserver != null) {
      typeObserver.accept(type);
    }
  }

  private void calculate() {
    if (calculateObserver != null) {
      calculateObserver.run();
    }
  }

  @Override
  public void addCalculateObserver(Runnable f) {
    calculateObserver = f;

  }

  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    typeObserver = c;

  }

  @Override
  public String getExpression() {
    return expressionField.getText();
  }

  @Override
  public void setAnswer(String a) {
    answerLabel.setText("Answer: " + a);

  }

  @Override
  public void startView() {


  }

  @Override
  public OpType retrieveOpType() {
    return opType;
  }

}
