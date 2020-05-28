package designpatterns.structural.model;

import java.math.BigDecimal;

/**
 * This is the base class that would be used for any Sandwich. Extend this with a concrete implementation of the sandwich.
 */
public abstract class Sandwich {
    protected String desc = "Sandwich";
    
    public String getDesc() {
        return desc;
    }
    
    public abstract BigDecimal price();
    
}
