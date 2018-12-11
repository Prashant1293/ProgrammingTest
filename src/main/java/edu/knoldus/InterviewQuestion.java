package edu.knoldus;

class Parent {
    void call() {
        System.out.println("From Parent....");
    }
}

class Child extends Parent {
    void call() {
        super.call();
        System.out.println("From child....");
    }
    
    void call(int a) {
        System.out.println("Only from child....." + a);
    }
}

public class InterviewQuestion {
    
    public static void main(String[] args) {
        // Throws null pointer exception.
        /*String str1 = null;
        System.out.println(str1.length());*/
        
        Child child = new Child();
        child.call();
        child.call(5);
        
        int i = 5, j = 5, k = 5, l = 0;
        i = i++;
        System.out.println("i = " + i);
        j = ++j;
        l = k++;
        System.out.println("j = " + j);
        System.out.println("l = " + l + " k = " + k);
    }
}
