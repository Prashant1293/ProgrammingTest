package edu.knoldus;

class Parent {
    void call() {
        System.out.println("From Parent....");
    }
    
    void print(Object name) {
        System.out.println(name);
    }
    
    void print(String name) {
        System.out.println("Hi string" + name);
    }
    
    void print(Integer name) {
        System.out.println("Hi Integer" + name);
    }
    
    void print(int name) {
        System.out.println("Hi int" + name);
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
        
        Parent parent = new Parent();
        Child child = new Child();
        child.call();
        child.call(5);
        
        int i = 5, j = 5, k = 5, l = 0;//by default the int's would have 0 as their value so l=0 would result in a warning here.
        i = i++;
        System.out.println("i = " + i);
        j = ++j;
        l = k++;
        System.out.println("j = " + j);
        System.out.println("l = " + l + " k = " + k);
        parent.print(Integer.valueOf("50"));
        parent.print("Prashant");
        parent.print(Object.class.cast("77"));
        parent.print(Integer.parseInt("5"));
    }
}
