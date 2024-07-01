package edu.austral.ingsis.math.visitor.solve;

import edu.austral.ingsis.math.visitor.*;
import edu.austral.ingsis.math.visitor.operations.*;

public class Print implements Visitor<String>{

    @Override
    public String visit(Valor number) {
        return Double.toString(number.getValue());
    }

    @Override
    public String visit(Variable variable) {
        return variable.getName();
    }

    @Override
    public String visit(Suma suma) {
        return suma.getLeft().accepts(this) + " + " + suma.getRight().accepts(this);
    }

    @Override
    public String visit(Resta resta) {
        return resta.getLeft().accepts(this) + " - " + resta.getRight().accepts(this);
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
    public String visit(squareRoot square) {
        return square.getFuncion().accepts(this) + " ^ 1/2";
    }

    @Override
    public String visit(Absolute absolute) {
        return "|" + absolute.funcion.accepts(this) + "|";
    }
}
