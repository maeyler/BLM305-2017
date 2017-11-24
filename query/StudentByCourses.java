package query;

public class StudentByCourses implements Query {
    public String defaultValue() {
        return "math 206";
    }

    public String question() {
        return "Dersi alan ogrencileri listele";
    }

    public String doQuery(Database db, String name) {
        if (name == null) name = defaultValue();
        int n = 0;
        String out = name + "\n";
        for (Student s : db.std.values()) {
            for (int i = 0; i<s.courses.length;i++){
                if (s.courses[i].equals(name.toUpperCase())) {
                    out += s.name + "  ";
                    n++;
                }
            }
        }
        System.out.println(n + " students: " + name);
        return out;
    }

    public String author() {
        return "IbrahimEnesAydogdu";
    }
}
