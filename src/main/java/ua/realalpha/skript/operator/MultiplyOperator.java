package ua.realalpha.skript.operator;

import ua.realalpha.skript.token.Token;

public class MultiplyOperator implements Operator {
    @Override
    public String getName() {
        return "Multiply";
    }

    @Override
    public String getOperator() {
        return "*";
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public Object process(Token a, Token b) {
        Number numberA = a.toNumber();
        Number numberB = b.toNumber();

        if (numberA instanceof Double || numberB instanceof Double) {
            return numberA.doubleValue() * numberB.doubleValue();
        } else if (numberA instanceof Float || numberB instanceof Float) {
            return numberA.floatValue() * numberB.floatValue();
        } else if (numberA instanceof Long || numberB instanceof Long) {
            return numberA.longValue() * numberB.longValue();
        } else {
            return numberA.intValue() * numberB.intValue();
        }
    }
}
