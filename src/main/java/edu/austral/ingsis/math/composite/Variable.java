package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public class Variable implements Function {

    private final String name;

    public Variable(String name){
        this.name = name;
    }

    @Override
    public double solve(Map<String, Double> variables) {
        return variables.get(name);
    }

    @Override
    public String printValue() {
        return name;
    }

    @Override
    public List<String> getVariables(List<String> list) {
        list.add(name);
        return list;    }

}
