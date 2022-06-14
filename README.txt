Il progetto è diviso in due directory:
1)Documentazione: contenente il javadoc del progetto;
2)src: contenente le cartelle lib, myTest e myAdapter;

lib contiene:
1)junit-4.13.2.jar

Matcher contiene:
1)hamcrest-core-1.3.jar;

myTest contiene tutti i file della testSuite e la classe TestRunner(main).
myAdapter contiene tutti i file per l' implementazione dell' adpaterList(interfaccie, Vector.java e ListAdapter.java)

Per la compilazione si può usare il comando(dalla directory src):
javac -cp "./lib/*;./Matcher/*" myAdapter/*.java myTest/*.java

Per l' esecuzione si può usare(dalla directory src):
java -cp "./;./lib/*;./Matcher/*" myTest.TestRunner

Per creare il javadoc si può usare(dalla directory Esame_SantarossaNoah2009671):
javadoc -d Documentazione -sourcepath src -subpackages myAdapter:myTest -cp src/lib/junit-4.13.2.jar
