package Java.src.com.hust.cqb.SuperTest.Day01.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * - 成员变量Fields：
 * - `Field[] getFields()`
 * - `Field[] getDeclaredFields()`
 * - `Field getField(String name)`
 * - `Field[] getDeclaredField(String name)`
 * - 构造方法Constructor：
 * - `Constructor<?>[] getConstructors()`
 * - `Constructor<?>[] getDeclaredConstructors()`
 * - `Constructor<T> getConstructor(类<?>... parameterTypes)`
 * - `Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)`
 * - 成员方法Methods
 * - `Method[] getMethods()`
 * - `Method[] getDeclaredMethods()`
 * - `Method getMethod(String name, 类<?>... parameterTypes)`
 * - `Method getDeclaredMethod(String name, 类<?>... parameterTypes)`
 * - 类名
 * - `String getName()`
 */

public class ReflectDemo04 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class personClass = Person.class;
        /**
         * 成员方法Methods
         *  * - `Method[] getMethods()`
         *  * - `Method[] getDeclaredMethods()`
         *  * - `Method getMethod(String name, 类<?>... parameterTypes)`
         *  * - `Method getDeclaredMethod(String name, 类<?>... parameterTypes)`
         */
        Method eat_method = personClass.getMethod("eat");
        Person p = new Person();
        eat_method.invoke(p);

        Method eat_method2 = personClass.getMethod("eat", String.class);
        eat_method2.invoke(p, "food");

        System.out.println("-----------------------------------------");

        Method[] methods = personClass.getMethods();
        for (Method method: methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }

        String className = personClass.getName();
        System.out.println(className);
    }
}
