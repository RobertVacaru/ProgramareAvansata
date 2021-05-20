import java.lang.reflect.*;
public class Framework {
    public static void frameWorkForClass(String name) throws Exception {
        int passed = 0, failed = 0;
        for (Method m : Class.forName(name).getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}