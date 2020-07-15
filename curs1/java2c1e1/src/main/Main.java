package main;

@MyAnnotation(value = "val1")
public class Main {

    //@MyAnnotation("val2")
    private int x;

    @MyAnnotation(value = "val3", number = 2)
    private void m(int a) {

    }

    public static void main(String[] args) {

    }
}
