package ua.realalpha.skript.method;

import ua.realalpha.skript.Instruction;
import ua.realalpha.skript.token.Token;

public interface Method extends Instruction {

    Object process(Token token, Object... args);

}
