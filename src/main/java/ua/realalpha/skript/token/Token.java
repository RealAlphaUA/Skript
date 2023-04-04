package ua.realalpha.skript.token;

public class Token {

    protected Object variable;

    public Token(Object variable) {
        this.variable = variable;
    }

    public boolean isNumber() {
        if (variable instanceof String) {
            try {
                Double.parseDouble((String) variable);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return variable instanceof Number;
    }

    public Number toNumber() {
        if (variable instanceof String) {
            return Double.parseDouble((String) variable);
        }
        if (variable instanceof Number) {
            return (Number) variable;
        }

        return 0;
    }

    public Object getVariable() {
        return variable;
    }

    @Override
    public String toString() {
        return "Token{" +
                "variable='" + variable + '\'' +
                '}';
    }
}
