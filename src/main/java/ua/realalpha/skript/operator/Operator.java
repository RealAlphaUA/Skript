package ua.realalpha.skript.operator;

import ua.realalpha.skript.token.Token;

public interface Operator {

    String getName();

    String getOperator();

    int getPriority();

    Object process(Token a, Token b);

}
