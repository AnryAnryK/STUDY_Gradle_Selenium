package JUnit5;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MiniJUnit {
    public static void main(String[] args) throws Exception {

        Method[] methods = MiniJUnitTest.class.getDeclaredMethods();
        for (Method method : methods) {
            method.getAnnotation(Test.class);
            Test annotation = method.getAnnotation(Test.class);
            if (annotation != null) {
                MiniJUnitTest instance =  MiniJUnitTest.class.getConstructor().newInstance();
                try {
                    method.invoke(instance);
                } catch (Exception e) {
                    System.out.println("MiniJUnitTest is FAIL");
                    return;
                }
                System.out.println("MiniJUnitTest is SUCCESSFULL");
            }
        }
    }
}
