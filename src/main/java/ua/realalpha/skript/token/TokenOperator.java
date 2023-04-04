package ua.realalpha.skript.token;

import ua.realalpha.skript.operator.Operator;

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
    public String toString() {
        return "TokenOperator{" +
                "operation=" + operator.getName() +
                ", variable='" + variable + '\'' +
                '}';
    }
}
