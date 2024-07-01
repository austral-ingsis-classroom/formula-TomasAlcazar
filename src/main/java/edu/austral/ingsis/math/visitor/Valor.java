package edu.austral.ingsis.math.visitor;

public class Valor implements Function {
  private final double value;

  public Valor(double value) {
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  @Override
  public <T> T accepts(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
