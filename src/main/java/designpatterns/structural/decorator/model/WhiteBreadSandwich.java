package designpatterns.structural.decorator.model;

import java.math.BigDecimal;

/**
 * This is one of the possible concrete implementations for the sandwich class. There could be other implementations
 * as well like the BrownBreadSandwich or BeefSandwich or LettuceSandwich etc. Important thing to note here is that
 * every sandwich type must have its own price, so we have to override the price() from parent {@link Sandwich} class.
 *
 * This is not yet decorated, it would be decorated if during runtime user wants to add additional items to the sandwich.
 * Like if they need cheese burst, or tomato and Onion pieces spread over the patty, etc. This is what decoration means.
 * We define decorators as the same type of the object being decorated, see {@link SandwichDecorator} class, it extends
 * {@link Sandwich} class.
 */
public class WhiteBreadSandwich extends Sandwich {
    public WhiteBreadSandwich(String description) {
        desc = description;
    }
    
    @Override
    public BigDecimal price() {
        return new BigDecimal("5.0");
    }
}
