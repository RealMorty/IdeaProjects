package Java.src.com.hust.cqb.SuperTest.Day01.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

public class ReflectDemo03 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class personClass = Person.class;
        /**
         * 构造方法Constructor：
         *  * - `Constructor<?>[] getConstructors()`
         *  * - `Constructor<?>[] getDeclaredConstructors()`
         *  * - `Constructor<T> getConstructor(类<?>... parameterTypes)`
         *  * - `Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)`
         */
//        Constructor constructor = personClass.getConstructor(String.class, int.class);
//        System.out.println(constructor);
//        Object o = constructor.newInstance("Morty", 22);
//        System.out.println(o);

        Object o1 = personClass.newInstance();
        System.out.println(o1);

        Constructor declaredConstructor = personClass.getDeclaredConstructor(String.class, int.class);
        System.out.println(declaredConstructor);

        declaredConstructor.setAccessible(true);
        Person p = (Person) declaredConstructor.newInstance("Morty", 22);
        System.out.println(p);

        Constructor noArgsConstructor = personClass.getConstructor();
        Person p3 =(Person) noArgsConstructor.newInstance();
        p3.setName("123");
        p3.setAge(33);
        System.out.println(p3);
    }
}
