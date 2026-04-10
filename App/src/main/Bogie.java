package main;

// Reusing Bogie class from UC7
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    void display() {
        System.out.println("Bogie: " + name + " -> Capacity: " + capacity);
    }
}