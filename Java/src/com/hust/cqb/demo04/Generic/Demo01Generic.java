package com.hust.cqb.demo04.Generic;

/**
 * @author : JavaMorty
 * @date :定义一个含有泛型的类
 */
public class Demo01Generic<E> {
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
