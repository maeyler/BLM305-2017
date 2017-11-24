package query;
import java.util.*;

public class Top3StudentsOfGivenCourse implements Query {
    final static String DEFAULT = "MATH 205";

    public String defaultValue() { 
        return DEFAULT;
    }

    public String question() {
        return "Top 3 students of given course ";
    }

    public String doQuery(Database db, String input) {
        String ders="";

        if (input == "") ders = defaultValue();
        else ders = input;
        
        String out = "";
        Student[] aa = db.std.values().toArray(new Student[0]);

        List<Student> list = new ArrayList<>(); 
        //for (Student s: db.std.values()) { //dersi alan ogrencileri arrayliste ekler.
         for (int i = 0; i < db.std.size(); i++) {
            for (int j = 0; j < aa[i].courses.length; j++) {
                 if ( aa[i].courses[j].contains(ders)) {
                    list.add(aa[i]);
                    break;
                 }
              /*for (String t : s.courses) {
                 Course c = db.findCourse(t);
                if (c.name == ders) {
                    list.add(s);
                    break;
                }*/
              } 
        }

        out += list.size() + " ogrencinin aldigi " + ders +" dersindeki en iyi 3 ogrenci: " + " \n";

        float first=(float)0,second=(float)0,third=(float)0;
        int firstS=0,secondS=0,thirdS=0;

        for(Student s: list){
            if(first < s.gpa){
                first = s.gpa;
                firstS = s.id;
            }
        }
        Student s1 = db.findStudent(firstS);
        out += "1.ogrenci = " + s1.description() + " \n";

        for(Student s: list){
            if(second < s.gpa && s.gpa < first){
                second = s.gpa;
                secondS = s.id;
            }
        }
        Student s2 = db.findStudent(secondS);
        out += "2.ogrenci = " + s2.description() + " \n";

        for(Student s: list){
            if(third < s.gpa && s.gpa < first){
                third = s.gpa;
                thirdS = s.id;
            }
        }
        Student s3 = db.findStudent(thirdS);
        out += "3.ogrenci = " + s3.description() + " \n";
        
        return out;
    }

    public String author() { 
        return "Enes Kamil YILMAZ"; 
    }

}