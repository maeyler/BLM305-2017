enum Food { bread, soup, meat, fruit }

abstract class Pet implements Comparable<Pet> {
    String name;
    abstract boolean eats(Food f);
    abstract String sound();
    public void talk() {
        System.out.println(name+": "+sound());
    }
    public int compareTo(Pet p) { return name.compareTo(p.name); }
    public String toString() { return name; }
}

class Cat extends Pet {
    int birth;
    public Cat(String s, int b) {
        name = "Kedi "+s; birth = b;
    }
    public boolean eats(Food f) { return (f == Food.meat); }
    public String sound() { return "miyav"; }
}

class Bird extends Pet {
    float price; 
    public Bird(String s, float p) {
        name = "Kush "+s;  price = p;
    }
    public boolean eats(Food f) { return true; }
    public String sound() { return "cik cik"; }
}

class PetHouse {
    public static void main(String[] args) {
        Pet a = new Cat("Kartopu", 2010);
        Pet b = new Bird("Patpat", 30);
        Pet c = new Bird("Safran", 45);
        Pet[] pets = { a, b, c };
        for (Pet p : pets) p.talk();
    }
}
