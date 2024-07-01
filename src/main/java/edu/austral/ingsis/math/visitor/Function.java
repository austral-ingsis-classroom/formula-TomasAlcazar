package edu.austral.ingsis.math.visitor;

public interface Function {
  <T> T accepts(Visitor<T> visitor);
}
