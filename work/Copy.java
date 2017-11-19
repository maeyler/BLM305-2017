package work;

import java.io.*;
import java.net.URL;

class Copy  {   //any file -- text or binary, local or remote
    public static int copy(InputStream in, String name) throws IOException {
        int n = in.available(); 
        byte[] buf = new byte[n];
        n = in.read(buf); in.close();
        
        File g = new File(name);
        //if (g.exists()) ask user before deleting g
        FileOutputStream out = new FileOutputStream(g);
        out.write(buf, 0, n); out.close();
        
        System.out.println(n+" bytes copied");
        return n;
    }
    public static void copy(File f) throws IOException {
        System.out.println(f+": "+f.length());
        copy(new FileInputStream(f), f.getName()+".copy");
    }
    public static void copy(URL u) throws IOException {
        System.out.println(u);
        String name = u.getHost();
        if (name == null || name.equals("")) name = "local";
        copy(u.openStream(), name+".copy");
    }
    public static void copy(String fName) throws IOException {
        File f = new File(fName);
        if (f.exists()) copy(f);
        else copy(new URL(fName));
    }
    public static void main(String args[]) throws IOException {
        if (args.length == 0) copy("README.md"); //default
        else for (String name : args) copy(name);
    }
}
