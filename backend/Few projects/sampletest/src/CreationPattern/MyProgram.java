package CreationPattern;

interface Animal {
    void makeSound();
}

class Wolf implements Animal {
    public void makeSound() {
        System.out.println("The wolf makes the sound 'ouuuuuuu'.");
    }
}

class Lion implements Animal {
    public void makeSound() {
        System.out.println("The lion makes a roaring sound.");
    }
}

class Tiger implements Animal {
    public void makeSound() {
        System.out.println("The tiger makes a growling sound.");
    }
}

class SoundMaking {
    public Animal getAnimalProcess(String animalType) {
        if (animalType == null) {
            return null;
        }
        if (animalType.equalsIgnoreCase("WOLF")) {
            return new Wolf();
        } else if (animalType.equalsIgnoreCase("LION")) {
            return new Lion();
        } else if (animalType.equalsIgnoreCase("TIGER")) {
            return new Tiger();
        }
        return null;
    }
}

public class MyProgram {
    public static void main(String[] args) {
        SoundMaking sound = new SoundMaking();

        Animal animal1 = sound.getAnimalProcess("WOLF");
        animal1.makeSound();

        Animal animal2 = sound.getAnimalProcess("LION");
        animal2.makeSound();

        Animal animal3 = sound.getAnimalProcess("TIGER");
        animal3.makeSound();
    }
}
