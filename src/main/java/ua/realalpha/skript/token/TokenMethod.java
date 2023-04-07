package ua.realalpha.skript.token;

import ua.realalpha.skript.method.Method;

import java.util.Objects;

public class TokenMethod extends Token{

    private Method method;
    private String parameters;

    public TokenMethod(String variable, Method method, String parameters) {
        super(variable);
        this.method = method;
        this.parameters = parameters;
    }

    public String getParameters() {
        return parameters;
    }

    public Method getMethod() {
        return method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenMethod that = (TokenMethod) o;
        return Objects.equals(method, that.method) && Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, parameters);
    }

    @Override
    public String toString() {
        return "TokenMethod{" +
                "method=" + method.getName() +
                ", parameters='" + parameters + '\'' +
                ", variable='" + variable + '\'' +
                '}';
    }
}
