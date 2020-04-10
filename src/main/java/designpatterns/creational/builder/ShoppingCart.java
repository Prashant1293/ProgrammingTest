package designpatterns.creational.builder;

/**
 * Builder pattern is quite helpful in the cases where there are a variety of parameters in your class and you have
 * started constructor telescoping to accommodate the instance creation based on a user's choice. For example in our
 * ShoppingCart there can be n number of items that user X would like to purchase, on the other hand another user Y
 * might like to add n-2 items or n+3 items in their cart. What we would do in that case is to create a new constructor
 * for every such scenario. Basically if there are 4 items in your mart then a particular user could buy from you in
 * (2^4-1)=15 unique ways and so 15 constructors in your class that would cover all these scenarios? Like that?
 * What happens if in future you add 3 more items in your mart then there would be (2^7-1) constructors? To avoid such
 * scenarios Builder pattern comes into picture.
 * <p>
 * This class shows how we can create & leverage builder pattern. Though, a more concrete example would be that of an
 * ingredients class but i just preferred it this way.
 */
public class ShoppingCart {
    // Quantity of product to be purchased.
    private int qty;

    private String item;

    private Double price;

    private ShoppingCart(Builder builder) {
        this.qty = builder.qty;
        this.item = builder.item;
        this.price = builder.price;
    }

    // Getters for the data members.
    public int getQty() {
        return qty;
    }

    public String getItem() {
        return item;
    }

    public Double getPrice() {
        return price;
    }

    public static class Builder {
        private int qty;
        private String item;
        private Double price;

        Builder() {
            // No-op.
        }

        public ShoppingCart build() {
            // pass some default values to your instances in case you do not want to show null or 0 to end user.
            if (this.price == null) {
                this.setPrice(1.0D);
            }

            if (this.item == null) {
                this.setItem("Item-Unknown");
            }

            return new ShoppingCart(this);
        }

        public Builder setQty(int qty) {
            this.qty = qty;
            return this;
        }

        public Builder setItem(String item) {
            this.item = item;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }
    }
}
