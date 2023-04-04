import ua.realalpha.skript.Skript;
import ua.realalpha.skript.operator.*;

public class TestSkript {

    public static void main(String[] args) {
        Skript skript = new Skript();
        skript.registerOperator(new AdditionalOperator(), new SubtractOperator(), new EqualsOperator(), new MultiplyOperator(), new DivideOperator());

        long start = System.currentTimeMillis();

        Object result = skript.evaluateExpression("2 * 7 / 3.14 + 5 - 2 * 3");
        System.out.println("Result: "+result);

        System.out.println("Done ("+(System.currentTimeMillis()-start)+" ms)");

    }

}
