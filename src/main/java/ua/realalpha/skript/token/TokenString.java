package ua.realalpha.skript.token;

public class TokenString extends Token {

    public TokenString(String value) {
        super(value);
    }


    @Override
    public String toString() {
        return "TokenString{" +
                "value='" + this.variable + '\'' +
                '}';
    }
}
