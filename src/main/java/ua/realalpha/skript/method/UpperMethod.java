package ua.realalpha.skript.method;

import ua.realalpha.skript.token.Token;

public class UpperMethod implements Method {

    @Override
    public Object process(Token token, Object... args) {
        if (token.getVariable() instanceof String) {
            return ((String) token.getVariable()).toUpperCase();
        }
        return null;
    }

    @Override
    public String getName() {
        return "upper";
    }

    @Override
    public int getPriority() {
        return 10;
    }

    @Override
    public String toString(){
        return "UpperMethod{" + getName() + "}";
    }
}
