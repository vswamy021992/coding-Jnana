package org.example.models;

public class PrintClass implements A, B {

    @Override
    public void print() {
        A.super.print();
    }
}

interface A {
    default void print(){
        System.out.println("A");
    }
}

interface B {
    default void print(){
        System.out.println("B");
    }
}
