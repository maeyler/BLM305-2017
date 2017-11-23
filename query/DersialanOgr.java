
package query;


public class DersialanOgr  implements Query{
final static String DEFAULT= "PSY 261";
    @Override
    public String defaultValue() {
     return DEFAULT;
    }

    @Override
    public String question() {
        return "Dersi alan ögrencileri bul";
    }

    @Override
    public String doQuery(Database db, String derslik) {
     System.out.println(derslik + " dersini alan ogrenciler: ");
      String out = "";
         Student[] aa = db.std.values().toArray(new Student[0]);
        for (int i = 0; i < db.std.size(); i++) {
          
            for (int j = 0; j < aa[i].courses.length; j++) {
          
                if ( aa[i].courses[j].contains(derslik)) {
                  
             
               
                  
                   out +=aa[i].id+" "+ aa[i].name+"\n"; 
              
                }
            }
        }

       return out;
    
    }
        

    @Override
    public String author() {
       return "Selin Daldaban";
    }
    
}

