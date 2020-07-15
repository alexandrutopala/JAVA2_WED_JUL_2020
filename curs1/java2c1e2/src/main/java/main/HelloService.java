package main;

public class HelloService {

    @Logged
    public void sayHello() {
        System.out.println("hello");
    }

    public void sayBye() {
        System.out.println("Bye");
    }
}
