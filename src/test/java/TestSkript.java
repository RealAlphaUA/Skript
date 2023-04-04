import ua.realalpha.skript.Skript;
import ua.realalpha.skript.operator.AdditionalOperator;
import ua.realalpha.skript.operator.EqualsOperator;
import ua.realalpha.skript.operator.MultiplyOperator;
import ua.realalpha.skript.operator.SubtractOperation;

public class TestSkript {

    public static void main(String[] args) {
        Skript skript = new Skript();
        skript.registerOperator(new AdditionalOperator(), new SubtractOperation(), new EqualsOperator(), new MultiplyOperator());

        long start = System.currentTimeMillis();

        Object result = skript.evaluateExpression("2 + 1+3 - 20 * 2 == 34");
        System.out.println("Result: "+result);

        System.out.println("Done ("+(System.currentTimeMillis()-start)+" ms)");
    }
    
}
