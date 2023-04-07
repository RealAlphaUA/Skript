package ua.realalpha.skript.operator;

import ua.realalpha.skript.token.Token;

public class AdditionalOperator implements Operator {

    @Override
    public String getName() {
        return "+";
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public Object process(Token a, Token b) {

        if (a.isNumber() && b.isNumber()) {
            Number numberA = a.toNumber();
            Number numberB = b.toNumber();

            if (numberA instanceof Double || numberB instanceof Double) {
                return numberA.doubleValue() + numberB.doubleValue();
            } else if (numberA instanceof Float || numberB instanceof Float) {
                return numberA.floatValue() + numberB.floatValue();
            } else if (numberA instanceof Long || numberB instanceof Long) {
                return numberA.longValue() + numberB.longValue();
            } else {
                return numberA.intValue() + numberB.intValue();
            }
        }

        if (a.isString() && b.isString()) {
            String stringA = ((String) a.getVariable());
            String stringB = ((String) b.getVariable());

            return stringA + stringB;
        }



        return "NULL";
    }
}
