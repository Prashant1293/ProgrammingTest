package designpatterns.creational.prototype.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Item implements Cloneable {
    String itemId;
    String itemName;
    Double itemCost;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // The basic limitation with clone from Cloneable is that it doesn't support generics and thus returns an
        // Object. It was introduced with java 1.1, so no generics support for this.
        return super.clone();
    }
}
