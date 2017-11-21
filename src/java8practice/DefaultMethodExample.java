package java8practice;

public class DefaultMethodExample {

    public static void main(String[] args) {

        //An functional interface type can be instantiated by a lambda expression 
        //which exactly matches the signature of the abstract method of the interface
        MyInterface instance = () -> System.out.println("This is the abstract method");
        process(instance);

        //Calling a default method using the instance of the interface 
        instance.defaultMethod();

        //Calling static default method without creating an instance of the
        //interface type.
        MyInterface.staticDefaultMethod();

    }

    private static void process(MyInterface instance) {
        instance.abstractMethod();
    }

}

@FunctionalInterface
interface MyInterface {

    //A functional interface can contain only one abstract method
    public void abstractMethod();

    //Any number of default method is allowed in a functional interface
    default void defaultMethod() {
        System.out.println("This is a default method of MyInterface");
    }

    //Any number of static default method is allowed in a functional interface
    static void staticDefaultMethod() {
        System.out.println("This is a static default method of MyInterface");
    }
}
