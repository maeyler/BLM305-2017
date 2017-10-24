import java.util.*;

enum Month { Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec }

class Date {
    int day; Month mon; int year;
    public Date(int a, Month b, int c) {
        day = a; mon = b; year = c;
    }
    public String toString() {
        return day +"-"+ mon +"-"+ year;
    }
}

class Quiz1 {
    static Date p = new Date(1, Month.Jan, 2015);
    static Date q = new Date(9, Month.Jan, 1983);
    public static void main(String[] args) {
        System.out.println(p);
        System.out.println(q);
        Date[] a = { p, p, p, q, q };
        List<Date> b = Arrays.asList(a);
        System.out.println(b+" "+b.size());
        Set<Date> h = new HashSet<Date>(b);
        System.out.println(h+" "+h.size());
        System.out.println(h.contains(p));
    }
}
