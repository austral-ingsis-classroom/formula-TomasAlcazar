package edu.austral.ingsis.math.visitor;

public class Absolute implements Function {
  public Function funcion;

  public Absolute(Function funcion) {
    this.funcion = funcion;
  }

  @Override
  public <T> T accepts(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
