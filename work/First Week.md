## First Week

* Study [Small-Simple-Safe](http://maeyler.github.io/SmallSimpleSafe/index.html) web site
* Clone this repo: git clone github.com/maeyler/BLM305
* Run sample programs: DiningPhilosophers.jar and Notepad.jar
* Start SSS and select `Chooser.runTeacher("String")`
* Select DiningPhilosophers.jar, convert it to URL, and run DiningPhilosophers until deadlock occurs
```
f = Chooser.file(); //select DiningPhilosophers.jar
i = f.toURI(); //--> file:/C:/java/jars/DiningPh...
u = i.toURL(); //--> file:/C:/java/jars/DiningPh...
Chooser.loadClass(u, "DiningPhilosophers");
d = new DiningPhilosophers(5); 
d.start();
```
* Read  http://eyler.blogspot.com.tr/2004/12/neden-java.html
