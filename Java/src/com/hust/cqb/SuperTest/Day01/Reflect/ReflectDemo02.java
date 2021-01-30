package Java.src.com.hust.cqb.SuperTest.Day01.Reflect;

import java.lang.reflect.Field;

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

public class ReflectDemo02 {
    public static void main(String[] args) {
        Class personClass = Person.class;
        /**
         * 成员变量Fields：
         *  * - `Field[] getFields()`
         *  * - `Field[] getDeclaredFields()`
         *  * - `Field getField(String name)`
         *  * - `Field[] getDeclaredField(String name)`
         */
        Field[] fields = personClass.getFields();
        for (Field field: fields) {
            System.out.println(field);
        }
        System.out.println("------------");
        try {
            Field a = personClass.getField("a");
            Person p = new Person();
            Object value = a.get(p);
            System.out.println(value);
            a.set(p, "Morty");
            System.out.println(p);

            System.out.println("-----------");
            Field[] b= personClass.getDeclaredFields();
            for (Field field: b) {
                System.out.println(field.getName());
            }

            Field b1 = personClass.getDeclaredField("b");
            Object value2 = b1.get(p);
            System.out.println(value2);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
