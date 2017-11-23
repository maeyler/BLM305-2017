package query;

public class OgrencininGuzDonemindeAldigiDersler implements Query {

    public static int DEFAULT=116690190;//Öğrencinin id'si

    
    public String defaultValue() {
        return ""+DEFAULT;
    }

    
    public String question() {
        return "Öğrencinin güz döneminde aldığı dersler.";
    }

    

    public String doQuery(Database db, String input) {

        int n = DEFAULT;
        try {
            n = Integer.parseInt(input);
	} catch(Exception e) {
		return "Lütfen yalnızca sayısal değer giriniz.";
        }
        Student s = db.findStudent(n);
        String dersler="";
        if (s!=null){


            String month="";
            String date="";

            for (String course: s.courses) {

                date=db.crs.get(course).date;  //3.01.2017

                if (date.equals(null)){

                }else {

                    for (int i = 0; i < date.length(); i++) {
                        if (date.charAt(i)=='.'){
                            month=date.substring(i+1,i+3);
                            break;
                        }
                    }

                    if (Integer.parseInt(month)>=9 || Integer.parseInt(month)<=2){
                        dersler=dersler + " " + course;
                    }
                }

            }
            return  dersler;

        }else {
            return "Öğrenci bulunamadı.";
        }
    }

    
    public String author() {
        return "Burak Uğuz";

    }



}

