package ua.realalpha.skript.token;

import ua.realalpha.skript.operator.Operator;

import java.util.Objects;


public class TokenOperator extends Token  {

    private Operator operator;

    public TokenOperator(String variable, Operator operator) {
        super(variable);
        this.operator = operator;
    }

    public Operator getOperation() {
        return operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokenOperator)) return false;
        TokenOperator that = (TokenOperator) o;
        return Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator);
    }

    @Override
    public String toString() {
        return "TokenOperator{" +
                "operation=" + operator.getName() +
                ", variable='" + variable + '\'' +
                '}';
    }
}
