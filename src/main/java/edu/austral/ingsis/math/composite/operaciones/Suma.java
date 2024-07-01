package edu.austral.ingsis.math.composite.operaciones;

import edu.austral.ingsis.math.composite.Function;
import java.util.List;
import java.util.Map;

public class Suma implements Operation {
  Function funcionRight;
  Function funcionLeft;

  public Suma(Function funcionRight, Function funcionLeft) {
    this.funcionRight = funcionRight;
    this.funcionLeft = funcionLeft;
  }

  @Override
  public double solve(Map<String, Double> variables) {
    return funcionLeft.solve(variables) + funcionRight.solve(variables);
  }

  @Override
  public String printValue() {
    return funcionRight.printValue() + " + " + funcionLeft.printValue();
  }

  @Override
  public List<String> getVariables(List<String> list) {
    funcionRight.getVariables(list);
    funcionLeft.getVariables(list);
    return list;
  }
}
