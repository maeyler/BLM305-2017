import java.awt.Point;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


class Reflect {
    //static methods: a brief introduction to java.lang.reflect
    
    public static Field getField(Class c, String name) {
        try {
            Field f = c.getDeclaredField(name);
            f.setAccessible(true);
            return f;
        } catch (Exception x) { //NoSuchFieldException
            return null;
        }
    }
    static Object fieldValue(Object b, Field f) {
        try {
            return f.get(b);
        } catch (Exception x) { //IllegalAccessException
            return null;
        }
    }
    public static Object fieldValue(Object b, String name) {
        Field f = getField(b.getClass(), name);
        return fieldValue(b, f);
    }
    public static Method getMethod(Class c, String name, Class... a) {
        try {
            Method m = c.getDeclaredMethod(name, a);
            m.setAccessible(true); return m;
        } catch (Exception x) { //IllegalAccessException
            return null;
        }
    }
    public static Object invokeMethod(Object b, String name, Object... a) {
        try {
            return getMethod(b.getClass(), name).invoke(b, a);
        } catch (Exception x) {
            return null;
        }
    }
    public static Field[] declaredFields(Object b) {
        List<Field> L = new ArrayList<Field>();
        for (Field f: b.getClass().getDeclaredFields()) {
            if (Modifier.isStatic(f.getModifiers())) continue;
            f.setAccessible(true); L.add(f);
        }
        return L.toArray(new Field[0]);
    }
    public static void printValues(Object b) {
        System.out.printf("%nField values of %s: %n", b.getClass().getName());
        for (Field f: declaredFields(b)) {
            String val = ""+fieldValue(b, f); //might be null
            if (val.length()>50) val = val.substring(0,45)+" ...";
            System.out.printf("  %s = %s %n", f.getName(), val);
        }
    }
    public static void printTypes(Object b) {
        System.out.printf("%nField types of %s: %n", b.getClass().getName());
        for (Field f: declaredFields(b)) {
            System.out.printf("  %s %s %n", f.getType(), f.getName());
        }
    }
    public static void main(String[] args) {
        Point p = new Point(30, 40);
        printTypes(p); printValues(p); 
        printTypes("xxx"); 
    }
}
