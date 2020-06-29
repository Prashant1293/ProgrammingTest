package impetus;

/**
 * Java is always call-by-value, you pass primitive values from one method to another and the changes to those are not
 * reflected back in the original variables. There is a small difference when we pass objects as method params, in that
 * case a reference to the current object is passed and if we make changes to the state of variables of this object in
 * other method then they will be reflected back to the original method as the changes are associated to the current
 * instance passed.
 *
 * Next is the string creation using literal and the new keyword. With new String("") we create an instance object on the
 * heap and a literal in the string constant pool. The reference to heap instance is stored in the declared variable.
 * However in the case of using string literal to create string a literal is placed on the constant pool and a reference
 * to it is stored in the variable. == compares two strings based on their address's whether they are referencing the same
 * memory location of the created variable, however .equals() compares two strings based on the value they contain. Thus
 * IDE also shows warning when we try compare two string objects using a == and not a equals() method.
 */

public class OnCallDiscussion {
    public static void main(String[] args) {
        String s = "ABC";
        String ss = new String("ABC");
        String s1 = new String("DEF");// Creates one object on the heap and assigns its ref to s1, puts the literal in
        // string constant pool as well so that future creation of same string using literals can use the already created instance.
        String s2 = "DEF";
        String s3 = "DEF";
        
        System.out.println(s.equals(ss));
        System.out.println(s == ss);
        
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
    
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));
    }
}
