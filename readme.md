# Build and run, package and run package

In project root folder, i.e. project01am <br />
To compile <br />
1. javac -d bin --source-path . ./*.java Card/*.java
   
To run the compile bytecode (.class) main entrypoint <br />
java -cp bin <packageName>.<ClassName> <br />
2. java -cp bin project01am.App 

To package into jar file, go into the bin folder <br />
3. jar -c -v -f day09.jar -e project01am.App . 

To run the jar file inside the bin folder where the jar is created <br />
4. java -jar day09.jar

To run the jar file in the project root folder (outside the bin folder) <br />
5. java -jar bin/day09.jar