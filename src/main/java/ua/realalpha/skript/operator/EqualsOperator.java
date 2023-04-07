package ua.realalpha.skript.operator;

import ua.realalpha.skript.token.Token;

public class EqualsOperator implements Operator {

    @Override
    public String getName() {
        return "==";
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public Object process(Token a, Token b) {

/*        if (a.isNumber() && b.isNumber()) {
            return a.toNumber().doubleValue() == b.toNumber().doubleValue();
        }*/

        return a.getVariable().equals(b.getVariable());
    }

}
