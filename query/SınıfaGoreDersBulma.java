package query;

public class SinifaGoreDersBulma implements Query {
    public String defaultValue() { return "GG307"; }
    public String question() {
        return "Girilen Sinifta Islenen Dersler";
    }
    public String doQuery(Database db, String roomName)
    {

        String out = "";
        for(Course c:db.crs.values()){
            for(String s:c.rooms){
                if(s.equals(roomName)){
                    out=out+c.name+"\n";
                    break;
                }           
            }
        }
        if(out==null)
            return "Böyle bir sinif yok";
        else
            return out;

    }
    public String author() { return "Muhammet Ali Gülbahçe"; }
}
