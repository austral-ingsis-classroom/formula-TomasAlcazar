package edu.austral.ingsis.math.visitor.solve;

import edu.austral.ingsis.math.visitor.*;
import edu.austral.ingsis.math.visitor.operations.*;

import java.util.Map;

public class Resolve implements Visitor<Double> {
    private final Map<String, Double> variables;

    public Resolve(Map<String, Double> variables) {
        this.variables = variables;
    }

    public void addVariable(String name, Double value){
        variables.put(name, value);
    }

    @Override
    public Double visit(Value number) {
        return number.value();
    }

    @Override
    public Double visit(Variable variable) {
        return variables.get(variable.name());
    }

    @Override
    public Double visit(Addition addition) {
        return addition.getRight().accepts(this) + addition.getLeft().accepts(this);
    }

    @Override
    public Double visit(Subtraction subtraction) {
        return subtraction.getLeft().accepts(this) - subtraction.getRight().accepts(this);
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
    public Double visit(SquareRoot square) {
        return Math.sqrt(square.getFunction().accepts(this));
    }

    @Override
    public Double visit(Absolute absolute) {
        return Math.abs(absolute.function.accepts(this));
    }
}
