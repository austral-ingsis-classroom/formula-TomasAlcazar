package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;

public class Addition implements Operation {

    private final Function a;
    private final Function b;

    public Addition(Function a, Function b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double solve(Map<String, Double> variables) {
        return a.solve(variables) + b.solve(variables);
    }

    @Override
    public String printValue() {
        return a.printValue() + " + " + b.printValue();
    }

    @Override
    public List<String> getVariables(List<String> list) {
        a.getVariables(list);
        b.getVariables(list);
        return list;
    }
}

