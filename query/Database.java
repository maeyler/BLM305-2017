package query;

import java.io.*;
import java.util.*;

class Database {
    final static String
        LINE_SEP = System.getProperty("line.separator");
    Map<String, Course> crs = new LinkedHashMap<>();
    Map<Integer, Student> std = new LinkedHashMap<>();
    public Database() { 
        File g = new File("data", "Courses.txt");
        File f = new File("data", "Students.txt");
        try {
            for (String line : readLines(g)) { 
                Course c = new Course(line);
                crs.put(c.name, c);
            }
            for (String line : readLines(f)) { 
                Student s = new Student(line);
                std.put(s.id, s);
            }
        } catch (IOException x) {
            System.out.println(x);
        }
    }
    static String[] readLines(File f) throws IOException {
            System.out.printf("%s %s bytes %n", f, f.length());
            InputStream in = new FileInputStream(f);
            byte[] ba = new byte[in.available()];
            in.read(ba); in.close(); 
            String str = new String(ba, "Cp1254");
            String[] sa = str.split(LINE_SEP);
            System.out.printf("%s satir okundu %n", sa.length);
            return sa;
    }
    public Course findCourse(String s) {
        return crs.get(s.toUpperCase());
    }
    public Student findStudent(int k) {
        return std.get(k); 
    }
    public void examSchedule(String id) {
        Query q = new ExamSchedule();
        System.out.println(q.question());
        System.out.println(q.doQuery(this, id));
    }
    public void randomStudents(int n) {
        Query q = new RandomStudents();
        System.out.println(q.question());
        System.out.println(q.doQuery(this, ""+n));
    }
    public void testCases() {
        findCourse("math 206").print();
        findStudent(116821617).print();
        examSchedule("214012018");
        randomStudents(5); 
    }
    
    public static void main(String[] args) {
        new Database().testCases(); 
    }
}
