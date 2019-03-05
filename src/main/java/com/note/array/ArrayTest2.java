package com.note.array;

import org.junit.Test;

import java.util.Objects;

/**
 * @Author 杨群
 * @Date 2019/3/5 21:50
 */
public class ArrayTest2 {


    @Test
    public void removeGeneric(){
        Array<User> users = new Array<>();

        users.addLast(new User("Alice" , 12));
        users.addLast(new User("Bob" , 13));
        users.addLast(new User("Charlie" , 14));
        System.out.println(users);

        System.out.println(users.find(new User("Bob" , 13)));
    }




    class User{
        private String name;
        private int age;

        public User(String name, int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
