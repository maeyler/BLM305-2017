class Point {
    int x, y; String str;
    static Rectangle a;
    public Point(int a, int b) {
        x = a; y = b;
        str = "("+x+","+y+")";
    }
    public int hashCode() {
        return str.hashCode();
    }
    public boolean equals(Object q) {
        Point p = (Point)q;
        return str.equals(p.str);
    }
    public String toString() {
        return str;
    }
    public static void main(String[] args) {
        Point p = new Point(3, 4);
        Point q = new Point(5, 8);
        a = new Rectangle(p, q); 
        System.out.println(a); 
    }
}

class Rectangle {
    //north-west and south-east corners
    Point nw, se; 
    public Rectangle(Point a, Point b) {
        nw = a; se = b;
    }
    public String toString() {
        return nw+":"+se;
    }
}

