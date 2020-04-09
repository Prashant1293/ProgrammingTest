package designpatterns.creational.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class BuilderDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger("BuilderDemo");

    public static void main(String[] args) {
        ShoppingCart shoppingCart1 = new ShoppingCart.Builder()
                .setQty(20).setPrice(5.5D).build();
        ShoppingCart shoppingCart2 = new ShoppingCart.Builder()
                .setItem("Toilet-Paper").setQty(20).build();
        ShoppingCart shoppingCart3 = new ShoppingCart.Builder()
                .setItem("Toilet-Paper").setPrice(5.5D).build();

        List<ShoppingCart> carts = Arrays.asList(shoppingCart1, shoppingCart2, shoppingCart3);
        LOGGER.info("Cart created using builder pattern, check items:");
        for (ShoppingCart cart : carts) {
            LOGGER.info("Item::{}, Quantity::{}, and Price:: {}, thanks.", cart.getItem(), cart.getQty(), cart.getPrice());
        }
    }

}
