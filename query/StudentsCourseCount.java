package query;

public class StudentsCourseCount implements Query{
    final static int DEFAULT = 13;
    //bu class parametre olarak verilen sayi kadar ders alan ogrencilerin
    //isimlerini ve aldigi dersleri dondurur.
     
 public String defaultValue() { return ""+DEFAULT; }
    public String question() {
        return "Find the students which have given number course count.\n Default Value is 13 ";
    }
    public String doQuery(Database db, String n){
       String out="---Students that have "+n+" courses---\n";
       int count = DEFAULT;
       try {
        count = Integer.parseInt(n);
        } 
        catch(Exception e) {
        }
       
         for (Student s : db.std.values()) {//datadan student objeleri birer birer if kosuluna girer  
              if (s.courses.length==count) {       
              out+="-----Student Id and Student Name -----\n";       
              out+=s.id+ "-"+ s.name+"\n";
              out+="-----COURSES-----\n";
              for (int i = 0; i < s.courses.length; i++) {
              out+=s.courses[i]+"-";
              if(i==s.courses.length-1){ 
              out+=s.courses[i]+"\n";}}}}    
              return out;
}
    public String author() { return "Sevgi Nur Bilgin"; }
}
