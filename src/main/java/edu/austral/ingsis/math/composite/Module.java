package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public class Module implements Function {
  Function funcion;

  public Module(Function funcion) {
    this.funcion = funcion;
  }

  @Override
  public double solve(Map<String, Double> variables) {
    return Math.abs(funcion.solve(variables));
  }

  @Override
  public String printValue() {
    return "|" + funcion.printValue() + "|";
  }

  @Override
  public List<String> getVariables(List<String> list) {
    return funcion.getVariables(list);
  }
}
