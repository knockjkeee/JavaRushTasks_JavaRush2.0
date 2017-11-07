package Book.Test003;

import Book.Test003.Animals.Pet;

import java.util.ArrayList;

public class Pets {
    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.ctreateArray(size);
    }

    public static ArrayList<Pet> arraysList(int size) {
        return creator.arrayList(size);
    }

}
