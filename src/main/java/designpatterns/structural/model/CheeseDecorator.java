package designpatterns.structural.model;

import java.math.BigDecimal;

/**
 * Provides the concrete implementation for the decorated sandwich price.
 */
public class CheeseDecorator extends SandwichDecorator {
    private final BigDecimal cheesePrice = new BigDecimal("1.25");
    
    Sandwich currentSandwich;
    
    public CheeseDecorator(Sandwich currentSandwich) {
        this.currentSandwich = currentSandwich;
    }
    
    @Override
    public String getDesc() {
        return currentSandwich.getDesc() + "--Cheese Added...";
    }
    
    @Override
    public BigDecimal price() {
        return currentSandwich.price().add(cheesePrice);
    }
}
