package edu.austral.ingsis.math.visitor;

public class Variable implements Function {
  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public <T> T accepts(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
