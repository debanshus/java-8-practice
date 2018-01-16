package java8practice;

public class LambdaFirstStep {

    private static void execute(SomeInterface instance) {
        instance.doSomething();
    }

    public static void main(String[] args) {

        //Creating instance of the interface SomeInterface using anonymous inner classes
        SomeInterface instance1 = new SomeInterface() {
            @Override
            public void doSomething() {
                System.out.println("Hello annonymous class");
            }
        };
        instance1.doSomething();

        //Creating instance of the interface SomeInterface using lambda expression
        SomeInterface instance2 = () -> System.out.println("Hello lambda expression");
        instance2.doSomething();

        //Passing a lambda expression to a function accepting an instance of a
        //functional interface which in turn is represented by the lambda expression
        execute(() -> System.out.println("Hello lambda expression from execute"));
    }

}

@FunctionalInterface
interface SomeInterface {
    //Functional interface can have only one abstract method.
    //So that, it can be used to write a lambda expression.

    public void doSomething();

    //public void doSomething2(); This is not allowed as it is a functional interface
}
