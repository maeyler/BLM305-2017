import java.util.*;

class Point {
    int x, y; 
    public Point(int a, int b) { x = a; y = b; }
    public String toString() { return "("+x+", "+y+")"; }
}

abstract class Vehicle implements Comparable<Vehicle> {
    int id;    //arac numarasi, her arac icin farkli
    Point loc; //aracin yeri (x ve y koordinatlari)
    abstract String name();
    public Point location() { return loc; }
    public void moveTo(Point p) { loc = p; }
    public void moveTo(int x, int y) { 
        moveTo(new Point(x, y)); 
    }
    public void print() { 
        System.out.println(id+" at "+loc);
    }
    public int compareTo(Vehicle v) { return (id - v.id); }
    public int hashCode() { // use id as the hash code
        return id;
    }
    public boolean equals(Object x) { // is x a Vehicle with the same id?
        //if (!(x instanceof Vehicle)) return false;
        return (id == x.hashCode());
    }
    public String toString() { return name()+id; }
}

class Car extends Vehicle {
    public Car(int i) { id = i; }
    public String name() { return "Araba "; }
}

class Truck extends Vehicle {
    double cap;  //istiap haddi, yuk kapasitesi
    public Truck(int i, double p) { id = i;  cap = p; }
    public String name() { return "Kamyon "; }
}

class Midterm {
    static Vehicle[] VA;
    public static void main(String[] args) {
        Vehicle a = new Car(801);
        a.moveTo(123, 44); a.print();
        
        Vehicle b = new Truck(750, 12.5);
        b.print();
        
        VA = new Vehicle[] { a, b, b };
        Set<Vehicle> ts = new TreeSet<>();
        for (Vehicle p : VA) ts.add(p);
        for (Vehicle p : ts) System.out.println(p);
    }
}
