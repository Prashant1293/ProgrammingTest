package designpatterns.creational.prototype;

import designpatterns.creational.prototype.model.Book;
import designpatterns.creational.prototype.model.Registry;
import designpatterns.creational.prototype.model.Utensil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Prototype pattern is somewhat not so much used pattern if compared to the singleton pattern which is used almost
 * extensively. The base for prototype pattern is why use new keyword every time to create an instance of an entity,
 * when we can just clone from the very first instance of that entity? When we say clone surely this takes us to
 * Shallow and Deep copy concepts of java and Cloneable interface. The class which you wish to be deemed a prototype
 * must implement the cloneable interface and provide an implementation for the clone().
 * <p>
 * That would be the base for a prototype pattern, even with the cloning part in place we still would be able to create
 * unique instances of the prototyped class. We will see this in the code below.
 * <p>
 * Typically, a prototype pattern doesn't work individually it requires a Registry for make it work conceptually.
 * <p>
 * We just have to use the new keyword once when we are creating the very first instance of an entity, newer instances
 * would be created leveraging the registry and clone() method only with defaults kicking in for fields we do not
 * provide values to in newer instances.
 */
public class PrototypeDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger("PrototypeDemo");
    // Book-id and utensil-id were Book1 and Dish1 respectively.
    private static final String BOOK_ID = "Book1";
    private static final String UTENSIL_ID = "Dish1";

    public static void main(String[] args) {
        Registry registry = new Registry();
        // Let's create an item from the Book type.
        Book book = (Book) registry.createItem(BOOK_ID);
        LOGGER.info("Book item created from registry, name= {}, author= {} and rating= {}.", book.getItemName(),
                book.getAuthor(), book.getRating());
        // Let's create an item from the Utensil type.
        Utensil utensil = (Utensil) registry.createItem(UTENSIL_ID);
        LOGGER.info("Utensil item created from registry, name= {}, model= {}, weight= {}, and price= {}.",
                utensil.getItemName(), utensil.getModelType(), utensil.getWeight(), utensil.getItemCost());

        // Now we see the usage of prototype pattern, where we would use the pre-existing Book instance and change
        // the author name and we will get a new instance without even using the new keyword.
        Book anotherBook = (Book) registry.createItem(BOOK_ID);
        anotherBook.setItemName("Prototype-Done-Right");
        LOGGER.info("Book item created from registry, name= {}, author= {} and rating= {}.", anotherBook.getItemName(),
                anotherBook.getAuthor(), anotherBook.getRating());

        // Now we'll see that both the book instances are unique, and we created the second instance without new keyword.
        LOGGER.info("The hashcode for the 2 instances of book are: book= {} & anotherBook= {}.", book.hashCode()
                , anotherBook.hashCode());

        anotherBook.setRating(15);
        LOGGER.info("Rating= {}", anotherBook.getRating());
    }

}
