package query;

import java.util.Map;
import java.util.HashMap;

public class CourseCounter implements Query {
    final static String DEFAULT = "BIL 101";
	static Map<String,Integer> counterMap;

    public String defaultValue() { return ""+DEFAULT; }
    public String question() {
        return "Course counter. Please, enter an course code";
    }
    public String doQuery(Database db, String id) {
		if( counterMap == null ) {
			counterMap = new HashMap<>();
			for ( Student s : db.std.values() ) {
				for (String course : s.courses) {
		            Integer i = counterMap.get(course);
		            if (i == null)
		                counterMap.put(course, 1);
		            else
		                counterMap.put(course, i + 1);
				}
			}
		}

		String out = id + "\n";

        Integer count = counterMap.get(id);
		if (count == null) 
			out += "no one enrolled the given course.\n";
		else 
			out += "Given course enrolled from " +count + " different students.\n" ;
   
        return out;
    }
    public String author() { return "Bilal Ekrem HARMANSA"; }
}

