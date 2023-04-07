import ua.realalpha.skript.Skript;
import ua.realalpha.skript.method.LowerMethod;
import ua.realalpha.skript.method.UpperMethod;
import ua.realalpha.skript.operator.*;

public class TestSkript {

    public static void main(String[] args) {
        Skript skript = new Skript();
        skript.registerOperator(new AdditionalOperator(), new SubtractOperator(), new EqualsOperator(), new MultiplyOperator(), new DivideOperator());
        skript.registerMethod(new UpperMethod(), new LowerMethod());

        long start = System.currentTimeMillis();

        Object result = skript.evaluateExpression("1+2+3*2");
        System.out.println("Result: "+result);

        System.out.println("Done ("+(System.currentTimeMillis()-start)+" ms)");

    }

}
