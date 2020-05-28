package designpatterns.structural.model;

import java.math.BigDecimal;

/**
 * Provides the concrete implementation for the decorated sandwich price.
 */
public class LettuceDecorator extends SandwichDecorator {
    private final BigDecimal lettucePrice = new BigDecimal("0.45");
    
    Sandwich currentSandwich;
    
    public LettuceDecorator(Sandwich currentSandwich) {
        this.currentSandwich = currentSandwich;
    }
    
    @Override
    public String getDesc() {
        return currentSandwich.getDesc() + "--Lettuce Added...";
    }
    
    @Override
    public BigDecimal price() {
        return currentSandwich.price().add(lettucePrice);
    }
}
