package query;


public class VerilenDerslikProgrami implements Query{
 public String defaultValue() { return "B1006"; }
    public String question() {
        return "Verilen dersligin ders programi ";
    }
    public String doQuery(Database db, String name){
        if(name==null) name=defaultValue();
        int n = 0; String out="NULL" ;
         for (Course c : db.crs.values()) {
          for(int i= 0 ; i<c.rooms.length; i++){
            if (c.rooms[i].equals(name)) { 
                  out += c.description()+"\n";
            }}
        }
         System.out.println("Ders Programi:"+name);
        return out;
    }
    public String author() { return "Merve Kaplan"; }
}
