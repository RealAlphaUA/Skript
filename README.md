# Skript

The Skript tool is a parser and evaluator of simple mathematical expressions. 
It allows you to perform arithmetic and logical calculations using basic operators such as addition, subtraction, multiplication and division, as well as logical operators such as equality.

Indeed, the Skript tool also allows for more advanced operations such as the creation of variables and the use of conditions. It is thus possible to write expressions that have a similar structure to a programming language, but in a much simpler and more minimalist way.

## Using Skript

### Adding operators

Before using the Skript tool, it is necessary to add the operators that you want to use. To do this, you can use the registerOperator() method of the Skript object. This method takes a list of operators to add as a parameter. In the example below, we add the operators for addition, subtraction, equality, multiplication, and division:

```java
    Skript skript = new Skript();
    skript.registerOperator(new AdditionalOperator(), new SubtractOperator(), new EqualsOperator(), new MultiplyOperator(), new DivideOperator());
```

### Evaluating expressions

Once the operators are added, you can use the `evaluateExpression()` method of the `Skript` object to evaluate an expression. This method takes a string representing the expression to evaluate as a parameter. In the example below, we evaluate the expression "2 * 7 / 3.14 + 5 - 2 * 3":

```java
    Object result = skript.evaluateExpression("2 * 7 / 3.14 + 5 - 2 * 3");
    System.out.println("Result: "+result);
```

