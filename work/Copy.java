package work;

import java.io.*;
import java.net.URL;

class Copy  {   //any file -- text or binary, local or remote
    final static byte[] buf = new byte[64*1024];  //common buffer
    public static int copy(InputStream in, String name) throws IOException {
        //int n = in.available();            This simple approach is
        //byte[] buf = new byte[n];          not good for remote URL's:
        //n = in.read(buf); in.close();      multiple reads are needed
        //stackoverflow.com/questions/1316360/reading-a-remote-file-using-java
        
        File g = new File(name);
        //if (g.exists()) ask user before deleting g
        FileOutputStream out = new FileOutputStream(g);
        
        int n = 0;  //total number of bytes
        int k;  //number of bytes in each read()
        while ((k = in.read(buf)) > 0) {
            out.write(buf, 0, k); n = n+k;
        } out.close();        
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
