package reflection;

import main.MyAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class pisicaClass = Class.forName("reflection.Pisica");

        Field numeField = pisicaClass.getDeclaredField("nume");

        Constructor constructor = pisicaClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        Object pisicaInstance = constructor.newInstance();

        MyAnnotation annotation = numeField.getDeclaredAnnotation(MyAnnotation.class);
        String value = annotation.value();

        numeField.setAccessible(true);
        numeField.set(pisicaInstance, value);

        Method miauMethod = pisicaClass.getDeclaredMethod("miau");
        miauMethod.setAccessible(true);

        miauMethod.invoke(pisicaInstance);
    }
}
