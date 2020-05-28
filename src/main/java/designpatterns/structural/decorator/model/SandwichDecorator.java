package designpatterns.structural.decorator.model;

import java.math.BigDecimal;

/**
 * The decorator class to extend the base Sandwich class. This way we can make sure that on runtime we can replace the
 * concrete Sandwich instance with the Decorator instance as per the user's request.
 */
public abstract class SandwichDecorator extends Sandwich {
    @Override
    public abstract BigDecimal price();
}
