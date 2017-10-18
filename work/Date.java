enum Month { Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec }

public class Date implements Comparable<Date> {

    public static Class M = Month.class;
    int day; Month mon; int year; int hash;
    
    public Date(int d, Month m, int y) {
        day = d; mon = m; year = y;
        hash = 400*y+31*m.ordinal()+d;
    }
    public int hashCode() {
        return hash;
    }
    public boolean equals(Object x) {
        if (!(x instanceof Date)) return false;
        Date d = (Date)x;
        return (hash == d.hash);
    }
    public int compareTo(Date d) {
        return (hash - d.hash);
    }
    public String toString() { // "Jan 1, 2015"
        return mon+" "+day+", "+year;
    }
    public static void main(String[] args) {
        Date p = new Date(1, Month.Jan, 2015);
        Date q = new Date(9, Month.Jan, 1983);
        System.out.println(p+"\n"+q);
    }
}
