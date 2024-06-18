package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public class Value implements Function {

    double value;

    public Value(double valor){
        this.value = value;
    }

    @Override
    public double solve(Map<String, Double> variables) {
        return value;
    }

    @Override
    public String printValue() {
        return Double.toString(value);
    }

    @Override
    public List<String> getVariables(List<String> list) {
        return list;
    }
}
