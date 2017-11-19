package query;

class Student {
    final int id; 
    final String name; float gpa;
    final String[] courses;
    public Student(String line) {
        String[] a = line.split("\t");
        int k = Integer.parseInt(a[0]);
        float g = Float.parseFloat(a[2]);
        id = k; name = a[1]; gpa = g;
        courses = new String[a.length-3];
        for (int j=3; j<a.length; j++) 
            courses[j-3] = a[j]; 
    }
    public String toString() { return name; }
    public String description() { return id+" "+name+" "+gpa; }
    public int hashCode() { return id; }
    public boolean equals(Object x) {
        if (!(x instanceof Student)) return false;
        Student s = (Student)x; 
        return (s.id == id);
    }
    public void print() {
        System.out.printf("%s %s %.2f ", id, name, gpa);
        for (String c : courses) System.out.print(" "+c);
        System.out.println();
    }
}
