package ua.realalpha.skript.method;

import ua.realalpha.skript.token.Token;

public class LowerMethod implements Method{
    @Override
    public String getName() {
        return "lower";
    }

    @Override
    public int getPriority() {
        return 10;
    }

    @Override
    public Object process(Token token, Object... args) {
        if (token.getVariable() instanceof String) {
            return ((String) token.getVariable()).toLowerCase();
        }
        return null;
    }
}
