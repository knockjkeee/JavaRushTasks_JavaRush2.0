package Book.Test003;

import Book.Test003.Animals.*;

import java.util.HashMap;

public class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void counter(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }

        }

        public static void countPets(PetCreator creator) {
            PetCounter counter = new PetCounter();
            for (Pet pet : creator.ctreateArray(20)) {
                System.out.print(pet.getClass().getSimpleName() + " ");
                if (pet instanceof Pet) {
                    counter.counter("Pet");
                }
                if (pet instanceof Dog) {
                    counter.counter("Dog");
                }
                if (pet instanceof Mutt) {
                    counter.counter("Mutt");
                }
                if (pet instanceof Pug) {
                    counter.counter("Pug");
                }
                if (pet instanceof Cat) {
                    counter.counter("Cat");
                }
                if (pet instanceof Manx) {
                    counter.counter("EgyptianMau");
                }
                if (pet instanceof Manx) {
                    counter.counter("Manx");
                }
                if (pet instanceof Manx) {
                    counter.counter("Cymric");
                }
                if (pet instanceof Rodent) {
                    counter.counter("Rodent");
                }
                if (pet instanceof Rat) {
                    counter.counter("Rat");
                }
                if (pet instanceof Mouse) {
                    counter.counter("mouse");
                }
                if (pet instanceof Hamster) {
                    counter.counter("Hamster");
                }
            }
            System.out.println();
            System.out.println(counter);
        }
        public static void main(String[] args) {
            countPets(new ForNameCreator());
        }

    }


}
