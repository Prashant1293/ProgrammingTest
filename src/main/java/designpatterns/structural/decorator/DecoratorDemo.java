package designpatterns.structural.decorator;

import designpatterns.structural.model.CheeseDecorator;
import designpatterns.structural.model.LettuceDecorator;
import designpatterns.structural.model.Sandwich;
import designpatterns.structural.model.WhiteBreadSandwich;

/**
 * Decorator Pattern should be considered in the scenarios where we have a base object with us and we want to decorate
 * that object at runtime based on the user demand. For example, let say you need a burger. A burger has a price
 * associated with it. Now this price would change dynamically at runtime if you would like to have the burger with
 * add-ons that is have it decorated. You could ask for a cheese burger or for a grilled burger or for a non-veg burger.
 * All these decorations would be done on the base burger so choosing the decorator pattern would be good here.
 * <p>
 * It is critical requirement that the decorator object must be of the same type as that of the object being decorated.
 */
public class DecoratorDemo {
    
    public static void main(String[] args) {
        // Get a Sandwich man.
        Sandwich sandwich = new WhiteBreadSandwich("White Bread Sandwich");
        System.out.println("Sandwich created, description = " + sandwich.getDesc() + ", and the price is = " + sandwich.price());
        // Cheese Burst the sandwich for god sake.
        Sandwich cheeseSandwich = new CheeseDecorator(sandwich);
        System.out.println("Sandwich created, description = " + cheeseSandwich.getDesc() + ", and the price is = " + cheeseSandwich.price());
        
        // Can we include lettuce as well in the sandwich?
        Sandwich lettuceSandwich = new LettuceDecorator(cheeseSandwich);
        System.out.println("Sandwich created, description = " + lettuceSandwich.getDesc() + ", and the price is = " + lettuceSandwich.price());
    }
}
