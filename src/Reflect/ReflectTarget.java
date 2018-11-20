package Reflect;

import java.lang.reflect.InvocationTargetException;

public class ReflectTarget {

    private String _name;

    public ReflectTarget(String name) {
        this._name = name;
    }

    public void sayHello() {
        System.out.println("Hello:" + this._name);
    }

    public static ReflectTarget getInstance() {
        ReflectTarget result = null;
        try {
            result = (ReflectTarget) Class.forName("Reflect.ReflectTarget")
                    .getConstructor(String.class).newInstance("me");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}
