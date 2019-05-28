package com.demo.base;

import com.demo.core.Person;

/**
 * Description
 *
 * @author: zhangb
 */
public class FinalExample {
    public static final Person person = new Person(35, 170);
    public static int age = 35;

    public static void main(String args[]) {
        person.age = 25;
        System.out.println(person.toString());
        age = 25;
        System.out.println(age);
    }

    static class Person {
        private int age;
        private int height;

        public Person(int age, int height) {
            this.age = age;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", height=" + height +
                    '}';
        }
    }

}
