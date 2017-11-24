package query;

import java.util.Map;

public class CoursesStudents implements Query {
    public String defaultValue() { return "PSY 203"; }
    public String question() {
        return "List of students who takes the course with given name";
    }
    public String doQuery(Database db, String name) {
        String out="";
        Map<String, Course> cs=db.crs;
        Map<Integer,Student> std=db.std;
        int studentsCount=0;
        if(!cs.containsKey(name))
            out="Böyle bir ders mevcut değil.";
        else{
            out=name+" isimli dersi alan öğrenciler : \n";
                for(Student s:std.values()){
                    for(String nm:s.courses){
                        if(nm.equals(name)){
                        studentsCount++;
                        out=out+"-> ID: "+s.id+" Name: "+s.name+" GPA: "+s.gpa+"\n";
                        }
                    }
                }
            out=out+"Dersi alan toplam öğrenci sayısı : "+studentsCount;
           }
        return out;
    }
    public String author() { return "Emrah Y TEMA"; }
}
