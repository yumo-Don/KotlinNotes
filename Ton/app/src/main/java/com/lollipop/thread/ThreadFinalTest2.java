package com.lollipop.thread;

public class ThreadFinalTest2 {
    public static void main(String[] args) throws InterruptedException {
        Person person = new Person("THC");
        new Thread(() -> person.setName("YM")).start();

        Thread.sleep(1000);
        System.out.println(person.name);
    }


    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }


    }
}

