package eu.hanskruse.noaber.test;

import eu.hanskruse.noaber.test.EitherTest.ConsumerCheck;

public class ConsumerCheckImpl implements ConsumerCheck {

  private boolean leftCalled = false;
  private boolean rightCalled = false;
  private IllegalStateException left;
  private String right;

  @Override
  public void leftConsumer(IllegalStateException left) {
    this.left = left;
    leftCalled = true;
  }

  @Override
  public void rightConsumer(String right) {
    this.right = right;
    rightCalled = true;
  }

  public boolean isLeftCalled() {
    return leftCalled;
  }

  public boolean isRightCalled() {
    return rightCalled;
  }

  public IllegalStateException getLeft() {
    return left;
  }

  public String getRight() {
    return right;
  }
}
