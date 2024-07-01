package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operations.*;

public interface Visitor<T> {
  T visit(Valor number);

  T visit(Variable variable);

  T visit(Suma suma);

  T visit(Resta resta);

  T visit(Multiplication multiplication);

  T visit(Division division);

  T visit(Power power);

  T visit(squareRoot square);

  T visit(Absolute absolute);
}
