package Book.Test003;

import Book.Test003.Animals.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator {
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allType =
            Collections.unmodifiableList(Arrays.asList(Pet.class, Dog.class,
                    Cat.class, Rodent.class, Mutt.class, Pug.class, EgyptianMau.class,
                    Manx.class, Cymric.class, Rat.class, Mouse.class, Hamster.class));
    private static final List<Class<? extends Pet>> types = allType.subList(allType.indexOf(Mutt.class), allType.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }




}
