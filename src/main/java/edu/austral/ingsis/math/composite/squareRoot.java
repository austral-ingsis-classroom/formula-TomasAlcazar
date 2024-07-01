package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;

public class squareRoot implements Function {
    Function funcion;
    public squareRoot(Function funcion){
        this.funcion = funcion;
    }

    @Override
    public double solve(Map<String, Double> variables) {
        return Math.sqrt(funcion.solve(variables));
    }

    @Override
    public String printValue() {
        return "√" + funcion.printValue();
    }
    @Override
    public List<String> getVariables(List<String> list) {
        return funcion.getVariables(list);
    }

}
