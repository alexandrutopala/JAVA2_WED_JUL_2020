package reflection;

import java.lang.reflect.Field;

public class Exerciu1 {

    public static void main(String[] args) throws Exception {
        // var subintelege tipul de data Caine
        var caine = getCaine();

        System.out.println(caine.varsta);
    }

    private static Caine getCaine() throws Exception {
        Class<Caine> caineClass = Caine.class;

        Field varstaField = caineClass.getDeclaredField("varsta");

        Caine instance = new Caine();

        Random annotation = varstaField.getDeclaredAnnotation(Random.class);
        int bound = annotation.value();

        java.util.Random random = new java.util.Random();

        int varsta = random.nextInt(bound);

        varstaField.setAccessible(true);
        varstaField.setInt(instance, varsta);

        return instance;
    }
}
