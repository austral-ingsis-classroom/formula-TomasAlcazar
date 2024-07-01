package edu.austral.ingsis.math.visitor.solve;

import edu.austral.ingsis.math.visitor.*;
import edu.austral.ingsis.math.visitor.operations.*;
import java.util.Map;

public class Resolve implements Visitor<Double> {
  private final Map<String, Double> variables;

  public Resolve(Map<String, Double> variables) {
    this.variables = variables;
  }

  public void addVariable(String name, Double value) {
    variables.put(name, value);
  }

  @Override
  public Double visit(Valor number) {
    return number.getValue();
  }

  @Override
  public Double visit(Variable variable) {
    return variables.get(variable.getName());
  }

  @Override
  public Double visit(Suma suma) {
    return suma.getRight().accepts(this) + suma.getLeft().accepts(this);
  }

  @Override
  public Double visit(Resta resta) {
    return resta.getLeft().accepts(this) - resta.getRight().accepts(this);
  }

  @Override
  public Double visit(Multiplication multiplication) {
    return multiplication.getRight().accepts(this) * multiplication.getLeft().accepts(this);
  }

  @Override
  public Double visit(Division division) {
    return division.getLeft().accepts(this) / division.getRight().accepts(this);
  }

  @Override
  public Double visit(Power power) {
    return Math.pow(power.getValue().accepts(this), power.getPower().accepts(this));
  }

  @Override
  public Double visit(squareRoot square) {
    return Math.sqrt(square.getFuncion().accepts(this));
  }

  @Override
  public Double visit(Absolute absolute) {
    return Math.abs(absolute.funcion.accepts(this));
  }
}
