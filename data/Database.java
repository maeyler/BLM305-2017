import java.io.*;
import java.util.*;

class Database {
    final static String
        LINE_SEP = System.getProperty("line.separator"), TAB = "\t";
    Collection<Student> data = new ArrayList<>(); //Q3
        // or new HashSet<>(); -- TreeSet is not applicable
    Map<Integer, Student> map = new TreeMap<>(); //Q5
    public Database(File f) { 
        System.out.printf("%s %s bytes %n", f, f.length());
        try {
            InputStream in = new FileInputStream(f);
            byte[] ba = new byte[in.available()];
            in.read(ba); in.close(); 
            String str = new String(ba, "Cp1254");
            String[] sa = str.split(LINE_SEP);
            System.out.printf("%s satir okundu %n", sa.length);
            for (String s : sa) { readLine(s); }
        } catch (IOException x) {
            System.out.println(x);
        }
    }
    void readLine(String line) {
        String[] a = line.split(TAB);
        int k = Integer.parseInt(a[0]);
        float g = Float.parseFloat(a[2]);
        Student s = new Student(k, a[1], g);
        data.add(s);
        for (int j=3; j<a.length; j++) 
            s.addCourse(a[j]); 
        map.put(k, s); //Q5
    }
    public Student findStudent(int k) { //Q4
        for (Student s : data)
            if (s.id == k) return s;
        return null;
    }
    public Student findFast(int k) { //Q5
        return map.get(k);
    }
    public void printStudent(Student s) {
        if (s == null) System.out.printf("%s not found %n", s);
        else {
            final String f = "%s %s %.2f %s%n";
            System.out.printf(f, s.id, s.name, s.gpa, s.courses);
        }
    }
    public void printCourse(String code) { //sinavda sorulmadi
        code = code.toUpperCase();
        System.out.print(code+": [ ");
        for (Student s : data)
            if (s.courses.contains(code)) 
                System.out.print(s.name+' ');
        System.out.println(']');
    }
    public void printCourses(boolean list) { //Q6
        Set<String> set = new TreeSet<>();
        for (Student s : data)
            set.addAll(s.courses);
        if (list) System.out.println(set); 
        System.out.println(set.size()+" ders");
    }
    public void printStudents(int n) {
        Student[] a = data.toArray(new Student[0]); //Q9
        while (n > 0) {
            int i = (int)(Math.random()*a.length);
            printStudent(a[i]); n--;
        }
    }
    public void doQuestions() {
        System.out.println("Q1. Ayse Kaya icin bir kayit olusturun");
        Student s = new Student(1234, "Ayse Kaya", 2.05f);
        s.addCourse("BLM 401"); s.addCourse("Math 254");
        printStudent(s); 
        System.out.println("Q3. Okulda "+data.size()+" ogrenci var");
        System.out.println("Q5. Numarasi verilen bir ogrenciyi bulun");
        printStudent(findFast(214001771));
        System.out.print("Q6. Acilan ders sayisi: ");
        printCourses(false);  
        System.out.print("Q7. HashSet h.size(): ");
        Set<Student> h = new HashSet<>(data);
        System.out.println(h.size());
        System.out.println("Q8. Bir dersi alan ogrenci isimleri");
        printCourse("math 206"); 
        System.out.println("Q10. Rastgele 5 ogrencinin listesi");
        printStudents(5);
    }
    
    public static void main(String[] args) {
        File f = new File("data", "Students.txt");
        new Database(f).doQuestions();
    }
}
