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
    
    int x = 10;
    
    String myName = "Prashant";
}

class Child extends Parent {
    void call() {
        super.call();
        System.out.println("From child....");
    }
    
    void call(int a) {
        System.out.println("Only from child....." + a);
    }
    
    void getVariables() {
        System.out.println("Variables in the base class:: x = " + x + " and myName = " + myName);
    }
    
    void setBaseClassVariables(int value, String name) {
        this.x = value;
        this.myName = name;
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
        
        System.out.println("Recently there was a question: can we set the base class variables from a method of the "
                + "child class using keyword \"this\"? answer: yes we can do, see the output below: the values for "
                + "base class variables x and myName are being updated/set from the child class.");
        System.out.println("Base class values =>");
        child.getVariables();
        System.out.println("Update the base class values from the child class using the \"this\" keyword.");
        child.setBaseClassVariables(50, "Sharma_Prashant");
        System.out.println("Base class values =>");
        child.getVariables();
    }
}
