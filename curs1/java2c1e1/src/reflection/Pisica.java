package reflection;

import main.MyAnnotation;

public class Pisica {

    @MyAnnotation("Tommy")
    private String nume;

    private Pisica() {
        System.out.println("ctor pisica");
    }

    private void miau() {
        System.out.println("Miau " + nume);
    }
}
