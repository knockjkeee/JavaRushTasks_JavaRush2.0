package Book.Test003;

import Book.Test003.Animals.Pet;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

    private static String[] typeNames = {
            "Book.Test003.Animals.Mutt",
            "Book.Test003.Animals.Pug",
            "Book.Test003.Animals.EgyptianMau",
            "Book.Test003.Animals.Manx",
            "Book.Test003.Animals.Cymric",
            "Book.Test003.Animals.Rat",
            "Book.Test003.Animals.Mouse",
            "Book.Test003.Animals.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    public  List<Class<? extends Pet>> types() {
        return types;
    }
}
