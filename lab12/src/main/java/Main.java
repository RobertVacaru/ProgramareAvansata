import java.beans.IntrospectionException;

public class Main {
    public static void main(String args[]) throws Exception {
     ClassInspector classInspector =new ClassInspector();
     classInspector.inspect("java.lang.String");
     Framework.frameWorkForClass("MyProgram");
    }
}
