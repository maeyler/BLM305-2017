package query;

class Course {
    final String name, time, date;
    final String[] rooms;
    public Course(String line) {
        String[] a = line.split("\t");
        name = a[0]; time = a[1]; 
        date = (a[2].length()<10? "0"+a[2] : a[2]);
        rooms = new String[a.length-3];
        for (int j=3; j<a.length; j++) 
            rooms[j-3] = a[j]; 
    }
    public String toString() { return name; }
    public String description() { return date+" "+time+" "+name; }
    public int hashCode() { return name.hashCode(); }
    public boolean equals(Object x) {
        if (!(x instanceof Course)) return false;
        Course c = (Course)x; 
        return name.equals(c.name);
    }
    public void print() {
        System.out.printf("%s %s %s ", name, time, date);
        for (String s : rooms) System.out.print(" "+s);
        System.out.println();
    }
}
