package edu.austral.ingsis.math.visitor;

public class squareRoot implements Function {
  Function funcion;

  public squareRoot(Function funcion) {
    this.funcion = funcion;
  }

  public Function getFuncion() {
    return funcion;
  }

  @Override
  public <T> T accepts(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}
