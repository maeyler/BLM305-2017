import java.util.HashMap;
import java.util.Map.Entry;
import java.io.PrintStream;
import java.lang.reflect.Field;

class HashCounter { //collect collision statistics on a HashMap

    final Entry[] table; //java.util.Map.Entry
    final Object[] key;
    final int[] count;
    int size, sum, used, max;
    Field next;  //a little concern for efficiency

    public HashCounter(HashMap m) {
        table = (Entry[])Reflect.fieldValue(m, "table");
        size = m.size();  //map = m; 
        int n = table.length;
        key = new Object[n];
        count = new int[n];
        for (int i=0; i<n; i++) {
            Entry e = table[i];
            if (e == null) continue;
            if (next == null) 
                next = Reflect.getField(e.getClass(), "next");
            key[i] = e.getKey(); int c = 0;
            while (e != null) {
                e = (Entry)Reflect.fieldValue(e, next); c++;
            }
            count[i] = c; sum+= c; used++;
            if (c > max) max = c;
        }
    }
    public int report() { return report(System.out); }
    public void report(String fName) {
        PrintStream out;
        try {
            out = new PrintStream(fName);
         } catch (Exception x) { //FileNotFoundException
            out = System.out;
        }
        int k = report(out);
        out.close();
        System.out.printf("%s entries written to %s %n", k, fName);
    }
    int report(PrintStream out) {
        int k = 0;
        int n = table.length;
        out.printf("%n Table size: %s %n", n);
        for (int i=0; i<n; i++) 
            if (table[i] != null) {
                out.printf("%25s %s %n", key[i], count[i]); k++;
            }
        out.printf(" Map size: %s  sum: %s %n", size, sum);
        out.printf("     used: %s  max: %s %n", used, max);
        return k; 
    }

    final static HashMap<String, Integer> m = new HashMap<>();
    public static void main(String[] a) {
        m.put("small", 5);
        m.put("is->was", 7);
        m.put("beautiful", 9);
        m.put("over here", 9);
        Reflect.printTypes(m);
        
        HashCounter h = new HashCounter(m);
        Reflect.printTypes(h); h.report();
    }
}
