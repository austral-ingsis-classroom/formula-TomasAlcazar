package edu.austral.ingsis.math.visitor.solve;

import edu.austral.ingsis.math.visitor.*;
import edu.austral.ingsis.math.visitor.operations.*;

public class Print implements Visitor<String>{

    @Override
    public String visit(Value value) {
        return Double.toString(value.value());
    }

    @Override
    public String visit(Variable variable) {
        return variable.name();
    }

    @Override
    public String visit(Addition addition) {
        return addition.getLeft().accepts(this) + " + " + addition.getRight().accepts(this);
    }

    @Override
    public String visit(Subtraction subtraction) {
        return subtraction.getLeft().accepts(this) + " - " + subtraction.getRight().accepts(this);
    }

    @Override
    public String visit(Multiplication multiplication) {
        return multiplication.getLeft().accepts(this) + " * " + multiplication.getRight().accepts(this);
    }

    @Override
    public String visit(Division division) {
        return division.getLeft().accepts(this) + " / " + division.getRight().accepts(this);
    }

    @Override
    public String visit(Power power) {
        return power.getValue().accepts(this) + " ^ " + power.getPower().accepts(this);
    }

    @Override
    public String visit(SquareRoot square) {
        return square.getFunction().accepts(this) + " ^ 1/2";
    }

    @Override
    public String visit(Absolute absolute) {
        return "|" + absolute.function.accepts(this) + "|";
    }
}
