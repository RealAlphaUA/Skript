package ua.realalpha.skript.operator;

import ua.realalpha.skript.Instruction;
import ua.realalpha.skript.token.Token;

public interface Operator extends Instruction {

    Object process(Token a, Token b);

}
