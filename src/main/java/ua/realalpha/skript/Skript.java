package ua.realalpha.skript;

import ua.realalpha.skript.operator.Operator;
import ua.realalpha.skript.token.TokenOperator;
import ua.realalpha.skript.token.Token;

import java.util.*;

public class Skript {

    private final Map<String, Operator> operators = new HashMap<>();

    public void registerOperator(Operator... operators) {
        for (Operator operator : operators) {
            this.operators.put(operator.getOperator(), operator);
        }
    }

    public Object evaluateExpression(String input) {
        List<Token> tokens = tokenize(input);
        List<Token> validated = validate(tokens);
        List<Operator> operators = getOperations(validated);

        return process(validated, operators);
    }

    private Object process(List<Token> tokens, List<Operator> operators) {
        int maxPriority = getHighPriority(operators);

        Token[] resultTokens = new Token[tokens.size()];

        for (int i = 0; i < tokens.size(); i++) {
            resultTokens[i] = tokens.get(i);
        }

        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if (token instanceof TokenOperator) {
                TokenOperator tokenOperator = (TokenOperator) token;
                Operator operator = tokenOperator.getOperation();
                if (operator.getPriority() == maxPriority) {

                    operators.remove(operator);

                    Token a = resultTokens[i - 1];
                    Token b = resultTokens[i + 1];

                    resultTokens[i - 1] = null;
                    resultTokens[i] = null;

                    Token resultToken = new Token(operator.process(a, b));
                    resultTokens[i + 1] = resultToken;
                }
            }
        }

        List<Token> reduce = reduce(resultTokens);
        if (reduce.size() == 1) {
            return reduce.get(0).getVariable();
        }

        return process(reduce, operators);
    }

    private List<Token> validate(List<Token> tokens){
        Token[] resultTokens = new Token[tokens.size()];

        for (int i = 0; i < tokens.size(); i++) {
            resultTokens[i] = tokens.get(i);
        }

        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if (token instanceof TokenOperator){
                TokenOperator tokenOperator = (TokenOperator) token;
                Operator operator = tokenOperator.getOperation();
                Token a = getSafeToken(resultTokens, i - 1);
                if (a == null) {
                    setSafeToken(resultTokens, i, null);
                    resultTokens[i + 1] = new Token(operator.getOperator()+resultTokens[i + 1].getVariable());
                    continue;
                }

                if (a instanceof TokenOperator){
                    setSafeToken(resultTokens, i, null);
                    setSafeToken(resultTokens, i - 1, null);
                    resultTokens[i + 1] = new Token(operator.getOperator()+resultTokens[i + 1].getVariable());
                    continue;
                }

                if (a.getVariable().toString().isEmpty()){
                    a = getSafeToken(resultTokens, i - 2);
                    if(a instanceof TokenOperator){
                        setSafeToken(resultTokens, i, null);
                        setSafeToken(resultTokens, i - 1, null);
                        resultTokens[i + 1] = new Token(operator.getOperator()+resultTokens[i + 1].getVariable());
                    }else {
                        resultTokens[i + 1] = new Token(operator.getOperator()+resultTokens[i + 1].getVariable());
                        setSafeToken(resultTokens, i, null);
                        setSafeToken(resultTokens, i - 1, null);
                    }
                }

            }
        }

        return reduce(resultTokens);
    }

    private List<Token> reduce(Token[] tokens){
        List<Token> list = new ArrayList<>();
        for (Token token : tokens) {
            if (token != null){
                list.add(token);
            }
        }
        return list;
    }

    private Token getSafeToken(Token[] tokens, int idx){
        if (idx < 0 || idx >= tokens.length) return null;
        return tokens[idx];
    }

    private void setSafeToken(Token[] tokens, int idx, Token token){
        if (idx < 0 || idx >= tokens.length) return;
        tokens[idx] = token;
    }

    private List<Operator> getOperations(List<Token> tokens){
        List<Operator> operators = new ArrayList<>();
        for (Token token : tokens) {
            if (token instanceof TokenOperator){
                operators.add(((TokenOperator) token).getOperation());
            }
        }
        return operators;
    }

    private int getHighPriority(Collection<Operator> operators){
        int highPriority = 0;
        for (Operator operator : operators) {
            if (highPriority < operator.getPriority()) highPriority = operator.getPriority();
        }

        return highPriority;
    }

    public List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        char[] charArray = input.toCharArray();
        String operator = "";
        int idx = 0;
        float progressProcess = 0;

        String lastOperator = "";
        int lastStartOperator = 0;

        for (char c : charArray) {
            operator += c;
            String parsed;
            for (int i = 0; i < operator.length(); i++) {
                parsed = operator.substring(i);
                if (operators.containsKey(parsed)) {
                    Operator operation = operators.get(parsed);

                    lastOperator = parsed;
                    lastStartOperator = idx;
                    String token = operator.substring(0, operator.length() - parsed.length());
                    progressProcess += token.length();
                    progressProcess += parsed.length();
                    tokens.add(new Token(clearSpace(token)));
                    tokens.add(new TokenOperator(clearSpace(parsed), operation));
                    operator = "";
                }
            }
            idx++;

        }

        if (progressProcess / input.length() != 1) {
            String substring = input.substring(lastStartOperator + (lastOperator.length()));
            tokens.add(new Token(clearSpace(substring)));
        }

        return tokens;
    }

    private String clearSpace(String inout) {
        return inout.replaceAll(" ", "");
    }

}
