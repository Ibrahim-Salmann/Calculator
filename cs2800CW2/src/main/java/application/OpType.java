package application;

/**
 * Codifies the types of expression that we can calculate.
 */
public enum OpType {
  STANDARD(true), REV_POLISH(false);

  private boolean opType;

  OpType(boolean opType) {
    this.opType = opType;
  }

  public boolean getOpType() {
    return this.opType;
  }


}
