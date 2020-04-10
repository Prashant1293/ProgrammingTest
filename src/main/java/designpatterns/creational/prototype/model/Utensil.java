package designpatterns.creational.prototype.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Builder(toBuilder = true)
@Getter
@Setter
public class Utensil extends Item {
    @NonNull
    Double weight;

    String modelType;

    enum makeType {BRONZE, SILVER, GOLD, PLATINUM}
}
