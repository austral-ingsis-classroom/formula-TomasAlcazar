package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public class Module implements Function {

    Function function;

    public Module (Function function){
        this.function = function;
    }

    @Override
    public double solve(Map<String, Double> variables) {
        return Math.abs(function.solve(variables));
    }

    @Override
    public String printValue() {
        return "|" + function.printValue() + "|";
    }

    @Override
    public List<String> getVariables(List<String> list) {
        return function.getVariables(list);
    }
}
